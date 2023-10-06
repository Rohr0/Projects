package org.jsp.reservation_api.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(nullable=false,unique = true)
	private long phone;
	private LocalDate date;
	@Column(nullable=false,unique = true)
	private String email;
	private String password;
	@Column(nullable=false,unique = true)
	private String aadhar;
}
