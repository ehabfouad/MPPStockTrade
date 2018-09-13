package com.mum.mpp.service.transformers;

import com.mum.mpp.dto.AccountDTO;
import com.mum.mpp.model.Account;

public class AccountMapper extends DozerMapperImp<Account, AccountDTO>{

	@Override
	public AccountDTO mapEntityToDto(Account entity) {
		AccountDTO accountDTO = super.mapEntityToDto(entity);
		accountDTO.setCustomerId(entity.getCustomer().getId());
		accountDTO.setPortfolioId(entity.getPortfolio().getId());
		return accountDTO;
	}
	
}
