package com.mum.mpp.service.transformers;

import java.lang.reflect.ParameterizedType;

import org.dozer.DozerBeanMapper;

public abstract class DozerMapperImp<E , D> implements Mapper<E , D>{
	
	private org.dozer.Mapper dozerMapper ;
	
	private Class<E> entityClass;
	private Class<D> dtoClass;
	
	@SuppressWarnings("unchecked")
	public DozerMapperImp() {
		dozerMapper = new DozerBeanMapper();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
	}
	
	public D mapEntityToDto(E entity) {
		return dozerMapper.map(entity, dtoClass);
	}
	
	public E mapDtoToEntity(D dto) {
		return dozerMapper.map(dto, entityClass);
	}

}
