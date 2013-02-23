package com.hros.staffmanage.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.staffmanage.domain.StaffManage;

@Repository
public interface StaffManageService {
	public boolean addStaff(StaffManage staffManage);//增加
	
	public StaffManage saveUpdate(StaffManage staffManage);//保存更新
	
	public List findStafffilter(StaffManage staffManage);
}
