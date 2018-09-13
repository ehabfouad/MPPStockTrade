package com.mum.mpp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Security extends AbstractEntity<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "isinNbr")
	private String isinNbr;

	@Column(name = "name")
	private String name;

	@Column(name = "type", insertable = false, updatable = false)
	private String type;

	@Column(name = "price")
	private double price;

	@ManyToMany(mappedBy = "securities")
	private Set<Portfolio> portfolios;

	public Security() {
	}

	public String getIsinNbr() {
		return isinNbr;
	}

	public void setIsinNbr(String isinNbr) {
		this.isinNbr = isinNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Portfolio> getPortfolios() {
		return portfolios;
	}

	public void setPortfolios(Set<Portfolio> portfolios) {
		this.portfolios = portfolios;
	}

	@Override
	public String getPrimaryKey() {
		return null;
	}

}
