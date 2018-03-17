package com.example.demo.paymentorder.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {
	private String orderId;
	private List<OrderItem> orderItems;

	public BigDecimal getTotalPrice() {
		BigDecimal price = new BigDecimal(0).setScale(2);
		for (OrderItem orderItem : orderItems) {
			price = price.add(orderItem.getPrice());
		}
		return price;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
