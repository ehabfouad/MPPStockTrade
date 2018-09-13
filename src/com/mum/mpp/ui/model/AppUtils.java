package com.mum.mpp.ui.model;

import java.io.IOException;

import com.mum.mpp.service.AccountService;
import com.mum.mpp.service.CustomerService;
import com.mum.mpp.service.PortfolioService;
import com.mum.mpp.service.SecDealTranService;
import com.mum.mpp.service.SecurityService;
import com.mum.mpp.ui.App;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import lk.vivoxalabs.customstage.CustomStage;
import lk.vivoxalabs.customstage.CustomStageBuilder;
import lk.vivoxalabs.customstage.tools.HorizontalPos;
import lk.vivoxalabs.customstage.tools.NavigationType;

public class AppUtils {
	private App app;
	private CustomStage stage;
	private CustomerService customerService;
	private PortfolioService portfolioService;
	private SecurityService securityService;
	private AccountService accountService;
	private SecDealTranService secDealTranService;

	public AppUtils(App app) {
		this.app = app;
		customerService = new CustomerService();
		portfolioService = new PortfolioService();
		securityService = new SecurityService();
		accountService = new AccountService();
		secDealTranService = new SecDealTranService();
	}

	public void initStage(String title, String fxmlLocation) {
		HBox navigationPane;
		try {
			navigationPane = FXMLLoader.load(app.getClass().getResource(fxmlLocation));
			stage = new CustomStageBuilder().setWindowTitle(title, HorizontalPos.RIGHT, HorizontalPos.CENTER)
					.setNavigationPane(NavigationType.LEFT, navigationPane).setTitleColor("White")
					.setButtonHoverColor("#4FC3F7", "#4FC3F7", "d32f2f").setWindowColor("#01579B").build();
			stage.getIcons().add(new Image(app.getClass().getResourceAsStream("ressources/app_icon.png")));
			stage.setWidth(1300);
			stage.setHeight(800);

			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
			stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public App getApp() {
		return app;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public PortfolioService getPortfolioService() {
		return portfolioService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public SecDealTranService getSecDealTranService() {
		return secDealTranService;
	}

	public void loadScene(String title, String fxmlLocation) {

		try {

			HBox navigationPane = FXMLLoader.load(app.getClass().getResource(fxmlLocation));

			stage.setNavigationPane(NavigationType.LEFT, navigationPane);

			stage.setWindowTitle(title);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
