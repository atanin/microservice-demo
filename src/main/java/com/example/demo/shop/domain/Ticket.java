package com.example.demo.shop.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Ticket {

	private String id;
	private Boolean isUsed;
	private BigDecimal discount;

	public Ticket(Double discount) {
		this.id = String.valueOf(UUID.randomUUID());
		this.isUsed = false;
		this.discount = BigDecimal.valueOf(discount);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

}
