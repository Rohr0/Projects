package com.wellsfargo.counselor.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;

@Repository
public class SecurityDao {
	@Autowired
	private SecurityRepository repo;

	public Security saveSecurity(Security a) {
		return repo.save(a);
	}

	public Security updateSecurity(Security a) {
		return repo.save(a);
	}

	public Optional<Security> findById(int id) {
		return repo.findById(id);
	}
	
	public void deleteSecurity(int id) {
		repo.deleteById(id);
	}

}
