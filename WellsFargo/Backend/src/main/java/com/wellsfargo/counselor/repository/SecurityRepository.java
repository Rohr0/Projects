package com.wellsfargo.counselor.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.counselor.entity.Security;

public interface SecurityRepository extends JpaRepository<Security, Integer> {

}
