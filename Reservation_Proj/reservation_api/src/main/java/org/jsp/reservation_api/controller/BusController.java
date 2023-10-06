package org.jsp.reservation_api.controller;

import java.time.LocalDate;
import java.util.List;

import org.jsp.reservation_api.dto.Bus;
import org.jsp.reservation_api.dto.ResponseStructure;
import org.jsp.reservation_api.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BusController {
	@Autowired
	private BusService serv;

	@PostMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus b, @PathVariable int id) {
		return serv.saveBus(b, id);
	}

	@PutMapping("/bus/{id}")
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus b, @PathVariable int id) {
		return serv.updateBus(b, id);
	}

	@GetMapping("/bus/filter")
	public ResponseEntity<ResponseStructure<List<Bus>>> filter(@RequestParam String from, @RequestParam String to,
			@RequestParam LocalDate dod) {
		return serv.filter(from, to, dod);
	}
}
