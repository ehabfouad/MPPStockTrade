package com.mum.mpp.ui;

import com.mum.mpp.ui.model.AppUtils;
import com.mum.mpp.ui.model.FXMLRessources;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static AppUtils appUtils;
	
    @Override
    public void start(Stage stage) throws Exception {
    	appUtils = new AppUtils(this);
    	appUtils.initStage(FXMLRessources.TITLE_CUSTOMER_TABLE, FXMLRessources.FXML_CUSTOMER_TABLE);
    }

    public static void main(String[] args) {
        launch(args);
    }
   
}
