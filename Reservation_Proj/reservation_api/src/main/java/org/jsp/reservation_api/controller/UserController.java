package org.jsp.reservation_api.controller;

import org.jsp.reservation_api.dto.User;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.jsp.reservation_api.service.UserService;
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
public class UserController {
	@Autowired
	private UserService serv;
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u){
		return serv.saveUser(u);
	}
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u){
		return serv.updateUser(u);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id){
		return serv.findById(id);
	}
	@PostMapping("/users/verifyByPhone")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam long phone, @RequestParam String password) {
		return serv.verifyUser(phone, password);
	}
	@PostMapping("/users/verifyByEmail")
	public ResponseEntity<ResponseStructure<User>> verify(@RequestParam String email, @RequestParam String password) {
		return serv.verifyUser(email, password);
	}

}
