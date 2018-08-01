package com.corey.springdemo.service;

import java.util.List;

import com.corey.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

}
