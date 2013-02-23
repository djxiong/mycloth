package com.hros.insurance.service.impl;

import java.util.List;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hros.insurance.dao.TreeNodeDao;
import com.hros.insurance.domain.TreeNodeInfo;
import com.hros.insurance.service.TreeNodeService;

@Repository
public class TreeNodeServiceImpl implements TreeNodeService{

	@Autowired
	private TreeNodeDao  treeNodeDao;
	
	
	
	//@Override
	public void addTreeNode(TreeNodeInfo treeNodeInfo) {
		// TODO Auto-generated method stub
		treeNodeDao.insertTreeNode(treeNodeInfo);
	}

	

	@Override
	public TreeNodeInfo getTreeNodeByID(Integer id) {
		// TODO Auto-generated method stub
		return treeNodeDao.getTreeNodeByID(id);
		
	}

	

	
	//@Override
	public void updateTreeNode(TreeNodeInfo treeNodeInfo) {
		// TODO Auto-generated method stub
		treeNodeDao.updateTreeNode(treeNodeInfo);
		
	}



	//@Override
	public List<Object> getContainedItems(TreeNodeInfo treeNodeInfo) {
		// TODO Auto-generated method stub
		return  treeNodeDao.getContainedItems(treeNodeInfo);
		
	}



	@Override
	public List<TreeNodeInfo> selectTreeNodeList(String itemTableName) {
		// TODO Auto-generated method stub
		return treeNodeDao.selectTreeNodeList(itemTableName);
	}



	@Override
	public void deleteTreeNode(Integer treeNodeID) {
		// TODO Auto-generated method stub
		treeNodeDao.deleteTreeNode(treeNodeID);
	}


}
