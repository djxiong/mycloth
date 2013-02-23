package com.hros.user.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.user.domain.UserInfo;

@Repository
public interface UserDao {
	
	/**
	 * 获取user中所有记录
	 * @return
	 */
	public List<UserInfo> selectUserBatch(List<Integer> userIDs);
	
	/**
	 * 查询用户
	 * @param map
	 * @return
	 */
	public UserInfo selectUser(Map map);
	
	/**
	 * 获取所有用户
	 * @return
	 */
	public List<UserInfo> selectAllUsers();

	/**
	 * 添加一个用户
	 * @param userInfo
	 */
	void insertUser(UserInfo userInfo);
	
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
	 * 根据用户登录名搜索用户
	 * @param userName
	 * @return
	 */
	List<UserInfo> searchUserByLoginName(String userLoginName);
	
	/**
	 * 根据用户名搜索用户
	 * @param userName
	 * @return
	 */
	List<UserInfo> searchUserByName(String userName);
	
}
