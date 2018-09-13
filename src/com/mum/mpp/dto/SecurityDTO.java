package com.mum.mpp.dto;

public class SecurityDTO extends AbstractDTO {

	private String isinNbr;

	private String name;

	private String type;

	private double price;
	
	public SecurityDTO() {
	}
	
	public SecurityDTO(String isinNbr, String name, String type, double price) {
		super();
		this.isinNbr = isinNbr;
		this.name = name;
		this.type = type;
		this.price = price;
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

	@Override
	public String getEntityPrimaryKey() {
		return isinNbr;
	}

}
