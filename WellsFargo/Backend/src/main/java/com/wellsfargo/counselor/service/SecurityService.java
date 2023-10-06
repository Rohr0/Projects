package com.wellsfargo.counselor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wellsfargo.counselor.dao.PortfolioDao;
import com.wellsfargo.counselor.dao.SecurityDao;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.entity.ResponseStructure;
import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.exceptions.IdNotFoundExpection;

@Service
public class SecurityService {
	@Autowired
	private SecurityDao sdao;
	@Autowired
	private PortfolioDao pdao;
	
	public ResponseEntity<ResponseStructure<Security>> saveSecurity(Security s, int PortfolioId) {
		ResponseStructure<Security> st = new ResponseStructure<>();
		Optional<Portfolio> Portfolio = pdao.findById(PortfolioId);
		if (Portfolio.isPresent()) {
			Portfolio p = Portfolio.get();
			p.getSecurity().add(s);
			s.setPortfolio(p);
			pdao.updatePortfolio(p);
			sdao.saveSecurity(s);

			st.setData(s);
			st.setMessage("Product Added successfully");
			st.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Security>>(st, HttpStatus.CREATED);
		}
		throw new IdNotFoundExpection();
	}
	public ResponseEntity<ResponseStructure<Security>> updateSecurity(Security p, int PortfolioId) {
		ResponseStructure<Security> s = new ResponseStructure<>();
		Optional<Portfolio> Portfolio = pdao.findById(PortfolioId);
		if (Portfolio.isPresent()) {
			Portfolio c = Portfolio.get();
			p.setPortfolio(c);
			sdao.saveSecurity(p);

			s.setData(p);
			s.setMessage("Product Added successfully");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Security>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundExpection();
	}
	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id){
		ResponseStructure<String> s=new ResponseStructure<>();
		Optional<Security> recProd=sdao.findById(id);
		if(recProd.isPresent()) {
			s.setData("Item Deleted");
			s.setMessage("Product Found");
			s.setStatusCode(HttpStatus.OK.value());		
			return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.OK);
		}
		throw new IdNotFoundExpection();
	}
}
