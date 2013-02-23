package com.hros.insurance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.TreeNodeInfo;

@Repository
public interface TreeNodeDao {

	TreeNodeInfo getTreeNodeByID(Integer id);
	
	void updateTreeNode(TreeNodeInfo treeNodeInfo);
	
	void insertTreeNode(TreeNodeInfo treeNodeInfo);
	
	void deleteTreeNode(Integer id);
	
	List<Object> getContainedItems(TreeNodeInfo treeNodeInfo);
	
	List<TreeNodeInfo> selectTreeNodeList(String itemTableName);
}
