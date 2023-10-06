package org.jsp.reservation_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.jsp.reservation_api.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	@Query("select b from Bus b where b.from=?1 and b.to=?2 and b.dod=?3")
	public List<Bus> filter(String from, String to, LocalDate dod);
}
