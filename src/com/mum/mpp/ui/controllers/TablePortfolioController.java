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
import com.mum.mpp.dto.PortfolioDTO;
import com.mum.mpp.ui.App;
import com.mum.mpp.ui.model.FXMLRessources;
import com.mum.mpp.ui.model.PortfolioCell;

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

public class TablePortfolioController implements Initializable {

	@FXML
	private GridPane main;
	@FXML
	private JFXTreeTableView<PortfolioCell> treeView;

	private ObservableList<PortfolioCell> portfolios = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		JFXTreeTableColumn<PortfolioCell, String> idCol = new JFXTreeTableColumn<>(PortfolioCell.COLUMN_ID);
		idCol.setPrefWidth(150);
		idCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<PortfolioCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PortfolioCell, String> param) {
						return param.getValue().getValue().getId();
					}
				});

		JFXTreeTableColumn<PortfolioCell, String> stockPlaceCol = new JFXTreeTableColumn<>(
				PortfolioCell.COLUMN_STOCK_PLACE);
		stockPlaceCol.setPrefWidth(150);
		stockPlaceCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<PortfolioCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PortfolioCell, String> param) {
						return param.getValue().getValue().getStockPlace();
					}
				});

		JFXTreeTableColumn<PortfolioCell, String> customerIdCol = new JFXTreeTableColumn<>(
				PortfolioCell.COLUMN_CUSTOMER_ID);
		customerIdCol.setPrefWidth(150);
		customerIdCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<PortfolioCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PortfolioCell, String> param) {
						return param.getValue().getValue().getCustomerId();
					}
				});
		
		JFXTreeTableColumn<PortfolioCell, String> securitiesCol = new JFXTreeTableColumn<>(
				PortfolioCell.COLUMN_SECURITIES);
		securitiesCol.setPrefWidth(150);
		securitiesCol.setCellValueFactory(
				new Callback<TreeTableColumn.CellDataFeatures<PortfolioCell, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<PortfolioCell, String> param) {
						return param.getValue().getValue().getSecurities();
					}
				});

		stockPlaceCol
				.setCellFactory((TreeTableColumn<PortfolioCell, String> param) -> new GenericEditableTreeTableCell<>(
						new TextFieldEditorBuilder()));

		stockPlaceCol.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<PortfolioCell, String>>() {

			@Override
			public void handle(CellEditEvent<PortfolioCell, String> t) {
				// TODO Auto-generated method stub
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue()
						.setStockPlace(new SimpleStringProperty(t.getNewValue()));
				t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getPortofolio()
						.setStockPlace(t.getNewValue());
				App.appUtils.getPortfolioService().update(
						t.getTreeTableView().getTreeItem(t.getTreeTablePosition().getRow()).getValue().getPortofolio());
			}
		});

		fillPortofolios(App.appUtils.getPortfolioService().getAll());

		final TreeItem<PortfolioCell> root = new RecursiveTreeItem<PortfolioCell>(portfolios,
				RecursiveTreeObject::getChildren);
		treeView.getColumns().setAll(idCol, stockPlaceCol, customerIdCol,securitiesCol);
		treeView.setEditable(true);
		treeView.setShowRoot(false);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
	}

	@FXML
	private void delete(ActionEvent event) {
		if (!portfolios.isEmpty() && treeView.getSelectionModel().getSelectedIndex() != -1) {
			if (App.appUtils.getPortfolioService()
					.delete(treeView.getSelectionModel().getSelectedItem().getValue().getId().get()))
				portfolios.remove(treeView.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void add(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_PORTFOLIO_ADD, FXMLRessources.FXML_PORTFOLIO_ADD);
	}

	private void fillPortofolios(List<PortfolioDTO> portfoliosDTO) {
		for (PortfolioDTO portfolio : portfoliosDTO)
			portfolios.add(new PortfolioCell(portfolio));
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
