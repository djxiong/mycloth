package com.hros.bas.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.MenuInfo;

@Repository
public interface MenuService {
	public MenuInfo saveMenu(MenuInfo menu);
	//ɾ��
	public Boolean deleteMenu(int menuId);
	//��ѯ
	public List<MenuInfo> getAllMenuList(String domainClass);
}
