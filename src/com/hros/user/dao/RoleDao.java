package com.hros.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.user.domain.RoleInfo;

@Repository
public interface RoleDao {
	
	List<RoleInfo> selectAllRoles();
	
	RoleInfo selectRole(Integer roleID);
	
	void updateRole(RoleInfo roleInfo);
	
	void insertRole(RoleInfo roleInfo);
	
	void deleteRole(Integer roleID);
	
	List<RoleInfo> selectRoleBatch(List<Integer> roleIDs);
}
