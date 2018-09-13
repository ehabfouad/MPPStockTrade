package com.mum.mpp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bond")
public class BondSecurity extends Security{

	private static final long serialVersionUID = 1L;

}
