package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.dto.AccountDTO;
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
public class AddSecurityDealStep2Controller implements Initializable {

	@FXML
	private JFXTextField customerId;

	@FXML
	private JFXTextField portfolioId;

	@FXML
	private JFXTextField accountId;

	private List<CustomerDTO> customers;
	private List<PortfolioDTO> portfolios;
	private List<AccountDTO> accounts;

	private JFXListView<Label> customersList = new JFXListView<>();
	private JFXListView<Label> portofoliosList = new JFXListView<>();
	private JFXListView<Label> accountsList = new JFXListView<>();

	@FXML
	private void back(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL_ADD, FXMLRessources.FXML_SECURITYDEAL_STEP1);
	}

	@FXML
	private void next(ActionEvent event) {
		AddSecurityDealStep1Controller.secDealClient.setCustomerId(customerId.getText());
		AddSecurityDealStep1Controller.secDealClient.setPortfolioId(portfolioId.getText());
		AddSecurityDealStep1Controller.secDealClient.setAccountId(accountId.getText());
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITYDEAL3_ADD, FXMLRessources.FXML_SECURITYDEAL_STEP3);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setupCustomersListView();
		setupPortfoliosListView();
		setupAccountsListView();
	}

	private void setupCustomersListView() {
		customerId.setEditable(false);
		customers = App.appUtils.getCustomerService().getAll();

		for (CustomerDTO customerDTO : customers)
			customersList.getItems().add(new Label(customerDTO.getId()));

		JFXPopup popup = new JFXPopup(customersList);

		customerId.setOnMouseClicked(e -> popup.show(customerId, PopupVPosition.TOP, PopupHPosition.LEFT));

		popup.setOnHidden(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				customerId.setText(customersList.getSelectionModel().getSelectedItem().getText());
			}
		});
	}

	private void setupPortfoliosListView() {
		portfolioId.setEditable(false);
		portfolios = App.appUtils.getPortfolioService().getAll();

		for (PortfolioDTO portfolioDTO : portfolios)
			portofoliosList.getItems().add(new Label(portfolioDTO.getId()));

		JFXPopup popup = new JFXPopup(portofoliosList);

		portfolioId.setOnMouseClicked(e -> popup.show(portfolioId, PopupVPosition.TOP, PopupHPosition.LEFT));

		popup.setOnHidden(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				portfolioId.setText(portofoliosList.getSelectionModel().getSelectedItem().getText());
			}
		});
	}

	private void setupAccountsListView() {
		accountId.setEditable(false);
		accounts = App.appUtils.getAccountService().getAll();

		for (AccountDTO accountDTO : accounts)
			accountsList.getItems().add(new Label(accountDTO.getId()));

		JFXPopup popup = new JFXPopup(accountsList);

		accountId.setOnMouseClicked(e -> popup.show(accountId, PopupVPosition.TOP, PopupHPosition.LEFT));

		popup.setOnHidden(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				accountId.setText(accountsList.getSelectionModel().getSelectedItem().getText());
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
