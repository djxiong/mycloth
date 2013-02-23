package com.hros.bas.domain;

public class TabColumn {
	private int colId;
	
	private String colName;
	
	private String colCName;
	
	private int colWidth;
	
	private boolean colIsVisible;
	
	private String tabClass;
	
	private String tabName;
	
	private int userId;

	public int getColId() {
		return colId;
	}

	public void setColId(int colId) {
		this.colId = colId;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getColCName() {
		return colCName;
	}

	public void setColCName(String colCName) {
		this.colCName = colCName;
	}

	public int getColWidth() {
		return colWidth;
	}

	public void setColWidth(int colWidth) {
		this.colWidth = colWidth;
	}

	public boolean isColIsVisible() {
		return colIsVisible;
	}

	public void setColIsVisible(boolean colIsVisible) {
		this.colIsVisible = colIsVisible;
	}

	public String getTabClass() {
		return tabClass;
	}

	public void setTabClass(String tabClass) {
		this.tabClass = tabClass;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
