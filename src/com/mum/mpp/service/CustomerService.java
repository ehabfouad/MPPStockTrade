package com.mum.mpp.service;

import java.util.ArrayList;
import java.util.List;

import com.mum.mpp.dao.CustomerDAO;
import com.mum.mpp.dto.CustomerDTO;
import com.mum.mpp.model.Customer;
import com.mum.mpp.service.transformers.CustomerMapper;

public class CustomerService implements CRUDService<CustomerDTO, String>{

	private CustomerDAO customerDAO;
	
	private CustomerMapper customerMapper;
	
	public CustomerService() {
		customerMapper = new CustomerMapper();
		customerDAO = new CustomerDAO();
	}
	
	@Override
	public CustomerDTO create(CustomerDTO customerDTO) {
		Customer customer = customerMapper.mapDtoToEntity(customerDTO);
		customerDAO.create(customer);
		return customerDTO;
	}

	@Override
	public CustomerDTO update(CustomerDTO customerDTO) {
		Customer customer = customerMapper.mapDtoToEntity(customerDTO);
		customerDAO.update(customer);
		return customerDTO;
	}

	@Override
	public List<CustomerDTO> getAll() {
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		
		List<Customer> customers = customerDAO.getAll();
		for (Customer customer : customers) {
			customerList.add(customerMapper.mapEntityToDto(customer));
		}
		return customerList;
	}

	@Override
	public boolean delete(String id) {
		return customerDAO.delete(id);
	}
	
	
	@Override
	public CustomerDTO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
