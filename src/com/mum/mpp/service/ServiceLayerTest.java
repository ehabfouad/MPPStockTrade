package com.mum.mpp.service;

import com.mum.mpp.dto.CustomerDTO;

public class ServiceLayerTest {

	public static void main(String[] args) {
		/*CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId("Cust#4");
		customerDTO.setFirstName("Mohamed");
		customerDTO.setLastName("Essam");
		new CustomerService().create(customerDTO);*/
		
//		new CustomerService().getAll();
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId("Cust#4");
		customerDTO.setFirstName("Sara");
		customerDTO.setLastName("Fahmy");
		new CustomerService().update(customerDTO);
		
	}
	
	
}
