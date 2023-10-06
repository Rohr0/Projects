package com.wellsfargo.counselor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.counselor.entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio,Integer> {

}
