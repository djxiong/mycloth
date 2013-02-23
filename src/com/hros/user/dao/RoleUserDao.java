package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.user.domain.RoleUserMap;

@Repository
public interface RoleUserDao {
	
	/**
	 * ��ѯ�ò˵�������Щ��ɫ��ӵ��
	 * @param userID
	 * @return
	 */
	List<RoleUserMap> selectRolesForUser(Integer userID);
	
	/**
	 * ��ѯ��roleӵ�е����в˵�
	 * @param roleID
	 * @return
	 */
	List<RoleUserMap> selectUsersForRole(Integer roleID);
	
	/**
	 * ����һ����¼
	 * @param roleUserMap
	 */
	void insertRoleUser(RoleUserMap roleUserMap);
	
	/**
	 * ɾ��һ����¼
	 * @param roleUserMap as {{roleID=1},{userID=2}}
	 */
	void deleteRoleAndUser(Map<String,Integer> roleUserMap);
	
	/**
	 * ����ɾ����¼
	 * @param roleUserMap as {{userID=1},{roleIDs=(2,3,4)}}
	 */
	void deleteRolesForUser(Map<String,Object> userRolesMap); 
	
	/**
	 * ����ɾ����¼
	 * @param roleUserMap as {{roleID=1},{userIDs=(2,3,4)}}
	 */
	void deleteUsersForRole(Map<String,Object> roleUsersMap); 
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
