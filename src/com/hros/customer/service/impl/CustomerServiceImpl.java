package com.hros.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.customer.dao.CustomerDao;
import com.hros.customer.domain.Customer;
import com.hros.customer.service.CustomerService;
import com.hros.vaadin.myComponent.FieldAttr;

@Repository
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List selectCustomer(Map map) {
		return customerDao.selectFilterCustomer(map);
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if (customer.getCustID() != 0) {
			customerDao.updateCustomer(customer);
		} else {
			customerDao.insertCustomer(customer);
		}

		return customer;
	}

	@Override
	public Boolean deleteCustomer(int id) {
		try {
			customerDao.deleteCustomer(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
