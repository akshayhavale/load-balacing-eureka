package com.restuarant.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.restuarant.model.Customer;

@FeignClient(name = "${customer.service.url}")
public interface CustomerService {

	@GetMapping("/id/{id}")
	public Customer getById(@PathVariable(value = "id") Long id);

}
