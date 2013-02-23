package com.hros.user.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.MenuInfo;
import com.hros.user.domain.RoleInfo;
import com.hros.user.domain.RoleMenuMap;
import com.hros.user.domain.RoleUserMap;
import com.hros.user.domain.UserInfo;

@Repository
public interface UserService {
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserInfo> selectAllUser();
	
	/**
	 * 查询第一个用户
	 * @return
	 */
	public UserInfo selectFirstUser();
	
	/**
	 * 获取所有的角色
	 * @return
	 */
	List<RoleInfo> selectAllRoles();
	
	/**
	 * 添加角色
	 * @param roleInfo
	 */
	void addRole(RoleInfo roleInfo);
	
	/**
	 * 删除角色
	 * @param roleID
	 */
	void deleteRole(Integer roleID);
	
	/**
	 * 更新角色
	 * @param roleInfo
	 */
	void updateRole(RoleInfo roleInfo);
	
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
	 * 根据roleID删除与该角色相关的关联关系
	 * @param roleID
	 */
	void deleteRoleMenuByRoleID(Integer roleID);
	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	List<RoleMenuMap> selectMenusForRole(Integer roleID);
	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	Set<MenuInfo> selectMenusForRole2(Integer roleID);
	
	/**
	 * 为角色添加菜单
	 * @param roleID
	 * @param menuInfos 为该角色添加的菜单
	 * @return
	 */
	void addMenusForRole(Integer roleID,List<MenuInfo> menuInfos);
	
	/**
	 * 为角色删除菜单
	 * @param roleID
	 * @param menuInfos 为该角色删除的菜单
	 * @return
	 */
	void deleteMenusForRole(Integer roleID,List<MenuInfo> menuInfos);
	
	/**
	 * 添加一个用户
	 * @param userInfo
	 */
	void addUser(UserInfo userInfo);
	
	/**
	 * 批量添加用户
	 * @param userInfos
	 */
	void insertUserBatch(List<UserInfo> userInfos);
	
	/**
	 * 更新用户
	 * @param userInfo
	 */
	void updateUser(UserInfo userInfo);
	
	/**
	 * 删除用户
	 * @param userID
	 */
	void deleteUser(Integer userID);
	
	/**
	 * 查询该菜单都被哪些角色所拥有
	 * @param userID
	 * @return
	 */
	List<RoleUserMap> selectRolesForUser(Integer userID);
	
	/**
	 * 查询该菜单都被哪些角色所拥有
	 * @param userID
	 * @return
	 */
	List<RoleInfo> selectRolesForUser2(Integer userID);
	
	/**
	 * 为用户添加角色
	 * @param userID
	 * @param roleInfos 为该用户添加的角色
	 * @return
	 */
	void addRolesForUser(Integer userID,List<RoleInfo> roleInfos);	

	/**
	 * 为用户删除角色
	 * @param userID
	 * @param roleInfos 为该用户删除的角色
	 * @return
	 */
	void deleteRolesForUser(Integer userID,List<RoleInfo> roleInfos);	

	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	List<RoleUserMap> selectUsersForRole(Integer roleID);
	
	/**
	 * 为角色添加用户
	 * @param roleID
	 * @param userInfos 为该角色添加的用户
	 * @return
	 */
	void addUsersForRole(Integer roleID,List<UserInfo> userInfos);	

	/**
	 * 为角色删除用户
	 * @param roleID
	 * @param userInfos 为该角色删除的用户
	 * @return
	 */
	void deleteUsersForRole(Integer roleID,List<UserInfo> userInfos);	

	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	List<UserInfo> selectUsersForRole2(Integer roleID);
	
	/**
	 * 插入一条记录
	 * @param roleUserMap
	 */
	void insertRoleUser(RoleUserMap roleUserMap);
	
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
