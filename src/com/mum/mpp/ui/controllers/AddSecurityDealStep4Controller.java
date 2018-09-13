package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.FXMLRessources;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author villan
 */
public class AddSecurityDealStep4Controller implements Initializable {

	
	@FXML
	private JFXTextField price;
	
	@FXML
	private JFXTextField quantity;
	
	@FXML
	private void back(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL3_ADD, FXMLRessources.FXML_CUSTOMER_ADD);
	}

	@FXML
	private void add(ActionEvent event) {
		AddSecurityDealStep1Controller.secDealClient.setPrice(Double.valueOf(price.getText()));
		AddSecurityDealStep1Controller.secDealClient.setQuantity(Double.valueOf(quantity.getText()));
		
		App.appUtils.getSecDealTranService().create(AddSecurityDealStep1Controller.secDealClient);
		
		AddSecurityDealStep1Controller.secDealBank.setPrice(Double.valueOf(price.getText()));
		AddSecurityDealStep1Controller.secDealBank.setQuantity(Double.valueOf(quantity.getText()));
		
		App.appUtils.getSecDealTranService().create(AddSecurityDealStep1Controller.secDealBank);
		
		App.appUtils.loadScene(FXMLRessources.TITLE_PORTFOLIO_TABLE, FXMLRessources.FXML_PORTFOLIO_TABLE);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private void customer() {
    	
		App.appUtils.loadScene(FXMLRessources.TITLE_CUSTOMER_TABLE, FXMLRessources.FXML_CUSTOMER_TABLE);
    }
    
    @FXML
    private void portfolio() {
		App.appUtils.loadScene(FXMLRessources.TITLE_PORTFOLIO_TABLE, FXMLRessources.FXML_PORTFOLIO_TABLE);
    }
    
    @FXML
    private void security() {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITY_TABLE, FXMLRessources.FXML_SECURITY_TABLE);
    }
    
    @FXML
    private void account() {
		App.appUtils.loadScene(FXMLRessources.TITLE_ACCOUNT_TABLE, FXMLRessources.FXML_ACCOUNT_TABLE);
    }
    
    @FXML
    private void secDeal() {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL_ADD, FXMLRessources.FXML_SECURITYDEAL_STEP1);
    }
	
}
