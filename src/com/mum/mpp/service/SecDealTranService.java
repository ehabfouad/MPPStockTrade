package com.mum.mpp.service;

import java.util.List;

import com.mum.mpp.dao.AccountDAO;
import com.mum.mpp.dao.CustomerDAO;
import com.mum.mpp.dao.PortfolioDAO;
import com.mum.mpp.dao.SecDealTranDAO;
import com.mum.mpp.dao.SecurityDAO;
import com.mum.mpp.dto.SecDealTranDTO;
import com.mum.mpp.model.Account;
import com.mum.mpp.model.Customer;
import com.mum.mpp.model.Portfolio;
import com.mum.mpp.model.SecDealTran;
import com.mum.mpp.model.Security;
import com.mum.mpp.service.transformers.SecDealTranMapper;

public class SecDealTranService implements CRUDService<SecDealTranDTO, String>{

	private SecDealTranDAO secDealTranDAO;
	private CustomerDAO customerDAO;
	private PortfolioDAO portfolioDAO;
	private AccountDAO accountDAO;
	private SecurityDAO securityDAO;
	private SecDealTranMapper secDealTranMapper;
	
	public SecDealTranService() {
		secDealTranDAO = new SecDealTranDAO();
		customerDAO = new CustomerDAO();
		portfolioDAO = new PortfolioDAO();
		accountDAO = new AccountDAO();
		securityDAO = new SecurityDAO();
		secDealTranMapper = new SecDealTranMapper();
	}
	
	@Override
	public SecDealTranDTO create(SecDealTranDTO secDealTranDTO) {
		SecDealTran secDealTran = secDealTranMapper.mapDtoToEntity(secDealTranDTO);
		Customer customer = customerDAO.get(secDealTranDTO.getCustomerId());
		Portfolio portfolio = portfolioDAO.get(secDealTranDTO.getPortfolioId());
		Account account = accountDAO.get(secDealTranDTO.getAccountId());
		Security security = securityDAO.get(secDealTranDTO.getSecurityIsinNbr());
		secDealTran.setCustomer(customer);
		secDealTran.setPortfolio(portfolio);
		secDealTran.setAccount(account);
		secDealTran.setSecurity(security);
		secDealTranDAO.create(secDealTran);
		
		//Assumption : client is always Buying and we maintain client part only!!
		if(secDealTranDTO.getTranId().equals("0")) {
			//so we need to increase his securities
			portfolio.getSecurities().add(security);
			portfolioDAO.update(portfolio);
			
			// and decrease the client balance
			double updatedBalance = account.getBalance() - ( secDealTran.getPrice() * secDealTran.getQuantity() );
			account.setBalance(updatedBalance);
			accountDAO.update(account);
		}
		return secDealTranDTO;
	}

	@Override
	public SecDealTranDTO update(SecDealTranDTO d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecDealTranDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecDealTranDTO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
