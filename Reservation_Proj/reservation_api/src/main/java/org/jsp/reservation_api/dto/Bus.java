package org.jsp.reservation_api.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bus {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="from_loc")
	private String from;
	@Column(name="to_loc")
	private String to;
	@Column(name="date_of_dep")
	private Date dod;
	@Column(nullable=false)
	private String bus_no;
	@Column(nullable=false)
	private String bus_name;
	@Column(name="no_of_seats")
	private int nos;
	@ManyToOne @JoinColumn(name="admin_Id")
	@JsonIgnore
	private Admin admin;

}
