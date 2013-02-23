package com.hros.customer.dao;

import java.util.List;

import com.hros.customer.domain.CustomerContactPerson;

public interface CustomerContactPersonDao {
	public List<CustomerContactPerson> selectAllCustomerContactPerson();
	
	public List<CustomerContactPerson> selectCustomerContactPerson(int customerId);
	
	public void insertCustomerContactPerson(CustomerContactPerson customerContactPerson);
	
	public void updateCustomerContactPerson(CustomerContactPerson customerContactPerson);
	
	public void deleteCustomerContactPerson(int id);
}
