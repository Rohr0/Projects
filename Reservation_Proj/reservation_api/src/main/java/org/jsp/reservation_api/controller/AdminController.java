package org.jsp.reservation_api.controller;

import org.jsp.reservation_api.dto.Admin;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.jsp.reservation_api.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminService serv;
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin a){
		return serv.saveAdmin(a);
	}	
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin a){
		return serv.updateAdmin(a);
	}
	@GetMapping("/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> findById(@PathVariable int id){
		return serv.findById(id);
	}
	@PostMapping("/admins/verifyByPhone")
	public ResponseEntity<ResponseStructure<Admin>> verify(@RequestParam long phone, @RequestParam String password) {
		return serv.verify(phone, password);
	}
	@PostMapping("/admins/verifyByEmail")
	public ResponseEntity<ResponseStructure<Admin>> verify(@RequestParam String email, @RequestParam String password) {
		return serv.verify(email, password);
	}
}
