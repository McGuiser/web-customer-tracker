package com.corey.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corey.springdemo.entity.Customer;
import com.corey.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	// Autowire the CustomerService
	
	@Autowired
	private CustomerService customerService;
	
	// Add mapping for GET /customers
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}
	
	// Add mapping for GET /customers/{customerId}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}
		
		return theCustomer;
	}
	
	// Add mapping for POST /customers - add new customer
	
	@PostMapping("/customers")
	private Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// Set id to 0 to force save
		
		theCustomer.setId(0);
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// Add mapping for PUT /customers - update new customer
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// Add mapping for DELETE /customers/{customerId} - delete new customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		// Throw exception if null
		
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id: " + customerId;
	}

}
