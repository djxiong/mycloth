package com.hros.insurance.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.InsuranceDetailInfo;
import com.hros.insurance.domain.InsuranceHistoryInfo;
import com.hros.insurance.domain.InsuranceInfo;

@Configurable(preConstruction = true)
@Repository
public interface InsuranceService {

	/**
	 * 添加保险
	 * @param insuranceDetailInfo
	 */
	void addInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	/**
	 * 更新保险信息
	 * @param insuranceDetailInfo
	 */
	void updateInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	/**
	 * 根据保险ID查找
	 * @param id
	 * @return
	 */
	InsuranceDetailInfo getInsuranceDetailByID(Integer id);
	
	/**
	 * 根据社保明细的ID查找社保缴纳情况
	 * @param historyID
	 * @return
	 */
	InsuranceHistoryInfo getInsuranceHistoryByID(Integer historyID);
	
	/**
	 * 添加社保
	 * @param insuranceInfo
	 */
	void addInsurance(InsuranceInfo insuranceInfo);
	/**
	 * 更新社保
	 * @param insuranceInfo
	 */
	void updateInsurance(InsuranceInfo insuranceInfo);
	/**
	 * 根据社保id查找
	 * @param id
	 * @return
	 */
	InsuranceInfo getInsuranceByID(Integer id);
	/**
	 * 根据社保名称查询
	 * @param name
	 * @return
	 */
	List<InsuranceInfo> findInsuranceByName(String name);
	
	/**
	 * 查询树节点下的保险
	 * @param treeNodeID
	 * @return
	 */
	List<InsuranceInfo> findInsuranceByTreeNodeID(Integer treeNodeID);
	
	/**
	 * 删除保险
	 * @param insuranceID
	 */
	void deleteInsurance(Integer insuranceID);
	
	/**
	 * 删除保险明细
	 * @param insuranceDetailID
	 */
	void deleteInsuranceDetail(Integer insuranceDetailID);
	
	/**
	 * 根据保险查询其明细
	 * @param insuranceID
	 * @return
	 */
	List<InsuranceDetailInfo> selectDetailsForInsurance(Integer insuranceID);
	
	/**
	 * 根据员工ID查找员工社保缴纳情况
	 * @param id
	 * @return
	 */
	List<InsuranceHistoryInfo> selectHistorysForStaffManage(Integer staffManageID);
	
	/**
	 * 为员工缴纳社保
	 * @param insuranceID 社保ID
	 * @param staffManageID 员工ID
	 * @param destDate 要缴纳社保的月份
	 * @return 已缴纳的社保明细
	 */
	List<InsuranceHistoryInfo> payInsurance(Integer insuranceID,Integer staffManageID,Date destDate);
}
