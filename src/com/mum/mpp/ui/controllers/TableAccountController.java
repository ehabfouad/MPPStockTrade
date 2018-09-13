package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.AccountDTO;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.AccountCell;
import com.mum.mpp.ui.model.FXMLRessources;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class TableAccountController implements Initializable {

	@FXML
	private GridPane main;
	@FXML
	private JFXTreeTableView<AccountCell> treeView;

	private ObservableList<AccountCell> accounts = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		JFXTreeTableColumn<AccountCell, String> idCol = new JFXTreeTableColumn<>(AccountCell.COLUMN_ID);
		idCol.setPrefWidth(150);
		idCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getId();
					}
				});

		JFXTreeTableColumn<AccountCell, String> customerIdCol = new JFXTreeTableColumn<>(
				AccountCell.COLUMN_CUSTOMER_ID);
		customerIdCol.setPrefWidth(150);
		customerIdCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getCustomerId();
					}
				});

		JFXTreeTableColumn<AccountCell, String> portfolioIdCol = new JFXTreeTableColumn<>(
				AccountCell.COLUMN_PORTFOLIO_ID);
		portfolioIdCol.setPrefWidth(150);
		portfolioIdCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getPortflioId();
					}
				});

		JFXTreeTableColumn<AccountCell, String> currencyCol = new JFXTreeTableColumn<>(AccountCell.COLUMN_CURRENCY);
		currencyCol.setPrefWidth(150);
		currencyCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getCurrency();
					}
				});

		JFXTreeTableColumn<AccountCell, String> balanceCol = new JFXTreeTableColumn<>(AccountCell.COLUMN_BALANCE);
		balanceCol.setPrefWidth(150);
		balanceCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getBalance();
					}
				});

		JFXTreeTableColumn<AccountCell, String> typeCol = new JFXTreeTableColumn<>(AccountCell.COLUMN_TYPE);
		typeCol.setPrefWidth(150);
		typeCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<AccountCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<AccountCell, String> param) {
						return param.getValue().getValue().getType();
					}
				});

		fillAccounts(App.appUtils.getAccountService().getAll());

		final TreeItem<AccountCell> root = new RecursiveTreeItem<AccountCell>(accounts,
				RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(idCol, customerIdCol, portfolioIdCol, currencyCol, balanceCol, typeCol);
		treeView.setEditable(true);
		treeView.setShowRoot(false);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
	}

	@FXML
	private void delete(ActionEvent event) {
		if (!accounts.isEmpty() && treeView.getSelectionModel().getSelectedIndex() != -1) {
			if (App.appUtils.getAccountService()
					.delete(treeView.getSelectionModel().getSelectedItem().getValue().getId().get()))
				accounts.remove(treeView.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void add(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_ACCOUNT_ADD, FXMLRessources.FXML_ACCOUNT_ADD);
	}

	private void fillAccounts(List<AccountDTO> accountsDTO) {
		for (AccountDTO accountDTO : accountsDTO)
			accounts.add(new AccountCell(accountDTO));
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
