package com.example.demo.paymentorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.paymentorder.domain.DiscountedOrder;
import com.example.demo.paymentorder.domain.Order;
import com.example.demo.paymentorder.exception.InvalidOrderException;
import com.example.demo.paymentorder.service.OrderService;

@RestController
public class PaymentOrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping( value = "/paymentorder",consumes="application/json", produces = "application/json" ) 
	public @ResponseBody DiscountedOrder generatePaymentOrder(@RequestBody Order order) throws Exception {
		return orderService.processOrder(order);
	}
	
	@ExceptionHandler (InvalidOrderException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ResponseBody
	public String handleInvalidOrderException(InvalidOrderException e) {
		return e.getMessage();
	}
}
