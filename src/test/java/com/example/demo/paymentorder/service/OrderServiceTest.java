package com.example.demo.paymentorder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.demo.paymentorder.domain.DiscountedOrder;
import com.example.demo.paymentorder.domain.Order;
import com.example.demo.paymentorder.domain.OrderItem;
import com.example.demo.paymentorder.exception.InvalidOrderException;
import com.example.demo.paymentorder.repository.OrderRepository;
import com.example.demo.shop.domain.Ticket;
import com.example.demo.shop.service.ShopService;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({ "javax.management.*" })
public class OrderServiceTest {
	OrderService orderService = new OrderService();

	@Mock
	private OrderRepository orderRepository;

	@Mock
	private ShopService shopService;

	
	@Before
	public void setup() {
		Whitebox.setInternalState(orderService, "orderRepository", orderRepository);
		Whitebox.setInternalState(orderService, "shopService", shopService);
		com.example.demo.paymentorder.repository.model.Order orderModel = new com.example.demo.paymentorder.repository.model.Order();
		orderModel.setOrderId("test_order_id");
		Mockito.when(orderRepository.save(Mockito.any(com.example.demo.paymentorder.repository.model.Order.class)))
				.thenReturn(orderModel);
		
		Ticket mockTicket = new Ticket(30.0);
		Mockito.when(shopService.getDiscount()).thenReturn(mockTicket);
	}

	@Test
	public void processOrder_success() {
		// Given
		Order requestOrder = new Order();
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(new Long(1));
		orderItem.setItemName("Mouse");
		orderItem.setPrice(new BigDecimal(50));
		List<OrderItem> itemList = new ArrayList();
		itemList.add(orderItem);
		requestOrder.setOrderItems(itemList);

		// When
		try 
		{
			DiscountedOrder processedOrder = orderService.processOrder(requestOrder);

			// Then
			assertEquals("test_order_id", processedOrder.getOrderId());
//			assertEquals(new BigDecimal(30), processedOrder.getDiscount());
//			assertEquals(new BigDecimal(35.0).setScale(2), processedOrder.getTotalPrice());
			List<OrderItem> processedOrderItems = processedOrder.getOrderItems();
			assertEquals(new Long(1), processedOrderItems.get(0).getItemId());
			assertEquals("Mouse", processedOrderItems.get(0).getItemName());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test(expected = InvalidOrderException.class)
	public void processOrder_shouldThrowInvalidOrderException() throws Exception {
		// Given
		Order requestOrder = new Order();
		List<OrderItem> itemList = new ArrayList();
		requestOrder.setOrderItems(itemList);

		// When
		DiscountedOrder processedOrder = orderService.processOrder(requestOrder);

	}
}
