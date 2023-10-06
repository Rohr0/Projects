package org.jsp.reservation_api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.jsp.reservation_api.Exception.IdNotFoundException;
import org.jsp.reservation_api.dao.AdminDao;
import org.jsp.reservation_api.dao.BusDao;
import org.jsp.reservation_api.dto.Admin;
import org.jsp.reservation_api.dto.Bus;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {
	@Autowired
	private BusDao bdao;
	@Autowired
	private AdminDao adao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus b,int id){
		Optional<Admin> recAdmin=adao.findById(id);
		ResponseStructure<Bus> s=new ResponseStructure<>();
		if(recAdmin.isPresent()) {
			Admin a=recAdmin.get();
			a.getBuses().add(b);
			b.setAdmin(a);
			adao.updateAdmin(a);
			bdao.saveBus(b);
			
			s.setData(b);
			s.setMessage("Bus Added");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Bus>> updateBus(Bus b,int id){
		Optional<Admin> recAdmin=adao.findById(id);
		ResponseStructure<Bus> s=new ResponseStructure<>();
		if(recAdmin.isPresent()) {
			Admin a=recAdmin.get();
			b.setAdmin(a);
			bdao.saveBus(b);
			
			s.setData(b);
			s.setMessage("Bus Details Updated");
			s.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(s, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Bus>>> filter(String from,String to,LocalDate dod){
		ResponseStructure<List<Bus>> s=new ResponseStructure<>();
		s.setData(bdao.filter(from, to, dod));
		s.setMessage("List of Buses");
		s.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Bus>>>(s,HttpStatus.OK);
	}

}
