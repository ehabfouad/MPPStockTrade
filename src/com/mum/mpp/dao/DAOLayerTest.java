package com.mum.mpp.dao;

import com.mum.mpp.model.Account;
import com.mum.mpp.model.ClientAccount;
import com.mum.mpp.model.Customer;
import com.mum.mpp.model.Portfolio;
import com.mum.mpp.model.Security;
import com.mum.mpp.model.ShareSecurity;

public class DAOLayerTest {
	
	public static void main(String[] args) {
		
		/*SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Customer customer = new Customer();
		customer.setId("Cust#1");
		customer.setFirstName("Ehab");
		customer.setLastName("Tarek");
		Transaction tx = session.beginTransaction();
		session.save(customer);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();*/
		
		/*Customer customer = new Customer();
		customer.setId("Cust#3");
		customer.setFirstName("Ayamn");
		customer.setLastName("Adel");
		new CustomerDAO().create(customer);
		
		Security security = new ShareSecurity();
		security.setIsinNbr("isnNbr#1");
		security.setName("Vodafone");
		security.setPrice(5000);
		new SecurityDAO().create(security);
		
		Portfolio portfolio = new Portfolio();
		portfolio.setId("w1");
		portfolio.setStockPlace("EGP");
		portfolio.setCustomer(new CustomerDAO().get("Cust#3"));
		new PortfolioDAO().create(portfolio);
		
		Account account = new ClientAccount();
		account.setId("Acc#3");
		account.setCurrency("EGP");
		account.setBalance(500);
		account.setPortfolio(new PortfolioDAO().get("w1"));
		account.setCustomer(new CustomerDAO().get("Cust#3"));
		new AccountDAO().create(account	);*/
		
		ShareSecurity security = new ShareSecurity();
		security.setIsinNbr("isnNbr#3");
		security.setName("RealState");
		security.setPrice(3000);
		new SecurityDAO().create(security);
		
		/*Portfolio loadPortfolio = new PortfolioDAO().get("w1");
		loadPortfolio.getSecurities().add( new SecurityDAO().get("isnNbr#1"));
		new PortfolioDAO().update(loadPortfolio);*/
		
		/*List<Customer> customers = new CustomerDAO().getAll();
		System.out.println(customers);*/
	}
}
