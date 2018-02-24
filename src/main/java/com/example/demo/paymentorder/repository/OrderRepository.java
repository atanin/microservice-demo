package com.example.demo.paymentorder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.paymentorder.repository.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
