package com.hros.insurance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.InsuranceInfo;

@Repository
public interface InsuranceDao {

	InsuranceInfo getInsuranceByID(Integer id);
	
	void updateInsurance(InsuranceInfo InsuranceInfo);
	
	void insertInsurance(InsuranceInfo InsuranceInfo);
	
	void deleteInsurance(Integer id);
	
	List<InsuranceInfo> findInsuranceByTreeNodeID(Integer treeNodeID);

	
}
