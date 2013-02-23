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
     * 查询员工
     * **/
	List<StaffState> selectStaff(Map map);//查询员工
	 /**
     * 查询员工
     * **/
	List<Staff> selectStaffById(int staffID);
	/**
	 * 查询所有员工
	 */
	Map<Integer,Staff> selectStaffAll();
	 /**
     * 查询客户
     * **/
	List<Customer> selectCustomer(Map map);//查询客户
	 /**
     * 查询客户
     * **/
	List<Customer> selectCustomerById(int custID);//查询客户
	 /**
     * 查询客户
     * **/
	Map<Integer,Customer> selectCustomerAll();//查询客户
	 /**
     * 查询档案
     * **/
	List<File> selectFile(Map map);//查询档案
	/**
     * 查询档案
     * **/
	List<File> selectFileById(int fileID);//查询档案
	/**
     * 查询档案
     * **/
	Map<Integer,File> selectFileAll();//查询档案
	/**
     * 添加入职信息
     * **/
	void addEntry(StaffState staffState);//添加入职
	/**
     * 修改员工状态
     * **/
	void updateState(Staff staff);//更新状态
	/**
     * 查询入离职信息
     * **/
	List<StaffState> selectStaffStateById(int staffID);//查询入离职
	/**
     * 修改入职信息
     * **/
	void updateStaffState(StaffState staffState);

	/**
	 * 修改入职为离职
	 */
	void updateStaffQuit(StaffState staffState);//修改入职为离职
	/**
	 * 查询入离职
	 * @param map
	 * @return
	 */
	List<StaffState> selectStaffState(Map map);
	/**
	 * 查询社保
	 * @return
	 */
    List<InsuranceInfo> selectInsurance();
	/**
	 * 查询服务费
	 * @return
	 */
	List<ServiceFee> selectServiceFee();
	/**
	 * 查询社保
	 * @return
	 */
	Map<Integer,InsuranceInfo> selectInsuranceAll();
	/**
	 * 查询服务费
	 * @return
	 */
	Map<Integer,ServiceFee> selectServiceFeeAll();
	/**
	 * 查询用户
	 * @return
	 */
	List<UserInfo> selectUser();
	/**
	 * 查询用户
	 * @return
	 */
	Map<Integer,UserInfo> selectUserAll();
	/**
	 * 查询招聘费用表
	 * @return
	 */
	List<RecCost> selectRecCost();
}
