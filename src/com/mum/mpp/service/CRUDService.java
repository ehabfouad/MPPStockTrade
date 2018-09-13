package com.mum.mpp.service;

import java.io.Serializable;
import java.util.List;

import com.mum.mpp.dto.DTO;

public interface CRUDService<D extends DTO, ID extends Serializable> {
	
	public D create(D d);
	public D update(D d);
	public List<D> getAll();
	public D get(ID id);
	public boolean delete (ID id);

}
