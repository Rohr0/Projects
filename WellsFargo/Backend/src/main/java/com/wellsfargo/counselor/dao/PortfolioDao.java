package com.wellsfargo.counselor.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;

@Repository
public class PortfolioDao {
	@Autowired
	private PortfolioRepository repo;

	public Portfolio savePortfolio(Portfolio a) {
		return repo.save(a);
	}

	public Portfolio updatePortfolio(Portfolio a) {
		return repo.save(a);
	}

	public Optional<Portfolio> findById(int id) {
		return repo.findById(id);
	}
	
	public void deletePortfolio(int id) {
		repo.deleteById(id);
	}
}
