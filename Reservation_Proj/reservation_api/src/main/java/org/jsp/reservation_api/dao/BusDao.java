package org.jsp.reservation_api.dao;

import java.time.LocalDate;
import java.util.List;

import org.jsp.reservation_api.dto.Bus;
import org.jsp.reservation_api.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {
	@Autowired
	private BusRepository repo;
	
	public Bus saveBus(Bus b) {
		return repo.save(b);
	}
	public Bus updateBus(Bus b) {
		return repo.save(b);
	}

	public List<Bus> filter(String from,String to,LocalDate dod){
		return repo.filter(from, to, dod);
	}
	
}
