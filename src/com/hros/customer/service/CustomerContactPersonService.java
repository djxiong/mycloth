package com.hros.customer.service;

import java.util.List;

import com.hros.customer.domain.CustomerContactPerson;

public interface CustomerContactPersonService {
	public List<CustomerContactPerson> selectCustomerContactPerson(int customerId);
	
	public CustomerContactPerson saveCustomerContactPerson(CustomerContactPerson customerContactPerson);
	
	public boolean deleteCustomerContactPerson(int contactID);
}
