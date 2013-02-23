package com.hros.insurance.domain;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TreeNodeInfo {
	/**
	 * ����ID
	 */
	private Integer treeNodeID;
	/**
	 * ��ʾ����
	 */
	private String treeNodeName;
	/**
	 * ��������Ԫ�صı���,����insurance
	 */
	private String itemTableName;
	/**
	 * ���ڵ�
	 */
	private Integer parentID = 0;

	public static final String TABLE_NAME_INSURANCE="INSURANCE";
	
	public Integer getTreeNodeID() {
		return treeNodeID;
	}

	public void setTreeNodeID(Integer treeNodeID) {
		this.treeNodeID = treeNodeID;
	}

	public String getTreeNodeName() {
		return treeNodeName;
	}

	public void setTreeNodeName(String treeNodeName) {
		this.treeNodeName = treeNodeName;
	}

	public String getItemTableName() {
		return itemTableName;
	}

	public void setItemTableName(String itemTableName) {
		this.itemTableName = itemTableName;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}



	public String toString() {
		return this.treeNodeName;
		//return ToStringBuilder.reflectionToString(this);
	}
}
