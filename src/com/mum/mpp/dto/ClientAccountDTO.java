package com.mum.mpp.dto;

public class ClientAccountDTO extends AccountDTO {

	public ClientAccountDTO() {
		super();
	}

	public ClientAccountDTO(String id, String type, String currency, double balance, String customerId,
			String portfolioId) {
		super(id, type, currency, balance, customerId, portfolioId);
	}

}
