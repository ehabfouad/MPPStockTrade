package com.mum.mpp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Client")
public class ClientAccount extends Account{

	private static final long serialVersionUID = 1L;
	
}
