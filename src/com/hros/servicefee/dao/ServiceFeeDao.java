package com.hros.servicefee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.servicefee.domain.ServiceFee;

@Repository
public interface ServiceFeeDao {
	public List<ServiceFee> selectAllServiceFee();
	
	public void insertServiceFee(ServiceFee serviceFee);
	
	public void updateServiceFee(ServiceFee serviceFee);
	
	public void deleteServiceFee(int id);

}