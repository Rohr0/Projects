package com.wellsfargo.counselor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.service.AdvisorService;

@RestController
public class AdvisorController {
	@Autowired
	private AdvisorService service;

	@PostMapping("/advisor")
	private ResponseEntity<ResponseStructure<Advisor>> saveAdvisor(@RequestBody Advisor a) {
		return service.saveAdvisor(a);
	}

	@PutMapping("/advisor")
	private ResponseEntity<ResponseStructure<Advisor>> updateAdvisor(@RequestBody Advisor a) {
		return service.updateAdvisor(a);
	}
	
	@GetMapping("/advisor/{id}")
	public ResponseEntity<ResponseStructure<Advisor>> findById(@PathVariable int id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/advisors/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	
}
