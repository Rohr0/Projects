package com.wellsfargo.counselor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wellsfargo.counselor.dao.AdvisorDao;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.exceptions.IdNotFoundExpection;

@Service
public class AdvisorService {
	@Autowired
	private AdvisorDao dao;

	public ResponseEntity<ResponseStructure<Advisor>> saveAdvisor(Advisor a) {
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		structure.setData(dao.saveAdvisor(a));
		structure.setMessage("Advisor created with ID : " + a.getAdvisorId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Advisor>> updateAdvisor(Advisor a) {
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		structure.setData(dao.updateAdvisor(a));
		structure.setMessage("Advisor saved with ID : ");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Advisor>> findById(int id) {
		ResponseStructure<Advisor> structure = new ResponseStructure<>();
		Optional<Advisor> advisor = dao.findById(id);
		if (advisor.isPresent()) {
			structure.setData(advisor.get());
			structure.setMessage("Data Found Id:");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Advisor>>(structure, HttpStatus.OK);
		} else
			throw new IdNotFoundExpection();
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Advisor> rs = dao.findById(id);
		if (rs.isPresent()) {
			structure.setData("User Found");
			structure.setMessage("User Deleted");
			structure.setStatusCode(HttpStatus.OK.value());
			dao.deleteAdvisor(id);
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} 
		else 
			throw new IdNotFoundExpection();
	}
}
