package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.GenericDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	GenericDAO<Customer> customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int cusId) {
		
		return customerDAO.getCustomer(cusId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int cusId) {

		customerDAO.deleteCustomer(cusId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String name) {
		
		return customerDAO.searchCustomer(name);
	}

}
