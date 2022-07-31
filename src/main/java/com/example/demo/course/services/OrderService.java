package com.example.demo.course.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.entities.Order;
import com.example.demo.course.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		
		return orderRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Order not found"));
	}
}
