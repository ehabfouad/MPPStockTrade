package com.mum.mpp.dto;

public class AccountDTO extends AbstractDTO {

	private String id;

	private String type;

	private String currency;

	private double balance;

	private String customerId;

	private String portfolioId;

	public AccountDTO() {
	}

	public AccountDTO(String id, String type, String currency, double balance, String customerId, String portfolioId) {
		super();
		this.id = id;
		this.type = type;
		this.currency = currency;
		this.balance = balance;
		this.customerId = customerId;
		this.portfolioId = portfolioId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getEntityPrimaryKey() {
		return id;
	}

}
