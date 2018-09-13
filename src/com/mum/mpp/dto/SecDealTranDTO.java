package com.mum.mpp.dto;

import java.time.LocalDate;

public class SecDealTranDTO extends AbstractDTO {

	private String dealId;
	
	private String tranId;

	private LocalDate dealDate;

	private String securityIsinNbr;

	private String customerId;

	private String portfolioId;

	private String accountId;

	private double quantity;

	private double price;

	public SecDealTranDTO() {
	}

	public SecDealTranDTO(String dealId, String tranId, LocalDate dealDate, String securityIsinNbr, String customerId,
			String portfolioId, String accountId, double quantity, double price) {
		super();
		this.dealId = dealId;
		this.dealDate = dealDate;
		this.tranId = tranId;
		this.securityIsinNbr = securityIsinNbr;
		this.customerId = customerId;
		this.portfolioId = portfolioId;
		this.accountId = accountId;
		this.quantity = quantity;
		this.price = price;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	
	public LocalDate getDealDate() {
		return dealDate;
	}

	public void setDealDate(LocalDate dealDate) {
		this.dealDate = dealDate;
	}

	public String getSecurityIsinNbr() {
		return securityIsinNbr;
	}

	public void setSecurityIsinNbr(String securityIsinNbr) {
		this.securityIsinNbr = securityIsinNbr;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String getEntityPrimaryKey() {
		return tranId;
	}
}
