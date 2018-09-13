package com.mum.mpp.ui.controllers;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.CustomerDTO;
import com.mum.mpp.model.Customer;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.CustomerCell;
import com.mum.mpp.ui.model.FXMLRessources;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class TableCustomerController implements Initializable {

	@FXML
	private GridPane main;
	@FXML
	private JFXTreeTableView<CustomerCell> treeView;

	private ObservableList<CustomerCell> customers = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		JFXTreeTableColumn<CustomerCell, String> idCol = new JFXTreeTableColumn<>(CustomerCell.COLUMN_ID);
		idCol.setPrefWidth(150);
		idCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<CustomerCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerCell, String> param) {
						return param.getValue().getValue().getId();
					}
				});

		JFXTreeTableColumn<CustomerCell, String> fNameCol = new JFXTreeTableColumn<>(CustomerCell.COLUMN_FNAME);
		fNameCol.setPrefWidth(150);
		fNameCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<CustomerCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerCell, String> param) {
						return param.getValue().getValue().getfName();
					}
				});

		JFXTreeTableColumn<CustomerCell, String> lNameCol = new JFXTreeTableColumn<>(CustomerCell.COLUMN_LNAME);
		lNameCol.setPrefWidth(150);
		lNameCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<CustomerCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<CustomerCell, String> param) {
						return param.getValue().getValue().getlName();
					}
				});

		fNameCol.setCellFactory((TreeTableColumn<CustomerCell, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		fNameCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<CustomerCell, String>>() {

			@Override
			public void handle(CellEditEvent<CustomerCell, String> t) {
				// TODO Auto-generated method stub
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()
						.setfName(new SimpleStringProperty(t.getNewValue()));
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getCustomer()
						.setFirstName(t.getNewValue());
				App.appUtils.getCustomerService().update(
						t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getCustomer());
			}
		});

		lNameCol.setCellFactory((TreeTableColumn<CustomerCell, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		lNameCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<CustomerCell, String>>() {

			@Override
			public void handle(CellEditEvent<CustomerCell, String> t) {
				// TODO Auto-generated method stub
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()
						.setlName(new SimpleStringProperty(t.getNewValue()));
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getCustomer()
						.setLastName(t.getNewValue());
				App.appUtils.getCustomerService().update(
						t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getCustomer());
			}
		});

		fillCustomers(App.appUtils.getCustomerService().getAll());

		final TreeItem<CustomerCell> root = new RecursiveTreeItem<CustomerCell>(customers,
				RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(idCol, fNameCol, lNameCol);
		treeView.setEditable(true);
		treeView.setShowRoot(false);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
	}

	@FXML
	private void delete(ActionEvent event) {
		if (!customers.isEmpty() && treeView.getSelectionModel().getSelectedIndex() != -1) {
			if (App.appUtils.getCustomerService()
					.delete(treeView.getSelectionModel().getSelectedItem().getValue().getId().get()))
				customers.remove(treeView.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void add(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_CUSTOMER_ADD, FXMLRessources.FXML_CUSTOMER_ADD);
	}

	private void fillCustomers(List<CustomerDTO> customersDTO) {
		for (CustomerDTO customer : customersDTO)
			customers.add(new CustomerCell(customer));
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
