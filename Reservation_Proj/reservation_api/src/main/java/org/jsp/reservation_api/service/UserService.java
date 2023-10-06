package org.jsp.reservation_api.service;

import java.util.Optional;

import org.jsp.reservation_api.Exception.IdNotFoundException;
import org.jsp.reservation_api.Exception.InvalidCredentialsException;
import org.jsp.reservation_api.dao.UserDao;
import org.jsp.reservation_api.dto.User;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User u){
		ResponseStructure<User> s=new ResponseStructure<>();
		s.setData(dao.saveUser(u));
		s.setMessage("User Added Successfully :)");
		s.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(s,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User u){
		ResponseStructure<User> s=new ResponseStructure<>();
		s.setData(dao.updateUser(u));
		s.setMessage("User Updated Successfully :)");
		s.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(s,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		ResponseStructure<User> s=new ResponseStructure<>();
		Optional<User> recUser=dao.findById(id);
		if(recUser.isPresent()) {
			s.setData(recUser.get());
			s.setMessage("User Found");
			s.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(s, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> rs = dao.verifyUser(phone, password);
		if (rs.isPresent()) {
			structure.setData(rs.get());
			structure.setMessage("User Phone-Number Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} 
		throw new InvalidCredentialsException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email, String password) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> rs = dao.verifyUser(email, password);
		if (rs.isPresent()) {
			structure.setData(rs.get());
			structure.setMessage("User Phone-Number Verified Successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		} 
		throw new InvalidCredentialsException();
	}

}
