package com.mum.mpp.dto;

public class BankAccountDTO extends AccountDTO{

	public BankAccountDTO() {
		super();
	}

	public BankAccountDTO(String id, String type, String currency, double balance, String customerId,
			String portfolioId) {
		super(id, type, currency, balance, customerId, portfolioId);
	}

}
