package com.example.demo.shop.domain;

public class InvalidDiscountException extends Exception {
	
	public InvalidDiscountException(String err) {
		System.out.println(err);
	}

}
