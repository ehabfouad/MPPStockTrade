package com.mum.mpp.dto;

import java.util.HashSet;
import java.util.Set;

public class PortfolioDTO extends AbstractDTO {

	private String id;

	private String stockPlace;

	private String customerId;

	private Set<String> accountList;

	private Set<String> securityList;

	public PortfolioDTO() {
		accountList = new HashSet<String>();
		securityList = new HashSet<String>();
	}

	public PortfolioDTO(String id, String stockPlace, String customerId) {
		super();
		this.id = id;
		this.stockPlace = stockPlace;
		this.customerId = customerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockPlace() {
		return stockPlace;
	}

	public void setStockPlace(String stockPlace) {
		this.stockPlace = stockPlace;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Set<String> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<String> accountList) {
		this.accountList = accountList;
	}

	public Set<String> getSecurityList() {
		return securityList;
	}

	public void setSecurityList(Set<String> securityList) {
		this.securityList = securityList;
	}

	public String getSecuritiesStr() {
		String securtiesStr ="";
		for (String sec : securityList) {
			securtiesStr += sec +" ";
		}
		return securtiesStr;
	}

	@Override
	public String getEntityPrimaryKey() {
		return id;
	}

}
