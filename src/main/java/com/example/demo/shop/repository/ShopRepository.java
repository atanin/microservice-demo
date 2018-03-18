package com.example.demo.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.shop.repository.model.Shop;


@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

}
