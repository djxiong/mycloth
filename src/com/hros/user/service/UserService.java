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
	 * ��ѯ�����û�
	 * @return
	 */
	public List<UserInfo> selectAllUser();
	
	/**
	 * ��ѯ��һ���û�
	 * @return
	 */
	public UserInfo selectFirstUser();
	
	/**
	 * ��ȡ���еĽ�ɫ
	 * @return
	 */
	List<RoleInfo> selectAllRoles();
	
	/**
	 * ��ӽ�ɫ
	 * @param roleInfo
	 */
	void addRole(RoleInfo roleInfo);
	
	/**
	 * ɾ����ɫ
	 * @param roleID
	 */
	void deleteRole(Integer roleID);
	
	/**
	 * ���½�ɫ
	 * @param roleInfo
	 */
	void updateRole(RoleInfo roleInfo);
	
	/**
	 * ����menuIDɾ����֮��صĹ�����ϵ
	 * @param menuID
	 */
	void deleteRoleMenuByMenuID(Integer menuID);
	
	/**
	 * �������������ϵ
	 * @param roleMenuMaps
	 */
	void insertRoleMenuBatch(List<RoleMenuMap> roleMenuMaps);
	
	/**
	 * ����roleIDɾ����ý�ɫ��صĹ�����ϵ
	 * @param roleID
	 */
	void deleteRoleMenuByRoleID(Integer roleID);
	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	List<RoleMenuMap> selectMenusForRole(Integer roleID);
	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	Set<MenuInfo> selectMenusForRole2(Integer roleID);
	
	/**
	 * Ϊ��ɫ��Ӳ˵�
	 * @param roleID
	 * @param menuInfos Ϊ�ý�ɫ��ӵĲ˵�
	 * @return
	 */
	void addMenusForRole(Integer roleID,List<MenuInfo> menuInfos);
	
	/**
	 * Ϊ��ɫɾ���˵�
	 * @param roleID
	 * @param menuInfos Ϊ�ý�ɫɾ���Ĳ˵�
	 * @return
	 */
	void deleteMenusForRole(Integer roleID,List<MenuInfo> menuInfos);
	
	/**
	 * ���һ���û�
	 * @param userInfo
	 */
	void addUser(UserInfo userInfo);
	
	/**
	 * ��������û�
	 * @param userInfos
	 */
	void insertUserBatch(List<UserInfo> userInfos);
	
	/**
	 * �����û�
	 * @param userInfo
	 */
	void updateUser(UserInfo userInfo);
	
	/**
	 * ɾ���û�
	 * @param userID
	 */
	void deleteUser(Integer userID);
	
	/**
	 * ��ѯ�ò˵�������Щ��ɫ��ӵ��
	 * @param userID
	 * @return
	 */
	List<RoleUserMap> selectRolesForUser(Integer userID);
	
	/**
	 * ��ѯ�ò˵�������Щ��ɫ��ӵ��
	 * @param userID
	 * @return
	 */
	List<RoleInfo> selectRolesForUser2(Integer userID);
	
	/**
	 * Ϊ�û���ӽ�ɫ
	 * @param userID
	 * @param roleInfos Ϊ���û���ӵĽ�ɫ
	 * @return
	 */
	void addRolesForUser(Integer userID,List<RoleInfo> roleInfos);	

	/**
	 * Ϊ�û�ɾ����ɫ
	 * @param userID
	 * @param roleInfos Ϊ���û�ɾ���Ľ�ɫ
	 * @return
	 */
	void deleteRolesForUser(Integer userID,List<RoleInfo> roleInfos);	

	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	List<RoleUserMap> selectUsersForRole(Integer roleID);
	
	/**
	 * Ϊ��ɫ����û�
	 * @param roleID
	 * @param userInfos Ϊ�ý�ɫ��ӵ��û�
	 * @return
	 */
	void addUsersForRole(Integer roleID,List<UserInfo> userInfos);	

	/**
	 * Ϊ��ɫɾ���û�
	 * @param roleID
	 * @param userInfos Ϊ�ý�ɫɾ�����û�
	 * @return
	 */
	void deleteUsersForRole(Integer roleID,List<UserInfo> userInfos);	

	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	List<UserInfo> selectUsersForRole2(Integer roleID);
	
	/**
	 * ����һ����¼
	 * @param roleUserMap
	 */
	void insertRoleUser(RoleUserMap roleUserMap);
	
	/**
	 * ���ݹ����������ID��ɾ��������ϵ
	 * @param roleUserID
	 */
	void deleteRoleUser(Integer roleUserID);
	
	/**
	 * ����roleIDɾ������û���صĹ�����ϵ
	 * @param roleID
	 */
	void deleteRoleUserByRoleID(Integer roleID);
	
	/**
	 * ����userIDɾ����֮��صĹ�����ϵ
	 * @param userID
	 */
	void deleteRoleUserByUserID(Integer userID);
	
	/**
	 * �������������ϵ
	 * @param roleUserMaps
	 */
	void insertRoleUserBatch(List<RoleUserMap> roleUserMaps);
	
}
