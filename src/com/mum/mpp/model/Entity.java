/**
 * 
 */
package com.mum.mpp.model;

import java.io.Serializable;

public interface Entity<T extends Serializable> extends Serializable{

	public abstract T getPrimaryKey();

}