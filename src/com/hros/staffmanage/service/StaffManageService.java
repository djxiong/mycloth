package com.hros.staffmanage.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.staffmanage.domain.StaffManage;

@Repository
public interface StaffManageService {
	public boolean addStaff(StaffManage staffManage);//����
	
	public StaffManage saveUpdate(StaffManage staffManage);//�������
	
	public List findStafffilter(StaffManage staffManage);
}
