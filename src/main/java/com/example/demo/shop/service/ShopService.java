package com.example.demo.shop.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.shop.domain.InvalidDiscountException;
import com.example.demo.shop.domain.Shop;
import com.example.demo.shop.domain.Ticket;

public class ShopService {
	
	private Shop shop = new Shop();
	
	public Ticket getDiscount() {
		return shop.useTicket();
	}
	
	public Ticket createTicket(Double discount) throws InvalidDiscountException{
		return shop.createTicket(discount);
	}
	
	public List<Ticket> checkUnusedTicket() {
		return shop.checkUnusedTickets();
	}
}
