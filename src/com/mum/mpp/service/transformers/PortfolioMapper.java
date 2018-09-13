package com.mum.mpp.service.transformers;

import com.mum.mpp.dto.PortfolioDTO;
import com.mum.mpp.model.Portfolio;
import com.mum.mpp.model.Security;

public class PortfolioMapper extends DozerMapperImp<Portfolio, PortfolioDTO>{

	@Override
	public PortfolioDTO mapEntityToDto(Portfolio entity) {
		PortfolioDTO portfolioDTO = super.mapEntityToDto(entity);
		portfolioDTO.setCustomerId(entity.getCustomer().getId());
		for (Security security : entity.getSecurities()) {
			portfolioDTO.getSecurityList().add(security.getIsinNbr());
			
		}
		return portfolioDTO;
	}
}
