package com.hros.insurance.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hros.insurance.dao.InsuranceDao;
import com.hros.insurance.dao.InsuranceDetailDao;
import com.hros.insurance.dao.InsuranceHistoryDao;
import com.hros.insurance.domain.InsuranceDetailInfo;
import com.hros.insurance.domain.InsuranceHistoryInfo;
import com.hros.insurance.domain.InsuranceInfo;
import com.hros.insurance.service.InsuranceService;

//@Repository

@Component
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceDetailDao  insuranceDetailDao;
	
	@Autowired
	private InsuranceDao  insuranceDao;
	
	@Autowired
	private InsuranceHistoryDao  insuranceHistoryDao;
	
	@Override
	public void addInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo) {
		// TODO Auto-generated method stub
		insuranceDetailDao.insertInsuranceDetail(insuranceDetailInfo);
	}

	@Override
	public void addInsurance(InsuranceInfo insuranceInfo) {
		// TODO Auto-generated method stub
		insuranceDao.insertInsurance(insuranceInfo);
	}

	@Override
	public InsuranceDetailInfo getInsuranceDetailByID(Integer id) {
		// TODO Auto-generated method stub
		return insuranceDetailDao.getInsuranceDetailByID(id);
	}

	@Override
	public void updateInsurance(InsuranceInfo insuranceInfo) {
		// TODO Auto-generated method stub
		insuranceDao.updateInsurance(insuranceInfo);
	}

	@Override
	public InsuranceInfo getInsuranceByID(Integer id) {
		// TODO Auto-generated method stub
		return insuranceDao.getInsuranceByID(id);
	}

	@Override
	public List<InsuranceInfo> findInsuranceByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo) {
		// TODO Auto-generated method stub
		insuranceDetailDao.updateInsuranceDetail(insuranceDetailInfo);
	}

	@Override
	public List<InsuranceInfo> findInsuranceByTreeNodeID(Integer treeNodeID) {
		// TODO Auto-generated method stub
		return insuranceDao.findInsuranceByTreeNodeID(treeNodeID);
	}

	@Override
	public void deleteInsurance(Integer id) {
		// TODO Auto-generated method stub
		List<InsuranceDetailInfo> details = insuranceDetailDao.selectDetailsForInsurance(id);
		for(InsuranceDetailInfo detail : details){
			insuranceDetailDao.deleteInsuranceDetail(detail.getInsuranceDetailID());
		}
		insuranceDao.deleteInsurance(id);
	}

	@Override
	public List<InsuranceDetailInfo> selectDetailsForInsurance(
			Integer insuranceID) {
		// TODO Auto-generated method stub
		return insuranceDetailDao.selectDetailsForInsurance(insuranceID);
	}

	@Override
	public void deleteInsuranceDetail(Integer insuranceDetailID) {
		// TODO Auto-generated method stub
		insuranceDetailDao.deleteInsuranceDetail(insuranceDetailID);
	}

	@Override
	public InsuranceHistoryInfo getInsuranceHistoryByID(Integer historyID) {
		// TODO Auto-generated method stub
		InsuranceHistoryInfo insuranceHistory = insuranceHistoryDao.getInsuranceHistoryByID(historyID);
		InsuranceDetailInfo insuranceDetailInfo = insuranceHistoryDao.getInsuranceDetailByHistoryID(historyID);
		insuranceHistory.setDetail(insuranceDetailInfo);
		return insuranceHistory;
	}

	@Override
	public List<InsuranceHistoryInfo> selectHistorysForStaffManage(Integer staffManageID) {
		// TODO Auto-generated method stub
		List<InsuranceHistoryInfo> insuranceHistoryInfos = insuranceHistoryDao.selectHistorysForStaffManage(staffManageID);
		for(InsuranceHistoryInfo insuranceHistoryInfo:insuranceHistoryInfos){
			//Ìî³äÉç±£Ã÷Ï¸
			InsuranceDetailInfo insuranceDetailInfo = insuranceHistoryDao.getInsuranceDetailByHistoryID(insuranceHistoryInfo.getInsuranceHistoryID());
			insuranceHistoryInfo.setDetail(insuranceDetailInfo);
		}
		return insuranceHistoryInfos;
	}

	@Override
	public List<InsuranceHistoryInfo> payInsurance(Integer insuranceID,Integer staffManageID,Date destDate) {
		// TODO Auto-generated method stub
		List<InsuranceDetailInfo> insuranceDetailInfos = selectDetailsForInsurance(insuranceID);
		List<InsuranceHistoryInfo> insuranceHistoryInfos = new ArrayList<InsuranceHistoryInfo>();
		for(InsuranceDetailInfo insuranceDetailInfo:insuranceDetailInfos){
			InsuranceHistoryInfo insuranceHistoryInfo = new InsuranceHistoryInfo();
			insuranceHistoryInfo.setDetail(insuranceDetailInfo);
			insuranceHistoryInfo.setDestDate(destDate);
			insuranceHistoryInfo.setStaffManageID(staffManageID);
			insuranceHistoryInfo.setPayDate(new Date());
			insuranceHistoryDao.insertInsuranceHistory(insuranceHistoryInfo);
			insuranceHistoryInfos.add(insuranceHistoryInfo);
		}
		return insuranceHistoryInfos;
	}

}
