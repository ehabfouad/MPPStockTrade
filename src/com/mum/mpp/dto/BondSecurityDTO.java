package com.mum.mpp.dto;

public class BondSecurityDTO extends SecurityDTO{

	public BondSecurityDTO() {
		super();
	}

	public BondSecurityDTO(String isinNbr, String name, String type, double price) {
		super(isinNbr, name, type, price);
	}

}
