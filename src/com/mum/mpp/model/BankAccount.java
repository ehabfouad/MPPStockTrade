package com.mum.mpp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bank")
public class BankAccount extends Account{

	private static final long serialVersionUID = 1L;

}
