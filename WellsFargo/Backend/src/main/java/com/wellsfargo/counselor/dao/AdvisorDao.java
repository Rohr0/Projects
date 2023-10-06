package com.wellsfargo.counselor.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;

@Repository
public class AdvisorDao {
	@Autowired
	private AdvisorRepository repo;

	public Advisor saveAdvisor(Advisor a) {
		return repo.save(a);
	}

	public Advisor updateAdvisor(Advisor a) {
		return repo.save(a);
	}

	public Optional<Advisor> findById(int id) {
		return repo.findById(id);
	}

	public void deleteAdvisor(int id) {
		repo.deleteById(id);
	}
}
