package com.wellsfargo.counselor.entity;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Security {
	@Id @GeneratedValue()
	private long securityId;
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String category;
	@Column(nullable = false)
    private double	purchaseprice;
	@CreatedDate
	private Date purchasedDate;
	@Column(nullable = false)
    private int quantity;
	
	@ManyToOne @JoinColumn(name="portfolioId")
	private Portfolio portfolio;

	public Security(long securityId, String name, String category, double purchaseprice, Date purchasedDate,
			int quantity, Portfolio portfolio) {
		super();
		this.securityId = securityId;
		this.name = name;
		this.category = category;
		this.purchaseprice = purchaseprice;
		this.purchasedDate = purchasedDate;
		this.quantity = quantity;
		this.portfolio = portfolio;
	}

	public long getSecurityId() {
		return securityId;
	}

	public void setSecurityId(long securityId) {
		this.securityId = securityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Date getPurchasedDate() {
		return purchasedDate;
	}

	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
    
	
}
