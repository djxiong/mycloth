package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import com.hros.user.domain.RoleMenuMap;

@Repository
public interface RoleMenuDao {
	
	/**
	 * ��ѯ�ò˵�������Щ��ɫ��ӵ��
	 * @param menuID
	 * @return
	 */
	List<RoleMenuMap> selectRolesForMenu(Integer menuID);
	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	List<RoleMenuMap> selectMenusForRole(Integer roleID);
	
	/**
	 * ����һ����¼
	 * @param roleMenuMap
	 */
	void insertRoleMenu(RoleMenuMap roleMenuMap);
	
	/**
	 * ���ݹ����������ID��ɾ��������ϵ
	 * @param roleMenuID
	 */
	void deleteRoleMenu(Integer roleMenuID);
	
	/**
	 * ����roleIDɾ����ý�ɫ��صĹ�����ϵ
	 * @param roleID
	 */
	void deleteRoleMenuByRoleID(Integer roleID);
	
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
	 * ����roleid��menuid��ɾ��
	 * @param map
	 */
	void deleteRoleAndMenu(Map<String,Integer> map);
	
	void deleteMenusForRole(Map<String,Object> map);
}
