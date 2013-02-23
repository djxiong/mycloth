package com.hros.staffmanage.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.internal.matchers.SubstringMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.staffmanage.dao.StaffManageDao;
import com.hros.staffmanage.domain.StaffManage;
import com.hros.staffmanage.service.StaffManageService;
@Repository
@Transactional
public class StaffManageServiceImpl implements StaffManageService{
	@Autowired
	private StaffManageDao staffManageDao;
	
	//增加
	@Override
	public boolean addStaff(StaffManage staffManage) {
		boolean b = false;
		try{
		staffManageDao.addStaff(staffManage);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//保存更新
	@Override
	public StaffManage saveUpdate(StaffManage staffManage) {
		if(staffManage.getStaffID() == null || 
				staffManage.getStaffID() == 0){
			staffManageDao.addStaff(staffManage);
		}else{
			staffManageDao.updateStaff(staffManage);
		}
		return staffManage;
	}
	
	@Override
	public List findStafffilter(StaffManage staffManage) {
		return staffManageDao.findStafffilter(staffManage);
	}
}
