package com.mum.mpp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "secdealtran")
public class SecDealTran extends AbstractEntity<SecDealPK> {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SecDealPK dealIdPK;

	@Column(name = "dealDate")
	private LocalDate dealLocalDate;

	@JoinColumn(name = "isinNbr", nullable = false)
	@ManyToOne(optional = false)
	private Security security;

	@JoinColumn(name = "customer_id", nullable = false)
	@ManyToOne(optional = false)
	private Customer customer;

	@JoinColumn(name = "portfolio_id", nullable = false)
	@ManyToOne(optional = false)
	private Portfolio portfolio;

	@JoinColumn(name = "account_id", nullable = false)
	@ManyToOne(optional = false)
	private Account account;

	@Column(name = "quantity")
	private double quantity;

	@Column(name = "price")
	private double price;

	public SecDealTran() {

	}

	public SecDealPK getDealIdPK() {
		return dealIdPK;
	}

	public void setDealIdPK(SecDealPK dealIdPK) {
		this.dealIdPK = dealIdPK;
	}

	public LocalDate getDealLocalDate() {
		return dealLocalDate;
	}

	public void setDealLocalDate(LocalDate dealLocalDate) {
		this.dealLocalDate = dealLocalDate;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
	public SecDealPK getPrimaryKey() {
		return dealIdPK;
	}

}
