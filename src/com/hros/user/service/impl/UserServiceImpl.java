package com.hros.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hros.bas.dao.MenuDao;
import com.hros.bas.domain.MenuInfo;
import com.hros.user.dao.RoleDao;
import com.hros.user.dao.RoleMenuDao;
import com.hros.user.dao.RoleUserDao;
import com.hros.user.dao.UserDao;
import com.hros.user.domain.RoleInfo;
import com.hros.user.domain.RoleMenuMap;
import com.hros.user.domain.RoleUserMap;
import com.hros.user.domain.UserInfo;
import com.hros.user.service.UserService;

@Repository
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Autowired
	private RoleUserDao roleUserDao;
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<UserInfo> selectAllUser() {
		// TODO Auto-generated method stub
		List<UserInfo> list=userDao.selectAllUsers();
		return list;
	}

	@Override
	public UserInfo selectFirstUser() {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("id", 1);
		map.put("user", "aaa");
		return userDao.selectUser(map);
	}

	@Override
	public List<RoleInfo> selectAllRoles() {
		// TODO Auto-generated method stub
		return roleDao.selectAllRoles();
	}

	@Override
	public void addRole(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleDao.insertRole(roleInfo);
	}

	@Override
	public void deleteRole(Integer roleID) {
		// TODO Auto-generated method stub
		roleMenuDao.deleteRoleMenuByRoleID(roleID);
		roleDao.deleteRole(roleID);
	}

	@Override
	public void updateRole(RoleInfo roleInfo) {
		// TODO Auto-generated method stub
		roleDao.updateRole(roleInfo);
	}

	@Override
	public void deleteRoleMenuByMenuID(Integer menuID) {
		roleMenuDao.deleteRoleMenuByMenuID(menuID);
	}

	@Override
	public void insertRoleMenuBatch(List<RoleMenuMap> roleMenuMaps) {
		// TODO Auto-generated method stub
		roleMenuDao.insertRoleMenuBatch(roleMenuMaps);
	}

	@Override
	public void deleteRoleMenuByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		roleMenuDao.deleteRoleMenuByRoleID(roleID);
	}

	@Override
	public List<RoleMenuMap> selectMenusForRole(Integer roleID) {
		// TODO Auto-generated method stub
		return roleMenuDao.selectMenusForRole(roleID);
	}

	@Override
	public Set<MenuInfo> selectMenusForRole2(Integer roleID) {
		// TODO Auto-generated method stub
		List<RoleMenuMap> roleMenuMaps = selectMenusForRole(roleID);
		//使用Set而不用List以过滤重复的父menu
		Set<MenuInfo> menuInfos = new HashSet<MenuInfo>();
		for (RoleMenuMap roleMenuMap:roleMenuMaps){
			MenuInfo menuInfo =  menuDao.selectMenu(roleMenuMap.getMenuID());
			menuInfos.add(menuInfo);
			//将父菜单添加进来
			if(menuInfo.getFMenuID() != 0){
				menuInfos.add(menuDao.selectMenu(menuInfo.getFMenuID())); 
			}
		}
		return menuInfos;
	}

	@Override
	public void addUser(UserInfo userInfo) {
		userDao.insertUser(userInfo);
		
	}

	@Override
	public void insertUserBatch(List<UserInfo> userInfos) {
		// TODO Auto-generated method stub
		userDao.insertUserBatch(userInfos);
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userDao.updateUser(userInfo);
	}

	@Override
	public void deleteUser(Integer userID) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userID);
	}

	@Override
	public List<RoleUserMap> selectRolesForUser(Integer userID) {
		// TODO Auto-generated method stub
		return roleUserDao.selectRolesForUser(userID);
	}
	@Override
	public List<RoleInfo> selectRolesForUser2(Integer userID) {
		// TODO Auto-generated method stub
		List<RoleUserMap> roleUserMaps = selectRolesForUser(userID);
		List<Integer> roleIDs = new ArrayList<Integer>();
		//如果没有,直接返回空list,否则后面的查询的sql会出语法错误.
		if(roleUserMaps == null || roleUserMaps.size() == 0){
			return new ArrayList<RoleInfo>();
		}
		for(RoleUserMap roleUserMap:roleUserMaps){
			roleIDs.add(roleUserMap.getRoleID());
		}
		return roleDao.selectRoleBatch(roleIDs);
	}
	@Override
	public List<RoleUserMap> selectUsersForRole(Integer roleID) {
		// TODO Auto-generated method stub
		return roleUserDao.selectUsersForRole(roleID);
	}

	@Override
	public void insertRoleUser(RoleUserMap roleUserMap) {
		// TODO Auto-generated method stub
		roleUserDao.insertRoleUser(roleUserMap);
	}

	@Override
	public void deleteRoleUser(Integer roleUserID) {
		// TODO Auto-generated method stub
		roleUserDao.deleteRoleUser(roleUserID);
	}

	@Override
	public void deleteRoleUserByRoleID(Integer roleID) {
		// TODO Auto-generated method stub
		roleUserDao.deleteRoleUserByRoleID(roleID);
	}

	@Override
	public void deleteRoleUserByUserID(Integer userID) {
		// TODO Auto-generated method stub
		roleUserDao.deleteRoleUserByUserID(userID);
	}

	@Override
	public void insertRoleUserBatch(List<RoleUserMap> roleUserMaps) {
		// TODO Auto-generated method stub
		roleUserDao.insertRoleUserBatch(roleUserMaps);
	}

	@Override
	public List<UserInfo> selectUsersForRole2(Integer roleID) {
		// TODO Auto-generated method stub
		List<RoleUserMap> roleUserMaps = selectUsersForRole(roleID);
		List<Integer> userIDs = new ArrayList<Integer>();
		//如果没有,直接返回空list,否则后面的查询的sql会出语法错误.
		if(roleUserMaps == null || roleUserMaps.size() == 0){
			return new ArrayList<UserInfo>();
		}
		for(RoleUserMap roleUserMap:roleUserMaps){
			userIDs.add(roleUserMap.getUserID());
		}
		return userDao.selectUserBatch(userIDs);
	}

	@Override
	public void addRolesForUser(Integer userID, List<RoleInfo> roleInfos) {
		if(roleInfos == null || roleInfos.size() == 0){
			return;
		}
		List<RoleUserMap> roleUserMaps = new ArrayList<RoleUserMap>();
		for(RoleInfo roleInfo:roleInfos){
			RoleUserMap roleUserMap = new RoleUserMap();
			roleUserMap.setRoleID(roleInfo.getRoleID());
			roleUserMap.setUserID(userID);
			roleUserMaps.add(roleUserMap);
		}
		roleUserDao.insertRoleUserBatch(roleUserMaps);
	}

	@Override
	public void deleteRolesForUser(Integer userID, List<RoleInfo> roleInfos) {
		if(roleInfos == null || roleInfos.size() == 0){
			return;
		}
		Map<String,Object> roleUserMap = new HashMap<String,Object>();
		roleUserMap.put("userID", userID.toString());
		roleUserMap.put("roleIDs", roleInfos);
		roleUserDao.deleteRolesForUser(roleUserMap);
	}

	@Override
	public void addUsersForRole(Integer roleID, List<UserInfo> userInfos) {
		if(userInfos == null || userInfos.size() == 0){
			return;
		}
		List<RoleUserMap> roleUserMaps = new ArrayList<RoleUserMap>();
		for(UserInfo userInfo:userInfos){
			RoleUserMap roleUserMap = new RoleUserMap();
			roleUserMap.setRoleID(roleID);
			roleUserMap.setUserID(userInfo.getUserID());
			roleUserMaps.add(roleUserMap);
		}
		roleUserDao.insertRoleUserBatch(roleUserMaps);
	}

	@Override
	public void deleteUsersForRole(Integer roleID, List<UserInfo> userInfos) {
		if(userInfos == null || userInfos.size() == 0){
			return;
		}
		Map<String,Object> roleUserMap = new HashMap<String,Object>();
		roleUserMap.put("roleID", roleID.toString());
		roleUserMap.put("userIDs", userInfos);
		roleUserDao.deleteUsersForRole(roleUserMap);
	}

	@Override
	public void addMenusForRole(Integer roleID, List<MenuInfo> menuInfos) {
		if(menuInfos == null || menuInfos.size() == 0){
			return;
		}
		List<RoleMenuMap> roleMenuMaps = new ArrayList<RoleMenuMap>();
		for(MenuInfo menuInfo:menuInfos){
			RoleMenuMap roleMenuMap = new RoleMenuMap();
			roleMenuMap.setRoleID(roleID);
			roleMenuMap.setMenuID(menuInfo.getMenuID());
			roleMenuMaps.add(roleMenuMap);
		}
		roleMenuDao.insertRoleMenuBatch(roleMenuMaps);
		
	}

	@Override
	public void deleteMenusForRole(Integer roleID, List<MenuInfo> menuInfos) {
		if(menuInfos == null || menuInfos.size() == 0){
			return;
		}
		
		Map<String,Object> roleUserMap = new HashMap<String,Object>();
		roleUserMap.put("roleID", roleID);
		roleUserMap.put("menuIDs", menuInfos);
		roleMenuDao.deleteMenusForRole(roleUserMap);
	}


}
