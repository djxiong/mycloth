package com.hros.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.MenuInfo;

@Repository
public interface MenuDao {
	public MenuInfo selectMenu(int id);
	
	public List<MenuInfo> selectMenuList();
	
	//只去MENU的最底层
	public List<MenuInfo> selectMenuChild();
	
	public void addMenu(MenuInfo menuInfo);
	
	public void updateMenu(MenuInfo menuInfo);
	
	public void deleteMenu(int id);
	
	public List<MenuInfo> selectAllMenuList();
}
