package com.hros.insurance.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.InsuranceDetailInfo;
import com.hros.insurance.domain.InsuranceHistoryInfo;

@Repository
public interface InsuranceHistoryDao {

	InsuranceHistoryInfo getInsuranceHistoryByID(Integer historyID);
	
	InsuranceDetailInfo getInsuranceDetailByHistoryID(Integer historyID);
	
	void updateInsuranceHistory(InsuranceHistoryInfo insuranceHistoryInfo);
	
	void insertInsuranceHistory(InsuranceHistoryInfo insuranceHistoryInfo);
	
	void deleteInsuranceHistory(Integer id);
	
	List<InsuranceHistoryInfo> selectHistorysForStaffManage(Integer id);
	
	InsuranceHistoryInfo selectHistorysForStaffManageByDate(Integer id,Date destDate);
}
