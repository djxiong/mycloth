package com.hros.insurance.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.insurance.domain.TreeNodeInfo;
import com.hros.insurance.service.TreeNodeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class TreeNodeTest {
	
	@Autowired
	private TreeNodeService treeNodeService;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	//@Test
	public void addTreeNode(){
		TreeNodeInfo info = new TreeNodeInfo();
		info.setTreeNodeName("testname");
		info.setItemTableName("treeNode");
		treeNodeService.addTreeNode(info);
	}
	
	//@Test
	public void addTreeNodeRecurively(){
		TreeNodeInfo info = new TreeNodeInfo();
		info.setTreeNodeName("parentname");
		info.setItemTableName("parent");
		treeNodeService.addTreeNode(info);
		
		TreeNodeInfo child = new TreeNodeInfo();
		child.setTreeNodeName("child");
		child.setItemTableName("child");
		child.setParentID(info.getTreeNodeID());
		treeNodeService.addTreeNode(child);
		
	}
	//@Test
	public void getContainedItems(){
		TreeNodeInfo info = treeNodeService.getTreeNodeByID(4);
		List<Object> items = treeNodeService.getContainedItems(info);
		log.info(items);
	}
	
	//@Test
	public void getTreeNodeByID(){
			TreeNodeInfo info = treeNodeService.getTreeNodeByID(5);
			//log.info(info.getChildren());
			log.info(info);
	}
	
	@Test
	public void selectTreeNodeList(){
		List<TreeNodeInfo> aa =treeNodeService.selectTreeNodeList(TreeNodeInfo.TABLE_NAME_INSURANCE);
		log.info(aa);
	}
}
