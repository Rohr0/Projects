package com.wellsfargo.counselor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.counselor.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Integer>{

}
