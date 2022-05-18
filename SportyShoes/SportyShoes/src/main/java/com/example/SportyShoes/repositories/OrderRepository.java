package com.example.SportyShoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.SportyShoes.entities.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

}
