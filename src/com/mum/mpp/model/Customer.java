package com.mum.mpp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends AbstractEntity<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private String id;

	@Column(name="fname")
	private String firstName;

	@Column(name="lname")
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Portfolio> portfolioList;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Account> accountList;

	public Customer() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Set<Portfolio> getPortfolioList() {
		return portfolioList;
	}

	public void setPortfolioList(Set<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}

	public Set<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}

	@Override
	public String getPrimaryKey() {
		return id;
	}

}
