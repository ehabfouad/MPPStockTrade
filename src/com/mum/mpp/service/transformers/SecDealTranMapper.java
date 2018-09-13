package com.mum.mpp.service.transformers;

import com.mum.mpp.dto.SecDealTranDTO;
import com.mum.mpp.model.SecDealPK;
import com.mum.mpp.model.SecDealTran;

public class SecDealTranMapper extends DozerMapperImp<SecDealTran, SecDealTranDTO>{

	@Override
	public SecDealTran mapDtoToEntity(SecDealTranDTO dto) {
		SecDealTran secDealTran = super.mapDtoToEntity(dto);
		secDealTran.setDealIdPK(new SecDealPK(dto.getDealId(), Integer.parseInt(dto.getTranId())));
		secDealTran.setDealLocalDate(dto.getDealDate());
		return secDealTran;
	}
	
	@Override
	public SecDealTranDTO mapEntityToDto(SecDealTran entity) {
		SecDealTranDTO tranDTO = super.mapEntityToDto(entity);
		tranDTO.setCustomerId(entity.getCustomer().getId());
		tranDTO.setPortfolioId(entity.getPortfolio().getId());
		tranDTO.setAccountId(entity.getAccount().getId());
		return tranDTO;
	}
}
