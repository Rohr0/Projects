package org.jsp.reservation_api.dao;

import java.util.Optional;

import org.jsp.reservation_api.dto.User;
import org.jsp.reservation_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repo;
	
	public User saveUser(User u) {
		return repo.save(u);
	}
	public User updateUser(User u) {
		return repo.save(u);
	}
	public Optional<User> findById(int id){
		return repo.findById(id);
	}

	public Optional<User> verifyUser(long phone,String password){
		return repo.verifyUser(phone, password);
	}
	public Optional<User> verifyUser(String email,String password){
		return repo.verifyUser(email, password);
	}
}
