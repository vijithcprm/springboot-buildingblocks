package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrdersByUserId(@PathVariable("userid") Long userid) throws UserNotFoundException {

		Optional<User> userOptional = userRepository.findById(userid);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}

		return userOptional.get().getOrders();

	}

	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable("userid") Long userid, @RequestBody Order order)
			throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);

	}

	@GetMapping("/{userid}/orders/{orderid}")
	public Order getOrderByOrderId(@PathVariable("userid") Long userid, @PathVariable("orderid") Long orderid)
			throws UserNotFoundException, OrderNotFoundException {
		Optional<User> userOptional = userRepository.findById(userid);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found");
		}

		Optional<Order> optionalOrder = orderRepository.findById(orderid);

		if (!userOptional.isPresent()) {
			throw new OrderNotFoundException("Order not found");
		}

		Order order = optionalOrder.get();
		order.setUser(userOptional.get());

		return orderRepository.findById(order.getOrderId()).get();

	}

}
