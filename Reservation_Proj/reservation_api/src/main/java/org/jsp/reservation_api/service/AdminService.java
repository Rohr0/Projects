package org.jsp.reservation_api.service;

import java.util.Optional;

import org.jsp.reservation_api.Exception.IdNotFoundException;
import org.jsp.reservation_api.Exception.InvalidCredentialsException;
import org.jsp.reservation_api.dao.AdminDao;
import org.jsp.reservation_api.dto.Admin;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin a){
		ResponseStructure<Admin> s=new ResponseStructure<>();
		s.setData(dao.saveAdmin(a));
		s.setMessage("Admin Added"+a.getId());
		s.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin a){
		ResponseStructure<Admin> s=new ResponseStructure<>();
		s.setData(dao.updateAdmin(a));
		s.setMessage("Admin Added"+a.getId());
		s.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Admin>> findById(int id){
		ResponseStructure<Admin> s=new ResponseStructure<>();
		Optional<Admin> recAdmin=dao.findById(id);
		if(recAdmin.isPresent()) {
			s.setData(recAdmin.get());
			s.setMessage("Admin Found");
			s.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(s, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Admin>> verify(long phone, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> rs = dao.verify(phone, password);
		if (rs.isPresent()) {
			structure.setData(rs.get());
			structure.setMessage("User Phone-Number Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} 
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<Admin>> verify(String email, String password) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		Optional<Admin> rs = dao.verify(email, password);
		if (rs.isPresent()) {
			structure.setData(rs.get());
			structure.setMessage("User Phone-Number Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		} 
		throw new InvalidCredentialsException();
	}

}
