package com.mum.mpp.service.transformers;

public interface Mapper <E, D>{
	
	public D mapEntityToDto(E entity);
	
	public E mapDtoToEntity(D dto);

}
