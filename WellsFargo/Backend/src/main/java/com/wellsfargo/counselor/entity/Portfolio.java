package com.wellsfargo.counselor.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Portfolio {
	@Id @GeneratedValue()
	private long portfolioId;
    @CreatedDate
    private Date creationdate;
    
    @ManyToOne @JoinColumn(name="clientId")
    private Client client;    
    
    @OneToMany(mappedBy = "securityId")
    private List<Security> security;

	public Portfolio(long portfolioId, Date creationdate, Client client, List<Security> security) {
		super();
		this.portfolioId = portfolioId;
		this.creationdate = creationdate;
		this.client = client;
		this.security = security;
	}

	public long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Security> getSecurity() {
		return security;
	}

	public void setSecurity(List<Security> security) {
		this.security = security;
	}
    
    

}
