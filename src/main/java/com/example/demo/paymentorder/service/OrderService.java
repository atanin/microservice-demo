package com.example.demo.paymentorder.service;


import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.paymentorder.domain.Order;
import com.example.demo.paymentorder.exception.InvalidOrderException;
import com.example.demo.paymentorder.repository.OrderRepository;

@Service
public class OrderService {
	private static final Logger logger = LogManager.getLogger(OrderService.class);
	@Autowired
	private OrderRepository orderRepository;
	
	public Order processOrder(Order order) throws InvalidOrderException {
		isOrderValid(order);
		
		com.example.demo.paymentorder.repository.model.Order orderModel = new com.example.demo.paymentorder.repository.model.Order();
		orderModel.setOrderPrice(order.getTotalPrice());
		orderModel = orderRepository.save(orderModel);
		order.setOrderId(orderModel.getOrderId());
		return order;
		
	}
	
	private void isOrderValid(Order order) throws InvalidOrderException {
		logger.debug("Total price is " + order.getTotalPrice());
		if( order.getTotalPrice().compareTo(new BigDecimal(0)) <= 0 ) {
			throw new InvalidOrderException();
		}
	}
}
