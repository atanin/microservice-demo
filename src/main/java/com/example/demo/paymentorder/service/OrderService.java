package com.example.demo.paymentorder.service;


import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.paymentorder.domain.DiscountedOrder;
import com.example.demo.paymentorder.domain.Order;
import com.example.demo.paymentorder.exception.InvalidOrderException;
import com.example.demo.paymentorder.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger logger = LogManager.getLogger(OrderService.class);
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public DiscountedOrder processOrder(Order order) throws InvalidOrderException {
		isOrderValid(order);
		
		com.example.demo.paymentorder.repository.model.Order orderModel = new com.example.demo.paymentorder.repository.model.Order();
		//EveryOrderGot 30% discount
		DiscountedOrder discountedOrder = new DiscountedOrder();
		discountedOrder.setOrderItems(order.getOrderItems());
		discountedOrder.setDiscount(new BigDecimal(30));
		orderModel.setOrderPrice(order.getTotalPrice());
		orderModel = orderRepository.save(orderModel);
		discountedOrder.setOrderId(orderModel.getOrderId());
		return discountedOrder;
		
	}
	
	private void isOrderValid(Order order) throws InvalidOrderException {
		logger.debug("Total price is " + order.getTotalPrice());
		if( order.getTotalPrice().compareTo(new BigDecimal(0)) <= 0 ) {
			throw new InvalidOrderException();
		}
	}
}
