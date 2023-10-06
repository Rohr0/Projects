package org.jsp.reservation_api.dao;

import java.util.Optional;

import org.jsp.reservation_api.dto.Admin;
import org.jsp.reservation_api.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository repo;

	public Admin saveAdmin(Admin a) {
		return repo.save(a);
	}
	public Admin updateAdmin(Admin a) {
		return repo.save(a);
	}	
	public Optional<Admin> findById(int id) {
		return repo.findById(id);
	}
	public Optional<Admin> verify(long phone,String password){
		return repo.verify(phone, password);
	}
	public Optional<Admin> verify(String email,String password){
		return repo.verify(email, password);
	}
}
