package com.wellsfargo.counselor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	private ClientService service;
	
	@PostMapping("/advisor/client/{advisorId}")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client c,@PathVariable int advisorId){
		return service.saveClient(c, advisorId);
	}
	

}
