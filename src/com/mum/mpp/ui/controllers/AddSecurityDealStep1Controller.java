package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.dto.SecDealTranDTO;
import com.mum.mpp.dto.SecurityDTO;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.FXMLRessources;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.WindowEvent;

/**
 *
 * @author villan
 */
public class AddSecurityDealStep1Controller implements Initializable {
	
	public static SecDealTranDTO secDealClient;
	public static SecDealTranDTO secDealBank;
	
	@FXML
	private JFXDatePicker date;
	
	@FXML
	private JFXTextField isinNbr;
	
	@FXML
	private JFXTextField id;
	
	private List<SecurityDTO> securities;
	private JFXListView<Label> list = new JFXListView<>();

	@FXML
    private void cancel(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL2_ADD, FXMLRessources.FXML_SECURITYDEAL_STEP2);	
    }
    
    @FXML
    private void next(ActionEvent event) {
    	secDealClient = new SecDealTranDTO();
    	secDealClient.setDealId(id.getText());
    	secDealClient.setSecurityIsinNbr(isinNbr.getText());
    	secDealClient.setDealDate(date.getValue());
    	secDealClient.setTranId("0");
    	
    	secDealBank = new SecDealTranDTO();
    	secDealBank.setDealId(id.getText());
    	secDealBank.setSecurityIsinNbr(isinNbr.getText());
    	secDealBank.setDealDate(date.getValue());
    	secDealBank.setTranId("1");
    	
    	App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL2_ADD, FXMLRessources.FXML_SECURITYDEAL_STEP2);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setupListView();
	}
	
	private void setupListView() {
		isinNbr.setEditable(false);
		securities=App.appUtils.getSecurityService().getAll();
		
		for (SecurityDTO security:securities)
			list.getItems().add(new Label(security.getIsinNbr()));

		JFXPopup popup = new JFXPopup(list);
		
		isinNbr.setOnMouseClicked(e -> popup.show(isinNbr, PopupVPosition.TOP, PopupHPosition.LEFT));
		
		popup.setOnHidden(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				isinNbr.setText(list.getSelectionModel().getSelectedItem().getText());
			}
		});
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
