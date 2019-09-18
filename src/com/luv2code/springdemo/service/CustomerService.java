package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int cusId);

	public void deleteCustomer(int cusId);

	public List<Customer> searchCustomer(String name);
}
