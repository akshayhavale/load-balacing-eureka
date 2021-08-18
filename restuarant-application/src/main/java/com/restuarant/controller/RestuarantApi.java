package com.restuarant.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restuarant.model.Customer;
import com.restuarant.model.Restuarant;
import com.restuarant.model.RestuarantInfo;
import com.restuarant.service.CustomerService;

@RestController
@RequestMapping("/restuarant")
public class RestuarantApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestuarantApi.class);

	private static Map<Long, RestuarantInfo> map = new HashMap<>();
	static {
		map.put(1L, new RestuarantInfo("Hubli", "Kamat Hotel"));
		map.put(2L, new RestuarantInfo("Bangalore", "Empire hotel"));
		map.put(3L, new RestuarantInfo("Hubli", "Raghavendra Bhavan"));
		map.put(4L, new RestuarantInfo("Bangalore", "Meghana hotel"));
	}
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/id/{id}")
	public Restuarant getRestuarantsByCustomerId(@PathVariable(value = "id") Long id) {
		LOGGER.info("ENTERED CUSTOMER BASED RESTUARANT GET API");
		Customer customer = customerService.getById(id);
		List<String> resturants = map.entrySet().stream()
				.filter(entry -> entry.getValue().getCity().equals(customer.getCity()))
				.map(entry -> entry.getValue().getName()).collect(Collectors.toList());

		return new Restuarant(resturants, customer);

	}

}
