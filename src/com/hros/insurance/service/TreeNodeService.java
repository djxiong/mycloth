package com.hros.insurance.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.insurance.domain.TreeNodeInfo;


@Repository
public interface TreeNodeService {


	void addTreeNode(TreeNodeInfo insuranceDetailInfo);
	
	void updateTreeNode(TreeNodeInfo insuranceDetailInfo);
	
	TreeNodeInfo getTreeNodeByID(Integer id);
	
	List<Object> getContainedItems(TreeNodeInfo treeNodeInfo);
	
	List<TreeNodeInfo> selectTreeNodeList(String itemTableName);
  
	void deleteTreeNode(Integer treeNodeID);
}
