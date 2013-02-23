package com.hros.insurance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.InsuranceDetailInfo;

@Repository
public interface InsuranceDetailDao {

	InsuranceDetailInfo getInsuranceDetailByID(Integer id);
	
	void updateInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	
	void insertInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	
	void deleteInsuranceDetail(Integer id);
	
	List<InsuranceDetailInfo> selectDetailsForInsurance(Integer id);
}
