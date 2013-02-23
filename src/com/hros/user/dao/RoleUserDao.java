package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.user.domain.RoleUserMap;

@Repository
public interface RoleUserDao {
	
	/**
	 * 查询该菜单都被哪些角色所拥有
	 * @param userID
	 * @return
	 */
	List<RoleUserMap> selectRolesForUser(Integer userID);
	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	List<RoleUserMap> selectUsersForRole(Integer roleID);
	
	/**
	 * 插入一条记录
	 * @param roleUserMap
	 */
	void insertRoleUser(RoleUserMap roleUserMap);
	
	/**
	 * 删除一条记录
	 * @param roleUserMap as {{roleID=1},{userID=2}}
	 */
	void deleteRoleAndUser(Map<String,Integer> roleUserMap);
	
	/**
	 * 批量删除记录
	 * @param roleUserMap as {{userID=1},{roleIDs=(2,3,4)}}
	 */
	void deleteRolesForUser(Map<String,Object> userRolesMap); 
	
	/**
	 * 批量删除记录
	 * @param roleUserMap as {{roleID=1},{userIDs=(2,3,4)}}
	 */
	void deleteUsersForRole(Map<String,Object> roleUsersMap); 
	/**
	 * 根据关联表的主键ID来删除关联关系
	 * @param roleUserID
	 */
	void deleteRoleUser(Integer roleUserID);
	
	/**
	 * 根据roleID删除与该用户相关的关联关系
	 * @param roleID
	 */
	void deleteRoleUserByRoleID(Integer roleID);
	
	/**
	 * 根据userID删除与之相关的关联关系
	 * @param userID
	 */
	void deleteRoleUserByUserID(Integer userID);
	
	/**
	 * 批量插入关联关系
	 * @param roleUserMaps
	 */
	void insertRoleUserBatch(List<RoleUserMap> roleUserMaps);
	
	
}
