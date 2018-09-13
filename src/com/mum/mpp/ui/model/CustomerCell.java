package com.mum.mpp.ui.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.CustomerDTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerCell extends RecursiveTreeObject<CustomerCell> {

	public static String COLUMN_ID = "Customer Id";
	public static String COLUMN_FNAME = "First Name";
	public static String COLUMN_LNAME = "Last Name";
	private StringProperty id;
	private StringProperty fName;
	private StringProperty lName;
	private CustomerDTO customer;

	public CustomerCell(CustomerDTO customer) {
		this.customer = customer;
		this.id = new SimpleStringProperty(customer.getId());
		this.fName = new SimpleStringProperty(customer.getFirstName());
		this.lName = new SimpleStringProperty(customer.getLastName());
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public StringProperty getfName() {
		return fName;
	}

	public void setfName(StringProperty fName) {
		this.fName = fName;
	}

	public StringProperty getlName() {
		return lName;
	}

	public void setlName(StringProperty lName) {
		this.lName = lName;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
