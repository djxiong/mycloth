package com.hros.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.TabColumn;

@Repository
public interface TabColumnDao {
	public List selectTabColByUser(TabColumn tabColumn);
	
	public TabColumn selectTabCol(TabColumn tabColumn);
	
	public void insertTabCol(TabColumn tabColumn);
	
	public void updateTabCol(TabColumn tabColumn);
}
