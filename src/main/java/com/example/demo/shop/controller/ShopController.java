package com.example.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.paymentorder.exception.InvalidOrderException;
import com.example.demo.shop.domain.Ticket;
import com.example.demo.shop.service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	
	@PostMapping( value = "/getDiscount",consumes="application/json", produces = "application/json" ) 
	public @ResponseBody Ticket getDiscount() throws Exception {
		
		return shopService.getDiscount();
	}
	
	@ExceptionHandler (InvalidOrderException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	@ResponseBody
	public String handleInvalidOrderException(InvalidOrderException e) {
		return e.getMessage();
	}
}
