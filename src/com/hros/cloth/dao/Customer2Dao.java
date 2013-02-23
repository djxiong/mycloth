package com.hros.cloth.dao;

import java.util.List;

import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;



public interface Customer2Dao {

	Customer2 getCustomerByID(int customerID);
	
	void updateCustomer(Customer2 customer);
 
	void insertCustomer(Customer2 customer);
 
	void deleteCustomer(int customerID);
	

	Customer2 getCustomeresByNumber(String number);
	
	List<Customer2> findCustomersByNumber(String number);
	
	List<Customer2> findCustomersByName(String name);
	
	List<Customer2> getAllCustomers();
 
}
