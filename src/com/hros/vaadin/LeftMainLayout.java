package com.hros.vaadin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hros.bas.dao.MenuDao;
import com.hros.bas.domain.MenuInfo;
import com.hros.user.domain.RoleInfo;
import com.hros.user.domain.UserInfo;
import com.hros.user.service.UserService;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LeftMainLayout extends VerticalLayout implements
		Accordion.SelectedTabChangeListener, Button.ClickListener {

	private Accordion accordion;
	
	private UserService userService;
	
	private MenuDao menuDao;

	/**
	 * 右侧主tabsheet的引用
	 */
	private RightMainClosableTabSheet rightMainClosableTabSheet;

	/**
	 * 菜单项，key为父菜单，value为子菜单的列表
	 */
	private Map<MenuInfo, List<MenuInfo>> menus = new HashMap<MenuInfo, List<MenuInfo>>();

	public LeftMainLayout() {
		setSpacing(true);

		accordion = new Accordion();
		accordion.setHeight("100%");
		accordion.setWidth("100%");
		accordion.addListener(this);
	}

	@Override
	public void attach() {
		super.attach();
		SpringContextHelper help = new SpringContextHelper(
				this.getApplication());
		userService = (UserService)help.getBean("userServiceImpl");
		menuDao = (MenuDao)help.getBean("menuDao");
		gendata();
		createMenu();
	}

	private void createMenu() {
		for (MenuInfo parentMenu : menus.keySet()) {
			VerticalLayout parentMenuLayout = new VerticalLayout();
			List<MenuInfo> subMenus = menus.get(parentMenu);
			for (MenuInfo menu : subMenus) {
				Button button = new Button();
				button.setDescription(menu.getWinClass());
				button.setCaption(menu.getMenuName());
				button.setData(menu);
				button.addListener(this);
				parentMenuLayout.addComponent(button);
			}
			accordion.addTab(parentMenuLayout, parentMenu.getMenuName());
		}

		addComponent(accordion);
	}

	/**
	 * 生成菜单数据
	 */
	private void gendata() {
		UserInfo currentUser = (UserInfo)getWindow().getApplication().getUser();
		List<RoleInfo> roles = userService.selectRolesForUser2(currentUser.getUserID());
		List<MenuInfo> list = new ArrayList<MenuInfo>();
		//admin给予所有菜单
		if(currentUser.getLoginName().equals("admin")){
			list = menuDao.selectAllMenuList();
		}else{ //根据所赋予的角色查询菜单
			for (RoleInfo role : roles) {
				Set<MenuInfo> menusOfARole = userService
						.selectMenusForRole2(role.getRoleID());
				list.addAll(menusOfARole);
			}
		}
		MenuInfo[] sortedMenus = new MenuInfo[list.size()];
		list.toArray(sortedMenus);
		Arrays.sort(sortedMenus);
		Map<Integer, MenuInfo> menuMap = new HashMap<Integer, MenuInfo>();
		for(MenuInfo menuInfo:sortedMenus){
			menuMap.put(menuInfo.getMenuID(), menuInfo);
			//如果是父菜单,添加一个子菜单列表
			if (menuInfo.getFMenuID() == 0) {
				List<MenuInfo> subMenus = new ArrayList<MenuInfo>();
				menus.put(menuInfo, subMenus);
			} 
			//如果是子菜单,直接添加到列表里
			else {
				menus.get(menuMap.get(menuInfo.getFMenuID())).add(menuInfo);
			}

		}
	}

	public RightMainClosableTabSheet getRightMainClosableTabSheet() {
		return rightMainClosableTabSheet;
	}

	public void setRightMainClosableTabSheet(
			RightMainClosableTabSheet rightMainClosableTabSheet) {
		this.rightMainClosableTabSheet = rightMainClosableTabSheet;
	}

	public void selectedTabChange(SelectedTabChangeEvent event) {
		String c = accordion.getTab(event.getTabSheet().getSelectedTab())
				.getCaption();
		// getWindow().showNotification("Selected tab: " + c);
	}

	public void buttonClick(ClickEvent event) {

		MenuInfo m = (MenuInfo) event.getButton().getData();
		rightMainClosableTabSheet.addCustomTab(m);
		accordion.requestRepaint();
	}

}
