package com.hros.user.vaadin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.hros.bas.domain.MenuInfo;
import com.hros.bas.service.MenuService;
import com.hros.user.domain.RoleInfo;
import com.hros.user.domain.UserInfo;
import com.hros.user.service.UserService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.Notification;

public class RoleForm extends CustomComponent implements Button.ClickListener {

	@AutoGenerated
	private HorizontalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_assign_menus;
	@AutoGenerated
	private Table table_menus;
	@AutoGenerated
	private Button button_save_assigns;
	@AutoGenerated
	private VerticalLayout verticalLayout_role_table;
	@AutoGenerated
	private Table table_roles;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_role_buttons;
	@AutoGenerated
	private Button button_save_role;
	@AutoGenerated
	private Button button_edit_role;
	@AutoGenerated
	private Button button_del_role;
	@AutoGenerated
	private Button button_add_role;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */


	/**
	 * 选中的角色
	 */
	private RoleInfo selectedRoleInfo;
	
	private Set<MenuInfo> selectedMenuInfos;
	
	private UserService userService;
	private MenuService menuService;
	
	Set<MenuInfo> assignedMenuInfos;
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public RoleForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		//角色表格
		table_roles.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                // in multiselect mode, a Set of itemIds is returned,
                // in singleselect mode the itemId is returned directly
            	selectedRoleInfo = (RoleInfo)event.getProperty().getValue();
            	if(selectedRoleInfo == null){
            		return;
            	}
            	//将已授权的菜单标记为选中状态
            	assignedMenuInfos = userService.selectMenusForRole2(selectedRoleInfo.getRoleID());
            	table_menus.setValue(assignedMenuInfos);
            }
        });
		table_roles.setSelectable(true);
		table_roles.setMultiSelect(false);
		table_roles.setImmediate(true); 
		
		//菜单表格
		table_menus.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                // in multiselect mode, a Set of itemIds is returned,
                // in singleselect mode the itemId is returned directly
            	selectedMenuInfos  = (Set<MenuInfo>) event.getProperty().getValue();
            }
        });
		table_menus.setSelectable(true);
		table_menus.setMultiSelect(true);
		table_menus.setImmediate(true);
		
		button_add_role.addListener(this);
		button_del_role.addListener(this);
		button_edit_role.addListener(this);
		button_save_role.addListener(this);
		button_save_assigns.addListener(this);
	}

	@Override
	public void attach(){
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		userService = (UserService) help.getBean("userServiceImpl");
		menuService = (MenuService) help.getBean("menuServiceImpl");
		populateRoles();
		populateMenus();
	}
	
	private void populateMenus(){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("menuName", String.class,null);
		List<MenuInfo> menus = menuService.getAllMenuList("test");
		for(MenuInfo menu:menus){
			 Item item = container.addItem(menu);
			 item.getItemProperty("menuName").setValue(menu.getMenuName());
			 
		}
		
		table_menus.setContainerDataSource(container);
		table_menus.setColumnHeaders(new String[] { "菜单名称"});
		table_menus.setVisibleColumns(new String[] { "menuName"});
		table_menus.setWidth("300px");
	}
	
	private void populateRoles(){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("roleName", String.class,null);
		
		List<RoleInfo> roleInfos = userService.selectAllRoles();
		for(RoleInfo roleInfo:roleInfos){
			 Item item = container.addItem(roleInfo);
			 item.getItemProperty("roleName").setValue(roleInfo.getRoleName());
		}
		
		table_roles.setContainerDataSource(container);
		table_roles.setColumnHeaders(new String[] { "角色名称"});
		table_roles.setVisibleColumns(new String[] { "roleName"});
		table_roles.setWidth("300px");
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		//添加按钮
		if(event.getSource().equals(button_add_role)){
			RoleInfo roleInfo = new RoleInfo();
			userService.addRole(roleInfo);
			Item item = table_roles.getContainerDataSource().addItem(roleInfo);
			item.getItemProperty("roleName").setValue(roleInfo.getRoleName());
			table_roles.setEditable(true);
		}
		//删除按钮
		if(event.getSource().equals(button_del_role)){
			// 如果未选中任何数据,提示用户
			if(selectedRoleInfo == null ){
				getWindow().showNotification("请选择一个角色来删除" ,"未选择数据");
				return;
			}
			// TODO 如果该角色已被授予给某个用户，则不能删除该角色
			List<UserInfo> assignedUsers = userService.selectUsersForRole2(selectedRoleInfo.getRoleID());
			if(assignedUsers != null && assignedUsers.size() > 0){
				String usersStr = "";
				for(UserInfo user:assignedUsers){
					usersStr += user.getUserName() + ",";
				}
				getWindow().showNotification("该角色已被授予用户:"+usersStr+"不能删除" ,"错误",Notification.TYPE_ERROR_MESSAGE);
				return;
			}
			
			userService.deleteRole(selectedRoleInfo.getRoleID());

			table_roles.getContainerDataSource().removeItem(selectedRoleInfo);
			table_roles.requestRepaint();

			selectedRoleInfo = null;
		}
		//编辑按钮
		if(event.getSource().equals(button_edit_role)){
			if(table_roles.isEditable() == false){
				table_roles.setEditable(true);
			}
		}
		//保存按钮
		if(event.getSource().equals(button_save_role)){
			Collection<?> itemIds = table_roles.getContainerDataSource().getItemIds();
			for(Object itemId:itemIds){
				if(itemId instanceof RoleInfo){
					//table.refreshRowCache();
					RoleInfo roleInfo = (RoleInfo)itemId;
					
					roleInfo.setRoleName(table_roles.getItem(itemId).getItemProperty("roleName").toString());
					userService.updateRole(roleInfo);
					
				}
			}
			table_roles.setEditable(false);
			table_roles.requestRepaint();
		}
		//保存授权按钮
		if (event.getSource().equals(button_save_assigns)) {
			// 如果未选中任何数据,提示用户
			if (selectedRoleInfo == null) {
				getWindow().showNotification("请选择一个角色来操作", "未选择数据");
				return;
			}
			
			//遍历,查找该为本角色删除的菜单
			List<MenuInfo> toDeleteMenus = new ArrayList<MenuInfo>();
			for(MenuInfo menuInfo:assignedMenuInfos){
				if(!selectedMenuInfos.contains(menuInfo)){
					toDeleteMenus.add(menuInfo);
				}
			}
			userService.deleteMenusForRole(selectedRoleInfo.getRoleID(), toDeleteMenus);
			//遍历,查找该为本角色添加的菜单
			List<MenuInfo> toAddMenus = new ArrayList<MenuInfo>();
			for(MenuInfo menuInfo:selectedMenuInfos){
				if(!assignedMenuInfos.contains(menuInfo)){
					toAddMenus.add(menuInfo);
				}
			}
			userService.addMenusForRole(selectedRoleInfo.getRoleID(), toAddMenus);
			
			getWindow().showNotification("操作成功", "提示");
		}
	}

	@AutoGenerated
	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// verticalLayout_role_table
		verticalLayout_role_table = buildVerticalLayout_role_table();
		mainLayout.addComponent(verticalLayout_role_table);
		
		// verticalLayout_assign_menus
		verticalLayout_assign_menus = buildVerticalLayout_assign_menus();
		mainLayout.addComponent(verticalLayout_assign_menus);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_role_table() {
		// common part: create layout
		verticalLayout_role_table = new VerticalLayout();
		verticalLayout_role_table.setImmediate(false);
		verticalLayout_role_table.setWidth("-1px");
		verticalLayout_role_table.setHeight("-1px");
		verticalLayout_role_table.setMargin(false);
		
		// horizontalLayout_role_buttons
		horizontalLayout_role_buttons = buildHorizontalLayout_role_buttons();
		verticalLayout_role_table.addComponent(horizontalLayout_role_buttons);
		
		// table_roles
		table_roles = new Table();
		table_roles.setImmediate(false);
		table_roles.setWidth("-1px");
		table_roles.setHeight("-1px");
		verticalLayout_role_table.addComponent(table_roles);
		
		return verticalLayout_role_table;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_role_buttons() {
		// common part: create layout
		horizontalLayout_role_buttons = new HorizontalLayout();
		horizontalLayout_role_buttons.setImmediate(false);
		horizontalLayout_role_buttons.setWidth("-1px");
		horizontalLayout_role_buttons.setHeight("-1px");
		horizontalLayout_role_buttons.setMargin(false);
		
		// button_add_role
		button_add_role = new Button();
		button_add_role.setCaption("新增");
		button_add_role.setImmediate(true);
		button_add_role.setWidth("-1px");
		button_add_role.setHeight("-1px");
		horizontalLayout_role_buttons.addComponent(button_add_role);
		
		// button_del_role
		button_del_role = new Button();
		button_del_role.setCaption("删除");
		button_del_role.setImmediate(true);
		button_del_role.setWidth("-1px");
		button_del_role.setHeight("-1px");
		horizontalLayout_role_buttons.addComponent(button_del_role);
		
		// button_edit_role
		button_edit_role = new Button();
		button_edit_role.setCaption("编辑");
		button_edit_role.setImmediate(true);
		button_edit_role.setWidth("-1px");
		button_edit_role.setHeight("-1px");
		horizontalLayout_role_buttons.addComponent(button_edit_role);
		
		// button_save_role
		button_save_role = new Button();
		button_save_role.setCaption("保存");
		button_save_role.setImmediate(true);
		button_save_role.setWidth("-1px");
		button_save_role.setHeight("-1px");
		horizontalLayout_role_buttons.addComponent(button_save_role);
		
		return horizontalLayout_role_buttons;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_assign_menus() {
		// common part: create layout
		verticalLayout_assign_menus = new VerticalLayout();
		verticalLayout_assign_menus.setImmediate(false);
		verticalLayout_assign_menus.setWidth("-1px");
		verticalLayout_assign_menus.setHeight("-1px");
		verticalLayout_assign_menus.setMargin(false);
		
		// button_save_assigns
		button_save_assigns = new Button();
		button_save_assigns.setCaption("保存授权");
		button_save_assigns.setImmediate(true);
		button_save_assigns.setWidth("-1px");
		button_save_assigns.setHeight("-1px");
		verticalLayout_assign_menus.addComponent(button_save_assigns);
		
		// table_menus
		table_menus = new Table();
		table_menus.setImmediate(false);
		table_menus.setWidth("-1px");
		table_menus.setHeight("-1px");
		verticalLayout_assign_menus.addComponent(table_menus);
		
		return verticalLayout_assign_menus;
	}

}
