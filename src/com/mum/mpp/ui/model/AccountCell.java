package com.mum.mpp.ui.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.AccountDTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AccountCell extends RecursiveTreeObject<AccountCell> {

	public static String COLUMN_ID = "Account Id";
	public static String COLUMN_CUSTOMER_ID = "Customer Id";
	public static String COLUMN_PORTFOLIO_ID = "Portfolio Id";
	public static String COLUMN_CURRENCY = "Currency";
	public static String COLUMN_BALANCE = "Balance";
	public static String COLUMN_TYPE = "Type";
	private StringProperty id;
	private StringProperty customerId;
	private StringProperty portflioId;
	private StringProperty type;
	private StringProperty balance;
	private StringProperty currency;
	private AccountDTO account;

	public AccountCell(AccountDTO account) {
		this.account = account;
		this.id = new SimpleStringProperty(account.getId());
		this.customerId = new SimpleStringProperty(account.getCustomerId());
		this.portflioId = new SimpleStringProperty(account.getPortfolioId());
		this.type = new SimpleStringProperty(account.getType());
		this.balance = new SimpleStringProperty(String.valueOf(account.getBalance()));
		this.currency = new SimpleStringProperty(account.getCurrency());
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(StringProperty id) {
		this.id = id;
	}

	public StringProperty getCustomerId() {
		return customerId;
	}

	public void setCustomerId(StringProperty customerId) {
		this.customerId = customerId;
	}

	public StringProperty getPortflioId() {
		return portflioId;
	}

	public void setPortflioId(StringProperty portflioId) {
		this.portflioId = portflioId;
	}

	public StringProperty getType() {
		return type;
	}

	public void setType(StringProperty type) {
		this.type = type;
	}

	public StringProperty getBalance() {
		return balance;
	}

	public void setBalance(StringProperty balance) {
		this.balance = balance;
	}

	public StringProperty getCurrency() {
		return currency;
	}

	public void setCurrency(StringProperty currency) {
		this.currency = currency;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}
	
}
