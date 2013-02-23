package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import com.hros.user.domain.RoleMenuMap;

@Repository
public interface RoleMenuDao {
	
	/**
	 * 查询该菜单都被哪些角色所拥有
	 * @param menuID
	 * @return
	 */
	List<RoleMenuMap> selectRolesForMenu(Integer menuID);
	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	List<RoleMenuMap> selectMenusForRole(Integer roleID);
	
	/**
	 * 插入一条记录
	 * @param roleMenuMap
	 */
	void insertRoleMenu(RoleMenuMap roleMenuMap);
	
	/**
	 * 根据关联表的主键ID来删除关联关系
	 * @param roleMenuID
	 */
	void deleteRoleMenu(Integer roleMenuID);
	
	/**
	 * 根据roleID删除与该角色相关的关联关系
	 * @param roleID
	 */
	void deleteRoleMenuByRoleID(Integer roleID);
	
	/**
	 * 根据menuID删除与之相关的关联关系
	 * @param menuID
	 */
	void deleteRoleMenuByMenuID(Integer menuID);
	
	/**
	 * 批量插入关联关系
	 * @param roleMenuMaps
	 */
	void insertRoleMenuBatch(List<RoleMenuMap> roleMenuMaps);
	
	/**
	 * 根据roleid和menuid来删除
	 * @param map
	 */
	void deleteRoleAndMenu(Map<String,Integer> map);
	
	void deleteMenusForRole(Map<String,Object> map);
}
