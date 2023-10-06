package com.wellsfargo.counselor.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;

@Repository
public class ClientDao {

	@Autowired
	private ClientRepository repo;

	public Client saveClient(Client c) {
		return repo.save(c);
	}

	public Client updateClient(Client c) {
		return repo.save(c);
	}

	public Optional<Client> findById(int id) {
		return repo.findById(id);
	}

	public void deleteClient(int id) {
		repo.deleteById(id);
	}
}
