package com.hros.user.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.user.dao.RoleDao;
import com.hros.user.dao.RoleMenuDao;
import com.hros.user.dao.RoleUserDao;
import com.hros.user.dao.UserDao;
import com.hros.user.domain.RoleInfo;
import com.hros.user.domain.RoleMenuMap;
import com.hros.user.domain.UserInfo;
import com.hros.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class UserTest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private RoleUserDao roleUserDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	//@Test
	public void selectAllUser(){
		List<UserInfo> list = userService.selectAllUser();
		
		for(int i=0;i<list.size();i++){
			UserInfo user=(UserInfo)list.get(i);
			System.out.println(user.getUserName());
		}
		
		UserInfo userInfo = userService.selectFirstUser();
		System.out.println("====="+userInfo.getUserName());
	}
	
	@Test
	public void insertRole(){
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName("test22");
		roleDao.insertRole(roleInfo);
		
	}
	@Test
	public void selectRole( ){
		
		roleDao.selectRole(0);
	}
	@Test
	public void updateRole( ){
		RoleInfo roleInfo = roleDao.selectRole(2);
		roleInfo.setRoleName("chaneged");
		roleDao.updateRole(roleInfo);
	}
	@Test
	public void selectAllRoles( ){
		roleDao.selectAllRoles();
	}
		
	
	//@Test
	public void deleteRole( ){
		
	}
	
	/**
	 * 查询该菜单都被哪些角色所拥有
	 * @param menuID
	 * @return
	 */
	@Test
	public void selectRolesForMenu(){
		log.info(roleMenuDao.selectMenusForRole(111));
	}
	
	/**
	 * 查询该role拥有的所有菜单
	 * @param roleID
	 * @return
	 */
	@Test
	public void selectMenusForRole(){
		log.info(roleMenuDao.selectMenusForRole(2222));
	}
	
	/**
	 * 插入一条记录
	 * @param roleMenuMap
	 */
	@Test
	public void insertRoleMenu(){
		RoleMenuMap roleMenuMap = new RoleMenuMap();
		roleMenuMap.setMenuID(111);
		roleMenuMap.setRoleID(2222);
		roleMenuDao.insertRoleMenu(roleMenuMap);
	}
	
	/**
	 * 根据关联表的主键ID来删除关联关系
	 * @param roleMenuID
	 */
	@Test
	public void deleteRoleMenu(){
		
	}
	
	/**
	 * 根据roleID删除与该角色相关的关联关系
	 * @param roleID
	 */
	@Test
	public void deleteRoleMenuByRoleID(){
		
		roleMenuDao.deleteRoleMenuByRoleID(2222);
	}
	
	/**
	 * 根据menuID删除与之相关的关联关系
	 * @param menuID
	 */
	@Test
	public void deleteRoleMenuByMenuID(){
		roleMenuDao.deleteRoleMenuByMenuID(8);
	}
	
	/**
	 * 批量插入关联关系
	 * @param roleMenuMaps
	 */
	@Test
	public void insertRoleMenuBatch(){
		
	}
	
	@Test
	public void insertUser(){
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("asdfsdf");
		userService.addUser(userInfo);
		
	}
	
	@Test
	public void deleteUser(){
		
		userService.deleteUser(11);
		
	}
	
	@Test
	public void selectUserBatch(){
		
		userService.selectUsersForRole2(14);
		
	}
	
	@Test
	public void selectUserBatch2(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(26);
		ids.add(27);
		ids.add(28);
		List<UserInfo> users = userDao.selectUserBatch(ids);
		log.debug(users);
	}
	
	@Test
	public void selectRoleBatch2(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(6);
		ids.add(7);
		ids.add(8);
		List<RoleInfo> role = roleDao.selectRoleBatch(ids);
		log.debug(role);
	}
}
