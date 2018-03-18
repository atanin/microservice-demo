package com.example.demo.shop.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {

	private List<Ticket> ticketList;

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	
	public Ticket useTicket()  {
		for (Ticket ticket : ticketList) {
			if(!ticket.getIsUsed()) {
				ticket.setIsUsed(true);
				return ticket;
			}
		}
		return null;
	}
	
	public Ticket createTicket(Double discount) throws InvalidDiscountException {
		if(discount.doubleValue() < 0) {
			throw new InvalidDiscountException("Invalid Discount amount : "+ String.valueOf(discount.doubleValue()));
		}
		Ticket ticket = new Ticket(discount);
		ticketList.add(ticket);
		return ticket;
	}
	
	public List<Ticket> checkUnusedTickets() {
		List<Ticket> unusedTickets = new ArrayList<Ticket>();
		for (Ticket ticket : ticketList) {
			if(!ticket.getIsUsed()) {
				unusedTickets.add(ticket);
			}
		}
		return unusedTickets;
	}

}
