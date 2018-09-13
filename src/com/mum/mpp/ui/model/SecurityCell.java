package com.mum.mpp.ui.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.SecurityDTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SecurityCell extends RecursiveTreeObject<SecurityCell> {

	public static String COLUMN_ISIN_NBR = "Isin Number";
	public static String COLUMN_NAME = "Name";
	public static String COLUMN_TYPE = "Type";
	public static String COLUMN_PRICE = "Price";
	private StringProperty isinNbr;
	private StringProperty name;
	private StringProperty type;
	private StringProperty price;
	private SecurityDTO security;

	public SecurityCell(SecurityDTO security) {
		this.security = security;
		this.isinNbr = new SimpleStringProperty(security.getIsinNbr());
		this.name = new SimpleStringProperty(security.getName());
		this.type = new SimpleStringProperty(security.getType());
		this.price = new SimpleStringProperty(String.valueOf(security.getPrice()));
	}

	public StringProperty getIsinNbr() {
		return isinNbr;
	}

	public void setIsinNbr(StringProperty isinNbr) {
		this.isinNbr = isinNbr;
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getType() {
		return type;
	}

	public void setType(StringProperty type) {
		this.type = type;
	}

	public StringProperty getPrice() {
		return price;
	}

	public void setPrice(StringProperty price) {
		this.price = price;
	}

	public SecurityDTO getSecurity() {
		return security;
	}

	public void setSecurity(SecurityDTO security) {
		this.security = security;
	}
	
}
