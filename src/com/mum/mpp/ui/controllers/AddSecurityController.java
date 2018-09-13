package com.mum.mpp.ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXTextField;
import com.mum.mpp.dto.BondSecurityDTO;
import com.mum.mpp.dto.ShareSecurityDTO;
import com.mum.mpp.service.SecurityService;
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
public class AddSecurityController implements Initializable {

	@FXML
	private JFXTextField securityId;

	@FXML
	private JFXTextField name;

	@FXML
	private JFXTextField type;

	@FXML
	private JFXTextField price;

	private JFXListView<Label> list = new JFXListView<>();

	@FXML
	private void cancel(ActionEvent event) {
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITY_TABLE, FXMLRessources.FXML_CUSTOMER_TABLE);
	}

	@FXML
	private void add(ActionEvent event) {
		String secType = type.getText();
		if( secType.equals(SecurityService.SHARE)) {
			App.appUtils.getSecurityService().create(
					new ShareSecurityDTO(securityId.getText(), name.getText(), type.getText(), Double.valueOf(price.getText())));
		}else {
			App.appUtils.getSecurityService().create(
					new BondSecurityDTO(securityId.getText(), name.getText(), type.getText(), Double.valueOf(price.getText())));
		}
		
		App.appUtils.loadScene(FXMLRessources.TITLE_SECURITY_TABLE, FXMLRessources.FXML_SECURITY_TABLE);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setupTypeListView();
	}

	private void setupTypeListView() {
		type.setEditable(false);

		list.getItems().add(new Label(App.appUtils.getSecurityService().SHARE));
		list.getItems().add(new Label(App.appUtils.getSecurityService().BOND));

		JFXPopup popup = new JFXPopup(list);

		type.setOnMouseClicked(e -> popup.show(type, PopupVPosition.TOP, PopupHPosition.LEFT));

		popup.setOnHidden(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				type.setText(list.getSelectionModel().getSelectedItem().getText());
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
