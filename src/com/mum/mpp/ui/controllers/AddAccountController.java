package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.dto.BankAccountDTO;
import com.mum.mpp.dto.ClientAccountDTO;
import com.mum.mpp.dto.CustomerDTO;
import com.mum.mpp.dto.PortfolioDTO;
import com.mum.mpp.service.AccountService;
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
public class AddAccountController implements Initializable {

	@FXML
	private JFXTextField id;

	@FXML
	private JFXTextField customerId;

	@FXML
	private JFXTextField portfolioId;

	@FXML
	private JFXTextField currency;

	@FXML
	private JFXTextField type;

	@FXML
	private JFXTextField balance;

	private List<CustomerDTO> customers;
	private List<PortfolioDTO> portfolios;

	private JFXListView<Label> customersList = new JFXListView<>();
	private JFXListView<Label> portofoliosList = new JFXListView<>();
	private JFXListView<Label> typesList = new JFXListView<>();

	@FXML
	private void cancel(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_ACCOUNT_TABLE, FXMLRessources.FXML_ACCOUNT_TABLE);
	}

	@FXML
	private void add(ActionEvent event) {
		String accType = type.getText();
		if (accType.equals(AccountService.CLIENT)) {
			App.appUtils.getAccountService()
					.create(new ClientAccountDTO(id.getText(), type.getText(), currency.getText(),
							Double.valueOf(balance.getText()), customerId.getText(), portfolioId.getText()));
		} else {
			App.appUtils.getAccountService().create(new BankAccountDTO(id.getText(), type.getText(), currency.getText(),
					Double.valueOf(balance.getText()), customerId.getText(), portfolioId.getText()));
		}

		App.appUtils.loadScene(FXMLRessources.TITLE_ACCOUNT_TABLE, FXMLRessources.FXML_ACCOUNT_TABLE);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setupCustomersListView();
		setupPortfoliosListView();
		setupTypeListView();
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

	private void setupTypeListView() {
		type.setEditable(false);

		typesList.getItems().add(new Label(App.appUtils.getAccountService().BANK));
		typesList.getItems().add(new Label(App.appUtils.getAccountService().CLIENT));

		JFXPopup popup = new JFXPopup(typesList);

		type.setOnMouseClicked(e -> popup.show(type, PopupVPosition.TOP, PopupHPosition.LEFT));

		popup.setOnHidden(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				type.setText(typesList.getSelectionModel().getSelectedItem().getText());
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
