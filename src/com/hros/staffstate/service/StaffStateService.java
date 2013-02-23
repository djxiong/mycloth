package com.hros.staffstate.service;

import java.util.List;
import java.util.Map;

import com.hros.customer.domain.Customer;
import com.hros.file.domain.File;
import com.hros.insurance.domain.InsuranceInfo;
import com.hros.reccost.domain.RecCost;
import com.hros.servicefee.domain.ServiceFee;
import com.hros.staffstate.domain.Staff;
import com.hros.staffstate.domain.StaffState;
import com.hros.user.domain.UserInfo;

public interface StaffStateService {
   /**
     * ��ѯԱ��
     * **/
	List<StaffState> selectStaff(Map map);//��ѯԱ��
	 /**
     * ��ѯԱ��
     * **/
	List<Staff> selectStaffById(int staffID);
	/**
	 * ��ѯ����Ա��
	 */
	Map<Integer,Staff> selectStaffAll();
	 /**
     * ��ѯ�ͻ�
     * **/
	List<Customer> selectCustomer(Map map);//��ѯ�ͻ�
	 /**
     * ��ѯ�ͻ�
     * **/
	List<Customer> selectCustomerById(int custID);//��ѯ�ͻ�
	 /**
     * ��ѯ�ͻ�
     * **/
	Map<Integer,Customer> selectCustomerAll();//��ѯ�ͻ�
	 /**
     * ��ѯ����
     * **/
	List<File> selectFile(Map map);//��ѯ����
	/**
     * ��ѯ����
     * **/
	List<File> selectFileById(int fileID);//��ѯ����
	/**
     * ��ѯ����
     * **/
	Map<Integer,File> selectFileAll();//��ѯ����
	/**
     * �����ְ��Ϣ
     * **/
	void addEntry(StaffState staffState);//�����ְ
	/**
     * �޸�Ա��״̬
     * **/
	void updateState(Staff staff);//����״̬
	/**
     * ��ѯ����ְ��Ϣ
     * **/
	List<StaffState> selectStaffStateById(int staffID);//��ѯ����ְ
	/**
     * �޸���ְ��Ϣ
     * **/
	void updateStaffState(StaffState staffState);

	/**
	 * �޸���ְΪ��ְ
	 */
	void updateStaffQuit(StaffState staffState);//�޸���ְΪ��ְ
	/**
	 * ��ѯ����ְ
	 * @param map
	 * @return
	 */
	List<StaffState> selectStaffState(Map map);
	/**
	 * ��ѯ�籣
	 * @return
	 */
    List<InsuranceInfo> selectInsurance();
	/**
	 * ��ѯ�����
	 * @return
	 */
	List<ServiceFee> selectServiceFee();
	/**
	 * ��ѯ�籣
	 * @return
	 */
	Map<Integer,InsuranceInfo> selectInsuranceAll();
	/**
	 * ��ѯ�����
	 * @return
	 */
	Map<Integer,ServiceFee> selectServiceFeeAll();
	/**
	 * ��ѯ�û�
	 * @return
	 */
	List<UserInfo> selectUser();
	/**
	 * ��ѯ�û�
	 * @return
	 */
	Map<Integer,UserInfo> selectUserAll();
	/**
	 * ��ѯ��Ƹ���ñ�
	 * @return
	 */
	List<RecCost> selectRecCost();
}
