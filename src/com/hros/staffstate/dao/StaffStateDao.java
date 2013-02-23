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

	List<StaffState> selectStaff(Map map);//查询员工
	
	List<Staff> selectStaffById(int staffID);//查询员工
	
	List<Staff> selectStaffAll();//查询所有员工
	
	List<Customer> selectCustomer(Map map);//查询客户
	
	List<Customer> selectCustomerById(int custID);//查询客户
	
	List<Customer> selectCustomerAll();//查询客户
	
	List<File> selectFile(Map map);//查询档案
	
	List<File> selectFileById(int fileID);//查询档案
	
	List<File> selectFileAll();//查询档案
	
	void addEntry(StaffState staffState);//添加入职信息
	
	void updateState(Staff staff);//更新状态
	
	List<StaffState> selectStaffStateById(int staffID);//查询入离职信息
	
	void updateStaffState(StaffState staffState);//修改入离职信息
	
	void updateStaffQuit(StaffState staffState);//修改入职为离职
	
	List<StaffState> selectStaffState(Map map);//查询入离职
	
	List<InsuranceInfo> selectInsurance();//查询社保
	
	List<ServiceFee> selectServiceFee();//查询服务费
	
	List<UserInfo> selectUser();//查询用户
	
	List<RecCost> selectRecCost();//查询招聘费用表
}
