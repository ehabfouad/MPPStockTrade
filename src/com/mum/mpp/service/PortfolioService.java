package com.mum.mpp.service;

import java.util.ArrayList;
import java.util.List;

import com.mum.mpp.dao.CustomerDAO;
import com.mum.mpp.dao.PortfolioDAO;
import com.mum.mpp.dto.PortfolioDTO;
import com.mum.mpp.model.Customer;
import com.mum.mpp.model.Portfolio;
import com.mum.mpp.service.transformers.PortfolioMapper;

public class PortfolioService implements CRUDService<PortfolioDTO, String>{

	private PortfolioDAO portfolioDAO;
	private CustomerDAO customerDAO;
	private PortfolioMapper portfolioMapper;
	
	public PortfolioService() {
		portfolioDAO = new PortfolioDAO();
		customerDAO = new CustomerDAO();
		portfolioMapper = new PortfolioMapper();
	}
	
	@Override
	public PortfolioDTO create(PortfolioDTO portfolioDTO) {
		Portfolio portfolio = portfolioMapper.mapDtoToEntity(portfolioDTO);
		Customer customer = customerDAO.get(portfolioDTO.getCustomerId());
		portfolio.setCustomer(customer);
		portfolioDAO.create(portfolio);
		return portfolioDTO;
	}

	@Override
	public PortfolioDTO update(PortfolioDTO portfolioDTO) {
		Portfolio portfolio = portfolioMapper.mapDtoToEntity(portfolioDTO);
		portfolioDAO.update(portfolio);
		return portfolioDTO;
	}

	@Override
	public List<PortfolioDTO> getAll() {
		List<PortfolioDTO> portfolioList = new ArrayList<PortfolioDTO>();
		List<Portfolio> portfolios = portfolioDAO.getAll();
		for (Portfolio portfolio : portfolios) {
			portfolioList.add(portfolioMapper.mapEntityToDto(portfolio));
		}
		return portfolioList;
	}

	@Override
	public boolean delete(String id) {
		return portfolioDAO.delete(id);
	}

	@Override
	public PortfolioDTO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
