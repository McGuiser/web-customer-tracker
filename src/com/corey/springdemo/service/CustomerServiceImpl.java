package com.corey.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corey.springdemo.dao.CustomerDAO;
import com.corey.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// Need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
