package com.mum.mpp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SecDealPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "dealId")
	private String dealId;

	@Column(name = "tranId")
	private int tranNo;

	public SecDealPK() {
	}

	public SecDealPK(String dealId, int tranNo) {
		super();
		this.dealId = dealId;
		this.tranNo = tranNo;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public int getTranNo() {
		return tranNo;
	}

	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

}
