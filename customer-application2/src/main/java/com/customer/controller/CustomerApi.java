package com.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerApi.class);

	private static List<Customer> list = new ArrayList<>();
	static {
		Customer c1 = new Customer(1L, "Akshay", "Hubli");
		Customer c2 = new Customer(2L, "Vineeth", "Bangalore");
		list.add(c1);
		list.add(c2);
	}

	@GetMapping("/id/{id}")
	public Customer getById(@PathVariable(value = "id") Long id) {
		LOGGER.info("ENTERED CUSTOME-SERVICE-2 GET CUSTOMER BY ID METHOD");
		return list.stream().filter(cust -> cust.getId().longValue() == id.longValue()).findFirst().get();
	}

}
