package com.hros.insurance.domain;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TreeNodeInfo {
	/**
	 * 主键ID
	 */
	private Integer treeNodeID;
	/**
	 * 显示名称
	 */
	private String treeNodeName;
	/**
	 * 所包含的元素的表名,比如insurance
	 */
	private String itemTableName;
	/**
	 * 父节点
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
