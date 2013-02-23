package com.hros.staffstate.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.customer.domain.Customer;
import com.hros.file.domain.File;
import com.hros.insurance.domain.InsuranceInfo;
import com.hros.reccost.domain.RecCost;
import com.hros.servicefee.domain.ServiceFee;
import com.hros.staffstate.domain.Staff;
import com.hros.staffstate.domain.StaffState;
import com.hros.user.domain.UserInfo;
@Repository
public interface StaffStateDao {

	List<StaffState> selectStaff(Map map);//��ѯԱ��
	
	List<Staff> selectStaffById(int staffID);//��ѯԱ��
	
	List<Staff> selectStaffAll();//��ѯ����Ա��
	
	List<Customer> selectCustomer(Map map);//��ѯ�ͻ�
	
	List<Customer> selectCustomerById(int custID);//��ѯ�ͻ�
	
	List<Customer> selectCustomerAll();//��ѯ�ͻ�
	
	List<File> selectFile(Map map);//��ѯ����
	
	List<File> selectFileById(int fileID);//��ѯ����
	
	List<File> selectFileAll();//��ѯ����
	
	void addEntry(StaffState staffState);//�����ְ��Ϣ
	
	void updateState(Staff staff);//����״̬
	
	List<StaffState> selectStaffStateById(int staffID);//��ѯ����ְ��Ϣ
	
	void updateStaffState(StaffState staffState);//�޸�����ְ��Ϣ
	
	void updateStaffQuit(StaffState staffState);//�޸���ְΪ��ְ
	
	List<StaffState> selectStaffState(Map map);//��ѯ����ְ
	
	List<InsuranceInfo> selectInsurance();//��ѯ�籣
	
	List<ServiceFee> selectServiceFee();//��ѯ�����
	
	List<UserInfo> selectUser();//��ѯ�û�
	
	List<RecCost> selectRecCost();//��ѯ��Ƹ���ñ�
}
