package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.dto.CustomerDTO;
import com.mum.mpp.dto.PortfolioDTO;
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
public class AddPortfolioController implements Initializable {


	@FXML
	private JFXTextField id;

	@FXML
	private JFXTextField stockPlace;

	@FXML
	private JFXTextField mylistview;

	private List<CustomerDTO> customers;
	private JFXListView<Label> list = new JFXListView<>();
	
	@FXML
	private void cancel(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_PORTFOLIO_TABLE, FXMLRessources.FXML_PORTFOLIO_TABLE);
	}

	@FXML
	private void add(ActionEvent event) {
		App.appUtils.getPortfolioService().create(
				new PortfolioDTO(id.getText(), stockPlace.getText(), list.getSelectionModel().getSelectedItem().getText()));
		App.appUtils.loadScene(FXMLRessources.TITLE_PORTFOLIO_TABLE, FXMLRessources.FXML_PORTFOLIO_TABLE);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setupListView();
	}
	
	private void setupListView() {
		mylistview.setEditable(false);
		customers=App.appUtils.getCustomerService().getAll();
		
		for (CustomerDTO customerDTO:customers)
			list.getItems().add(new Label(customerDTO.getId()));

		JFXPopup popup = new JFXPopup(list);
		
		mylistview.setOnMouseClicked(e -> popup.show(mylistview, PopupVPosition.TOP, PopupHPosition.LEFT));
		
		popup.setOnHidden(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				mylistview.setText(list.getSelectionModel().getSelectedItem().getText());
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
