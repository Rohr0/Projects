package com.wellsfargo.counselor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wellsfargo.counselor.dao.ClientDao;
import com.wellsfargo.counselor.dao.PortfolioDao;
import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.exceptions.IdNotFoundExpection;

@Service
public class PortfolioService {
	@Autowired
	private PortfolioDao pdao;
	@Autowired
	private ClientDao cdao;

	public ResponseEntity<ResponseStructure<Portfolio>> savePortfolio(Portfolio p, int clientId) {
		ResponseStructure<Portfolio> s = new ResponseStructure<>();
		Optional<Client> client = cdao.findById(clientId);
		if (client.isPresent()) {
			Client c = client.get();
			c.getPortfolios().add(p);
			p.setClient(c);
			cdao.updateClient(c);
			pdao.savePortfolio(p);

			s.setData(p);
			s.setMessage("Product Added successfully");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Portfolio>>(s, HttpStatus.OK);
		}
		throw new IdNotFoundExpection();
	}
	public ResponseEntity<ResponseStructure<Portfolio>> updatePortfolio(Portfolio p, int clientId) {
		ResponseStructure<Portfolio> s = new ResponseStructure<>();
		Optional<Client> client = cdao.findById(clientId);
		if (client.isPresent()) {
			Client c = client.get();
			p.setClient(c);
			pdao.savePortfolio(p);

			s.setData(p);
			s.setMessage("Product Added successfully");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Portfolio>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundExpection();
	}
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id){
		ResponseStructure<String> s=new ResponseStructure<>();
		Optional<Portfolio> recProd=pdao.findById(id);
		if(recProd.isPresent()) {
			s.setData("Item Deleted");
			s.setMessage("Product Found");
			s.setStatusCode(HttpStatus.OK.value());		
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.CREATED);
		}
		throw new IdNotFoundExpection();
	}
}
