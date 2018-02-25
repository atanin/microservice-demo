package com.example.demo.paymentorder.repository.model;

import java.math.BigDecimal;

public enum ShopEnum {
	SHOPA(new Long(1),new BigDecimal(30)),
	SHOPB(new Long(2),new BigDecimal(25));
	
	private final Long shopId;
	private final BigDecimal discount;
	
	ShopEnum(Long shopId, BigDecimal discount) {
		this.shopId = shopId;
		this.discount = discount;
	}

	public Long getShopId() {
		return shopId;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

}
