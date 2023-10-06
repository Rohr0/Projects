package com.wellsfargo.counselor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.counselor.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
