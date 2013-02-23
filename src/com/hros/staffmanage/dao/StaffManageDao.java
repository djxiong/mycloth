package com.hros.staffmanage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.staffmanage.domain.StaffManage;

@Repository
public interface StaffManageDao {
	public List<StaffManage> staffFinfAll();//查找员工所有信息
	public void addStaff(StaffManage staffManage);//增加员工
	public void updateStaff(StaffManage staffManage);//更新员工
	public List findStafffilter(StaffManage staffManage);
}
