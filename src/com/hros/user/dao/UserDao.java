package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.user.domain.UserInfo;

@Repository
public interface UserDao {
	
	/**
	 * ��ȡuser�����м�¼
	 * @return
	 */
	public List<UserInfo> selectUserBatch(List<Integer> userIDs);
	
	/**
	 * ��ѯ�û�
	 * @param map
	 * @return
	 */
	public UserInfo selectUser(Map map);
	
	/**
	 * ��ȡ�����û�
	 * @return
	 */
	public List<UserInfo> selectAllUsers();

	/**
	 * ���һ���û�
	 * @param userInfo
	 */
	void insertUser(UserInfo userInfo);
	
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
	 * �����û���¼�������û�
	 * @param userName
	 * @return
	 */
	List<UserInfo> searchUserByLoginName(String userLoginName);
	
	/**
	 * �����û��������û�
	 * @param userName
	 * @return
	 */
	List<UserInfo> searchUserByName(String userName);
	
}
