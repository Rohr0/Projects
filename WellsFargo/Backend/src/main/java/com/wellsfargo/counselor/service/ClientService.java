package com.wellsfargo.counselor.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wellsfargo.counselor.dao.AdvisorDao;
import com.wellsfargo.counselor.dao.ClientDao;
import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.exceptions.IdNotFoundExpection;

@Service
public class ClientService {
	@Autowired
	private ClientDao cdao;
	@Autowired
	private AdvisorDao adao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client c, int advisorId) {
		Optional<Advisor> advisor = adao.findById(advisorId);
		ResponseStructure<Client> s = new ResponseStructure<>();
		if (advisor.isPresent()) {
			Advisor a = advisor.get();
			a.getClients().add(c);
			c.setAdvisor(a);
			adao.updateAdvisor(a);
			cdao.saveClient(c);

			s.setData(c);
			s.setMessage("Client Added");
			s.setStatusCode(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Client>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundExpection();
	}

	public ResponseEntity<ResponseStructure<Client>> updateClient(Client c, int advisorId) {
		Optional<Advisor> advisor = adao.findById(advisorId);
		ResponseStructure<Client> s = new ResponseStructure<>();
		if (advisor.isPresent()) {
			Advisor a = advisor.get();
			c.setAdvisor(a);
			cdao.saveClient(c);

			s.setData(c);
			s.setMessage("Client Details Updated");
			s.setStatusCode(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<Client>>(s, HttpStatus.OK);
		}
		throw new IdNotFoundExpection();
	}

	public ResponseEntity<ResponseStructure<Client>>findById(int id){
		ResponseStructure<Client> s=new ResponseStructure<>();
		Optional<Client> client=cdao.findById(id);
		if(client.isPresent()) {
			s.setData(client.get());
			s.setMessage("Client Data Found");
			s.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Client>>(s,HttpStatus.FOUND);
		}
		throw new IdNotFoundExpection();
	}
	public ResponseEntity<ResponseStructure<String>> deleteClient(int id){
		ResponseStructure<String> s=new ResponseStructure<>();
		Optional<Client> recProd=cdao.findById(id);
		if(recProd.isPresent()) {
			s.setData("Item Deleted");
			s.setMessage("Product Found");
			s.setStatusCode(HttpStatus.OK.value());		
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.OK);
		}
		throw new IdNotFoundExpection();
	}
}
