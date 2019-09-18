package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAO implements GenericDAO<Customer> {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate Session
		Session session = sessionFactory.getCurrentSession();
		
		// create query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		// execute query and get result list
		List<Customer> resultList = query.getResultList();
		
		// return results
		return resultList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int cusId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, cusId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int cusId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, cusId);
		
		session.delete(customer);
		
	}

	@Override
	public List<Customer> searchCustomer(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(!name.isEmpty() && name.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) "
					+ "like :theName or lower(lastName) like :theName", Customer.class);
			query.setParameter("theName", "%" + name.toLowerCase() + "%");
		} else {
			query = session.createQuery("from Customer order by lastName", Customer.class);
		}
		
		List<Customer> resultList = query.getResultList();
		
		return resultList;
	}

}
