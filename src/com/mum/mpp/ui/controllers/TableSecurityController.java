package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mum.mpp.dto.SecurityDTO;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.FXMLRessources;
import com.mum.mpp.ui.model.SecurityCell;

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

public class TableSecurityController implements Initializable {

	@FXML
	private GridPane main;
	@FXML
	private JFXTreeTableView<SecurityCell> treeView;

	private ObservableList<SecurityCell> securities = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		JFXTreeTableColumn<SecurityCell, String> isinNbrCol = new JFXTreeTableColumn<>(SecurityCell.COLUMN_ISIN_NBR);
		isinNbrCol.setPrefWidth(150);
		isinNbrCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<SecurityCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<SecurityCell, String> param) {
						return param.getValue().getValue().getIsinNbr();
					}
				});

		JFXTreeTableColumn<SecurityCell, String> nameCol = new JFXTreeTableColumn<>(SecurityCell.COLUMN_NAME);
		nameCol.setPrefWidth(150);
		nameCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<SecurityCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<SecurityCell, String> param) {
						return param.getValue().getValue().getName();
					}
				});

		JFXTreeTableColumn<SecurityCell, String> typeCol = new JFXTreeTableColumn<>(SecurityCell.COLUMN_TYPE);
		typeCol.setPrefWidth(150);
		typeCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<SecurityCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<SecurityCell, String> param) {
						return param.getValue().getValue().getType();
					}
				});

		JFXTreeTableColumn<SecurityCell, String> priceCol = new JFXTreeTableColumn<>(SecurityCell.COLUMN_PRICE);
		priceCol.setPrefWidth(150);
		priceCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<SecurityCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<SecurityCell, String> param) {
						return param.getValue().getValue().getPrice();
					}
				});

		nameCol.setCellFactory((TreeTableColumn<SecurityCell, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		nameCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<SecurityCell, String>>() {

			@Override
			public void handle(CellEditEvent<SecurityCell, String> t) {
				// TODO Auto-generated method stub
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()
						.setName(new SimpleStringProperty(t.getNewValue()));
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getSecurity()
						.setName(t.getNewValue());
				App.appUtils.getSecurityService().update(
						t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getSecurity());
			}
		});

		priceCol.setCellFactory((TreeTableColumn<SecurityCell, String> param) -> new GenericEditableTreeTableCell<>(
				new TextFieldEditorBuilder()));

		priceCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<SecurityCell, String>>() {

			@Override
			public void handle(CellEditEvent<SecurityCell, String> t) {
				// TODO Auto-generated method stub
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()
						.setPrice(new SimpleStringProperty(t.getNewValue()));
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getSecurity()
						.setPrice(Double.valueOf(t.getNewValue()));
				App.appUtils.getSecurityService().update(
						t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getSecurity());
			}
		});

		fillCustomers(App.appUtils.getSecurityService().getAll());

		final TreeItem<SecurityCell> root = new RecursiveTreeItem<SecurityCell>(securities,
				RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(isinNbrCol, nameCol, typeCol, priceCol);
		treeView.setEditable(true);
		treeView.setShowRoot(false);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
	}

	@FXML
	private void delete(ActionEvent event) {
		if (!securities.isEmpty() && treeView.getSelectionModel().getSelectedIndex() != -1) {
			if (App.appUtils.getSecurityService()
					.delete(treeView.getSelectionModel().getSelectedItem().getValue().getIsinNbr().get()))
				securities.remove(treeView.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void add(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITY_ADD, FXMLRessources.FXML_SECURITY_ADD);
	}

	private void fillCustomers(List<SecurityDTO> securitiesDTO) {
		for (SecurityDTO security : securitiesDTO)
			securities.add(new SecurityCell(security));
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
