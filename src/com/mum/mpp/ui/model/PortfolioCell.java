package com.mum.mpp.ui.model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.PortfolioDTO;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PortfolioCell extends RecursiveTreeObject<PortfolioCell> {

	public static String COLUMN_ID = "Portofolio Id";
	public static String COLUMN_STOCK_PLACE = "Stock Place";
	public static String COLUMN_CUSTOMER_ID = "Customer Id";
	public static String COLUMN_SECURITIES = "Securities";
	private StringProperty id;
	private StringProperty stockPlace;
	private StringProperty CustomerId;
	private StringProperty securities;
	private PortfolioDTO portofolio;
	
	public PortfolioCell(PortfolioDTO portofolio) {
		this.portofolio = portofolio;
		id = new SimpleStringProperty(portofolio.getId());
		stockPlace = new SimpleStringProperty(portofolio.getStockPlace());
		CustomerId = new SimpleStringProperty(portofolio.getCustomerId());
		securities = new SimpleStringProperty(portofolio.getSecuritiesStr());
	}
	public StringProperty getId() {
		return id;
	}
	public void setId(StringProperty id) {
		this.id = id;
	}
	public StringProperty getStockPlace() {
		return stockPlace;
	}
	public void setStockPlace(StringProperty stockPlace) {
		this.stockPlace = stockPlace;
	}
	public StringProperty getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(StringProperty customerId) {
		CustomerId = customerId;
	}
	public StringProperty getSecurities() {
		return securities;
	}
	public void setSecurities(StringProperty securities) {
		this.securities = securities;
	}
	public PortfolioDTO getPortofolio() {
		return portofolio;
	}
	public void setPortofolio(PortfolioDTO portofolio) {
		this.portofolio = portofolio;
	}
	
}
