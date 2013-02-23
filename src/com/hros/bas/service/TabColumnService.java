package com.hros.bas.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.TabColumn;

@Repository
public interface TabColumnService {
	public List selectTabColByUser(String tabClass, String tabName, int userId);
	
	public Map selectTabColumn(String tabClass, String tabName, int userId);
	
	public void saveTabCol(TabColumn tabColumn);
}
