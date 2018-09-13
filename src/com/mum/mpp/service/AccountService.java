package com.mum.mpp.service;

import java.util.ArrayList;
import java.util.List;

import com.mum.mpp.dao.AccountDAO;
import com.mum.mpp.dao.CustomerDAO;
import com.mum.mpp.dao.PortfolioDAO;
import com.mum.mpp.dto.AccountDTO;
import com.mum.mpp.dto.ClientAccountDTO;
import com.mum.mpp.model.Account;
import com.mum.mpp.model.BankAccount;
import com.mum.mpp.model.ClientAccount;
import com.mum.mpp.model.Customer;
import com.mum.mpp.model.Portfolio;
import com.mum.mpp.service.transformers.AccountMapper;
import com.mum.mpp.service.transformers.BankAccountMapper;
import com.mum.mpp.service.transformers.ClientAccountMapper;

public class AccountService implements CRUDService<AccountDTO, String> {

	public static final String CLIENT= "Client";
	public static final String BANK= "Bank";
	
	private AccountDAO accountDAO;
	private CustomerDAO customerDAO;
	private PortfolioDAO portfolioDAO;
	private AccountMapper accountMapper;
	private ClientAccountMapper clientAccountMapper;
	private BankAccountMapper bankAccountMapper;
	
	public AccountService() {
		accountDAO = new AccountDAO();
		customerDAO = new CustomerDAO();
		portfolioDAO = new PortfolioDAO();
		accountMapper = new AccountMapper();
		clientAccountMapper = new ClientAccountMapper();
		bankAccountMapper = new BankAccountMapper();
	}
	
	@Override
	public AccountDTO create(AccountDTO accountDTO) {
		if( accountDTO instanceof ClientAccountDTO) {
			ClientAccount account = clientAccountMapper.mapDtoToEntity(accountDTO);
			
			Customer customer = customerDAO.get(accountDTO.getCustomerId());
			Portfolio portfolio = portfolioDAO.get(accountDTO.getPortfolioId());
			
			account.setCustomer(customer);
			account.setPortfolio(portfolio);
			
			accountDAO.create(account);
		}else {
			BankAccount account = bankAccountMapper.mapDtoToEntity(accountDTO);
			
			Customer customer = customerDAO.get(accountDTO.getCustomerId());
			Portfolio portfolio = portfolioDAO.get(accountDTO.getPortfolioId());
			
			account.setCustomer(customer);
			account.setPortfolio(portfolio);
			
			accountDAO.create(account);
		}
		return accountDTO;
	}

	@Override
	public AccountDTO update(AccountDTO accountDTO) {
		Account account = accountMapper.mapDtoToEntity(accountDTO);
		accountDAO.update(account);
		return accountDTO;
	}

	@Override
	public List<AccountDTO> getAll() {
		List<AccountDTO> accountList = new ArrayList<AccountDTO>();
		
		List<Account> accounts = accountDAO.getAll();
		for (Account accuont : accounts) {
			accountList.add(accountMapper.mapEntityToDto(accuont));
		}
		return accountList;
	}

	@Override
	public boolean delete(String id) {
		return accountDAO.delete(id);
	}
	
	@Override
	public AccountDTO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
