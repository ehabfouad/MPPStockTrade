package com.mum.mpp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio extends AbstractEntity<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "portfolio_id")
	private String id;

	@Column(name = "stockPlace")
	private String stockPlace;

	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	@ManyToOne(optional = false)
	private Customer customer;

	@OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL, mappedBy = "portfolio")
	private Set<Account> accountList;

	@ManyToMany(fetch = FetchType.EAGER , cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Portfolioes_Securities", joinColumns = @JoinColumn(name = "portfolio_id"), inverseJoinColumns = @JoinColumn(name = "isinNbr"))
	private Set<Security> securities;

	public Portfolio() {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}

	public Set<Security> getSecurities() {
		return securities;
	}

	public void setSecurities(Set<Security> securities) {
		this.securities = securities;
	}
	
	@Override
	public String getPrimaryKey() {
		return id;
	}

}
