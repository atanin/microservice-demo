package com.example.demo.paymentorder.domain;

import java.math.BigDecimal;

public class DiscountedOrder extends Order {
	private BigDecimal discount = new BigDecimal(0);

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
	public BigDecimal getTotalPrice() {
		BigDecimal price = super.getTotalPrice();
		BigDecimal discount = price.multiply(this.discount.divide(new BigDecimal(100)));
		price = price.add(discount.negate());
		return price;
	}
}
