package com.hros.customer.service;

import java.util.List;
import java.util.Map;

import com.hros.customer.domain.Customer;
import com.hros.vaadin.myComponent.FieldAttr;

public interface CustomerService {

	public List selectCustomer(Map map);
	
	public Customer saveCustomer(Customer customer);
	
	public Boolean deleteCustomer(int id);
}
