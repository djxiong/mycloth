package com.hros.staffstate.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hros.customer.domain.Customer;
import com.hros.file.domain.File;
import com.hros.insurance.domain.InsuranceInfo;
import com.hros.reccost.domain.RecCost;
import com.hros.servicefee.domain.ServiceFee;
import com.hros.staffstate.dao.StaffStateDao;
import com.hros.staffstate.domain.Staff;
import com.hros.staffstate.domain.StaffState;
import com.hros.staffstate.service.StaffStateService;
import com.hros.user.domain.UserInfo;

@Repository
@Transactional
public class StaffStateServiceImpl implements StaffStateService {
	@Autowired
	StaffStateDao staffStateDao;

	@Override
	public List<StaffState> selectStaff(Map map) {
		// TODO Auto-generated method stub
		List<StaffState> list = staffStateDao.selectStaff(map);
		return list;

	}

	@Override
	public List<Staff> selectStaffById(int staffID) {
		// TODO Auto-generated method stub
		return staffStateDao.selectStaffById(staffID);
	}

	@Override
	public Map<Integer, Staff> selectStaffAll() {
		List<Staff> list = staffStateDao.selectStaffAll();
		Map<Integer, Staff> map = new LinkedHashMap<Integer, Staff>();
		for (Staff staff : list) {
			map.put(staff.staffID, staff);
		}
		return map;
	}

	@Override
	public List<Customer> selectCustomer(Map map) {
		// TODO Auto-generated method stub
		return staffStateDao.selectCustomer(map);
	}

	@Override
	public List<File> selectFile(Map map) {
		// TODO Auto-generated method stub
		return staffStateDao.selectFile(map);
	}

	@Override
	public List<Customer> selectCustomerById(int custID) {
		// TODO Auto-generated method stub
		return staffStateDao.selectCustomerById(custID);
	}

	@Override
	public Map<Integer, Customer> selectCustomerAll() {
		// TODO Auto-generated method stub
		List<Customer> list = staffStateDao.selectCustomerAll();
		Map<Integer, Customer> map = new LinkedHashMap<Integer, Customer>();
		for (Customer customer : list) {
			map.put(customer.getCustID(), customer);
		}
		return map;
	}

	@Override
	public void addEntry(StaffState staffState) {
		// TODO Auto-generated method stub
		staffStateDao.addEntry(staffState);
	}

	@Override
	public void updateState(Staff staff) {
		// TODO Auto-generated method stub
		staffStateDao.updateState(staff);
	}

	@Override
	public List<StaffState> selectStaffStateById(int staffID) {
		// TODO Auto-generated method stub
		return staffStateDao.selectStaffStateById(staffID);
	}

	@Override
	public void updateStaffState(StaffState staffState) {
		// TODO Auto-generated method stub
		staffStateDao.updateStaffState(staffState);
	}

	@Override
	public List<File> selectFileById(int fileID) {
		// TODO Auto-generated method stub
		return staffStateDao.selectFileById(fileID);
	}

	@Override
	public void updateStaffQuit(StaffState staffState) {
		// TODO Auto-generated method stub
		staffStateDao.updateStaffQuit(staffState);
	}

	@Override
	public List<StaffState> selectStaffState(Map map) {
		// TODO Auto-generated method stub
		return staffStateDao.selectStaffState(map);
	}

	@Override
	public Map<Integer, File> selectFileAll() {
		// TODO Auto-generated method stub
		List<File> list = staffStateDao.selectFileAll();
		Map<Integer, File> map = new LinkedHashMap<Integer, File>();
		for (File file : list) {
			map.put(file.getFileID(), file);
		}
		return map;
	}

	@Override
	public List<InsuranceInfo> selectInsurance() {
		// TODO Auto-generated method stub
		return staffStateDao.selectInsurance();
	}

	@Override
	public List<ServiceFee> selectServiceFee() {
		// TODO Auto-generated method stub
		return staffStateDao.selectServiceFee();
	}

	@Override
	public Map<Integer, InsuranceInfo> selectInsuranceAll() {
		// TODO Auto-generated method stub
		List<InsuranceInfo> list = staffStateDao.selectInsurance();
		Map<Integer, InsuranceInfo> map = new LinkedHashMap<Integer, InsuranceInfo>();
		for (InsuranceInfo insuranceInfo : list) {
			map.put(insuranceInfo.getInsuranceID(), insuranceInfo);
		}
		return map;
	}

	@Override
	public Map<Integer, ServiceFee> selectServiceFeeAll() {
		// TODO Auto-generated method stub
		List<ServiceFee> list = staffStateDao.selectServiceFee();
		Map<Integer, ServiceFee> map = new LinkedHashMap<Integer, ServiceFee>();
		for (ServiceFee serviceFee : list) {
			map.put(serviceFee.getServiceFeeID(), serviceFee);
		}
		return map;
	}

	@Override
	public List<UserInfo> selectUser() {
		// TODO Auto-generated method stub
		return staffStateDao.selectUser();
	}

	@Override
	public Map<Integer, UserInfo> selectUserAll() {
		// TODO Auto-generated method stub
		List<UserInfo> list=staffStateDao.selectUser();
		Map<Integer, UserInfo> map=new LinkedHashMap<Integer, UserInfo>();
		for(UserInfo user:list){
			map.put(user.getUserID(), user);
		}
		return map;
	}

	@Override
	public List<RecCost> selectRecCost() {
		// TODO Auto-generated method stub
		return staffStateDao.selectRecCost();
	}
}
