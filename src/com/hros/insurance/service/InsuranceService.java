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
	 * ��ӱ���
	 * @param insuranceDetailInfo
	 */
	void addInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	/**
	 * ���±�����Ϣ
	 * @param insuranceDetailInfo
	 */
	void updateInsuranceDetail(InsuranceDetailInfo insuranceDetailInfo);
	/**
	 * ���ݱ���ID����
	 * @param id
	 * @return
	 */
	InsuranceDetailInfo getInsuranceDetailByID(Integer id);
	
	/**
	 * �����籣��ϸ��ID�����籣�������
	 * @param historyID
	 * @return
	 */
	InsuranceHistoryInfo getInsuranceHistoryByID(Integer historyID);
	
	/**
	 * ����籣
	 * @param insuranceInfo
	 */
	void addInsurance(InsuranceInfo insuranceInfo);
	/**
	 * �����籣
	 * @param insuranceInfo
	 */
	void updateInsurance(InsuranceInfo insuranceInfo);
	/**
	 * �����籣id����
	 * @param id
	 * @return
	 */
	InsuranceInfo getInsuranceByID(Integer id);
	/**
	 * �����籣���Ʋ�ѯ
	 * @param name
	 * @return
	 */
	List<InsuranceInfo> findInsuranceByName(String name);
	
	/**
	 * ��ѯ���ڵ��µı���
	 * @param treeNodeID
	 * @return
	 */
	List<InsuranceInfo> findInsuranceByTreeNodeID(Integer treeNodeID);
	
	/**
	 * ɾ������
	 * @param insuranceID
	 */
	void deleteInsurance(Integer insuranceID);
	
	/**
	 * ɾ��������ϸ
	 * @param insuranceDetailID
	 */
	void deleteInsuranceDetail(Integer insuranceDetailID);
	
	/**
	 * ���ݱ��ղ�ѯ����ϸ
	 * @param insuranceID
	 * @return
	 */
	List<InsuranceDetailInfo> selectDetailsForInsurance(Integer insuranceID);
	
	/**
	 * ����Ա��ID����Ա���籣�������
	 * @param id
	 * @return
	 */
	List<InsuranceHistoryInfo> selectHistorysForStaffManage(Integer staffManageID);
	
	/**
	 * ΪԱ�������籣
	 * @param insuranceID �籣ID
	 * @param staffManageID Ա��ID
	 * @param destDate Ҫ�����籣���·�
	 * @return �ѽ��ɵ��籣��ϸ
	 */
	List<InsuranceHistoryInfo> payInsurance(Integer insuranceID,Integer staffManageID,Date destDate);
}
