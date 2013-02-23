package com.hros.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.customer.dao.CustomerContactPersonDao;
import com.hros.customer.domain.CustomerContactPerson;
import com.hros.customer.service.CustomerContactPersonService;

@Repository
@Transactional
public class CustomerContactPersonServiceImpl implements
		CustomerContactPersonService {
	
	@Autowired
	private CustomerContactPersonDao customerContactPersonDao;

	@Override
	public List selectCustomerContactPerson(int customerId) {
		return customerContactPersonDao.selectCustomerContactPerson(customerId);
	}

	@Override
	public CustomerContactPerson saveCustomerContactPerson(
			CustomerContactPerson customerContactPerson) {
		if (customerContactPerson.getContactID()==0) {
			customerContactPersonDao.insertCustomerContactPerson(customerContactPerson);
		} else {
			customerContactPersonDao.updateCustomerContactPerson(customerContactPerson);
		}
		return customerContactPerson;
	}

	@Override
	public boolean deleteCustomerContactPerson(int contactID) {
		try {
			customerContactPersonDao.deleteCustomerContactPerson(contactID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
