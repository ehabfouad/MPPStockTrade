package com.mum.mpp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.HashCodeBuilder;


@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements Entity<T> {

	private static final long serialVersionUID = 1L;

	@Column(name="status") 
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int hashCode() {
		if (getPrimaryKey() == null) {
			return new HashCodeBuilder(17, 31).append(super.hashCode())
					.toHashCode();
		} else {
			return new HashCodeBuilder(17, 31).append(getPrimaryKey())
					.toHashCode();
		}

	}


	@SuppressWarnings("unchecked")
	public boolean equals(Object object) {
		if(object!=null)
		{
		if (!getClass().isAssignableFrom(object.getClass())) {
			return false;
		}
		Entity<T> other = ((Entity<T>) object);

		if (this.getPrimaryKey() != other.getPrimaryKey()
				&& (this.getPrimaryKey() == null || !this.getPrimaryKey()
						.equals(other.getPrimaryKey())))
			return false;
		return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[primaryKey="
				+ getPrimaryKey() + "]";
	}
}
