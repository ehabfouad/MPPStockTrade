package com.mum.mpp.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDAO<T, ID extends Serializable> {
	T create(T t);

	T update(T t);

	List<T> getAll();
	
	T get(ID id);
	
	boolean delete(ID id);
}
