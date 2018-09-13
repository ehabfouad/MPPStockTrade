package com.mum.mpp.service;

import java.util.ArrayList;
import java.util.List;

import com.mum.mpp.dao.SecurityDAO;
import com.mum.mpp.dto.SecurityDTO;
import com.mum.mpp.dto.ShareSecurityDTO;
import com.mum.mpp.model.BondSecurity;
import com.mum.mpp.model.Security;
import com.mum.mpp.model.ShareSecurity;
import com.mum.mpp.service.transformers.BondSecurityMapper;
import com.mum.mpp.service.transformers.SecurityMapper;
import com.mum.mpp.service.transformers.ShareSecurityMapper;

public class SecurityService implements CRUDService<SecurityDTO, String>{

	public static final String SHARE= "Share";
	public static final String BOND= "Bond";
	
	private SecurityDAO securityDAO;
	
	private SecurityMapper securityMapper;
	private ShareSecurityMapper shareSecurityMapper;
	private BondSecurityMapper bondSecurityMapper;
	
	public SecurityService() {
		securityDAO = new SecurityDAO();
		securityMapper = new SecurityMapper();
		shareSecurityMapper = new ShareSecurityMapper();
		bondSecurityMapper = new BondSecurityMapper();
	}
	
	
	@Override
	public SecurityDTO create(SecurityDTO securityDTO) {
		if( securityDTO instanceof ShareSecurityDTO) {
			ShareSecurity security = shareSecurityMapper.mapDtoToEntity(securityDTO);
			securityDAO.create(security);
		}else {
			BondSecurity security = bondSecurityMapper.mapDtoToEntity(securityDTO);
			securityDAO.create(security);
		}
		return securityDTO;
	}

	@Override
	public SecurityDTO update(SecurityDTO securityDTO) {
		Security security = securityMapper.mapDtoToEntity(securityDTO);
		securityDAO.update(security);
		return securityDTO;
	}

	@Override
	public List<SecurityDTO> getAll() {
		List<SecurityDTO> securityList = new ArrayList<SecurityDTO>();
		
		List<Security> securities = securityDAO.getAll();
		for (Security security : securities) {
			securityList.add(securityMapper.mapEntityToDto(security));
		}
		return securityList;
	}

	@Override
	public boolean delete(String id) {
		return securityDAO.delete(id);
	}
	
	@Override
	public SecurityDTO get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
