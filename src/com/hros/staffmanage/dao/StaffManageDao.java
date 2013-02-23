package com.hros.staffmanage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.staffmanage.domain.StaffManage;

@Repository
public interface StaffManageDao {
	public List<StaffManage> staffFinfAll();//����Ա��������Ϣ
	public void addStaff(StaffManage staffManage);//����Ա��
	public void updateStaff(StaffManage staffManage);//����Ա��
	public List findStafffilter(StaffManage staffManage);
}
