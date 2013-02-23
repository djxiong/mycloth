package com.hros.bas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.dao.TabColumnDao;
import com.hros.bas.domain.TabColumn;
import com.hros.bas.service.TabColumnService;

@Repository
@Transactional
public class TabColumnServiceImpl implements TabColumnService {
	
	@Autowired
	private TabColumnDao tabColumnDao;

	@Override
	public List selectTabColByUser(String tabClass, String tabName, int userId) {
		TabColumn tabCol = new TabColumn();
		tabCol.setTabClass(tabClass);
		tabCol.setTabName(tabName);
		tabCol.setUserId(userId);
		return tabColumnDao.selectTabColByUser(tabCol);
	}

	@Override
	public void saveTabCol(TabColumn tabColumn) {
		TabColumn tabCol =  tabColumnDao.selectTabCol(tabColumn);
		if (tabCol == null) {
			tabColumnDao.insertTabCol(tabColumn);
		} else {
			tabColumnDao.updateTabCol(tabColumn);
		}
	}

	@Override
	public Map selectTabColumn(String tabClass, String tabName, int userId) {
		TabColumn tabColumn = new TabColumn();
		tabColumn.setTabClass(tabClass);
		tabColumn.setTabName(tabName);
		tabColumn.setUserId(userId);
		
		List<TabColumn> list = tabColumnDao.selectTabColByUser(tabColumn);
		String visibleColumns = "";
		String columnHeaders = "";
		
		for (TabColumn col: list) {
			visibleColumns = visibleColumns + "," + col.getColName();
			columnHeaders = columnHeaders + "," + col.getColCName();
		}
		
		visibleColumns = visibleColumns.substring(1);
		columnHeaders = columnHeaders.substring(1);
		
		Map map = new HashMap();
		map.put("visibleColumns", visibleColumns.split(","));
		map.put("columnHeaders", columnHeaders.split(","));
		
		return map;
	}

}
