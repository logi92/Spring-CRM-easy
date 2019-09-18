package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface GenericDAO<T> {

	public List<T> getCustomers();

	public void saveCustomer(Customer customer);

	public T getCustomer(int cusId);

	public void deleteCustomer(int cusId);

	public List<T> searchCustomer(String name);
}
