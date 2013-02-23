package com.hros.bas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.dao.MenuDao;
import com.hros.bas.domain.MenuInfo;
import com.hros.bas.service.MenuService;

@Repository
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	private MenuInfo addMenu(MenuInfo menu) {
		menuDao.addMenu(menu);
		return menu;
	}

	private MenuInfo updateMenu(MenuInfo menu) {
		menuDao.updateMenu(menu);
		return menu;
	}

	@Override
	public Boolean deleteMenu(int menuId) {
		try {
			menuDao.deleteMenu(menuId);
			return true;
		} catch (Exception e){
			return false;
		}
	}

	@Override
	public List<MenuInfo> getAllMenuList(String domainClass) {
		List list = menuDao.selectMenuList();
		return list;
	}

	@Override
	public MenuInfo saveMenu(MenuInfo menu) {
		if (menu.getMenuID() == null || menu.getMenuID() == 0 ) {
			return addMenu(menu);
		} else {
			return updateMenu(menu);
		}
	}

}
