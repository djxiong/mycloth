package com.hros.vaadin;

import java.util.List;

import com.hros.user.dao.UserDao;
import com.hros.user.domain.UserInfo;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class MyLoginForm extends CustomComponent {

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private LoginForm loginForm_1;

	
	private UserDao userDao;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public MyLoginForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		loginForm_1.addListener(new LoginListener() {

			@Override
			public void onLogin(LoginEvent event) {
				// TODO Auto-generated method stub
				String userName = event.getLoginParameter("username");
				String password = event.getLoginParameter("password");
				//验证通过
				
				List<UserInfo> foundUsers = userDao.searchUserByLoginName(userName);
				if(foundUsers == null || foundUsers.size() == 0){
					getWindow().showNotification("系统中没有这个用户:"+userName+",请注意输入登录名而不是用户名", "提示");
					return;
				}
				//遍历用户列表,比对密码(实际中用户名应该唯一?)
				for(UserInfo user:foundUsers){
					if(user.getPassword().equals(password)){
						getWindow().getApplication().setUser(user);
						MainWindow mainWindow = new MainWindow();
						mainWindow.setSizeFull();
						Window window = loginForm_1.getWindow();
						window.removeComponent(loginForm_1.getParent().getParent());
						window.addComponent(mainWindow);
						mainWindow.setUserName(userName);
						return;
					}
				}
				getWindow().showNotification("密码不正确:", "提示",Notification.TYPE_WARNING_MESSAGE);
			}});
		loginForm_1.setUsernameCaption("用户名");
		loginForm_1.setPasswordCaption("密码");
		loginForm_1.setLoginButtonCaption("登录");
	}

	@Override
	public void attach(){
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		userDao = (UserDao)help.getBean("userDao");
	}
	
	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setColumns(3);
		mainLayout.setRows(3);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// loginForm_1
		loginForm_1 = new LoginForm();
		loginForm_1.setStyleName("v-loginform");
		loginForm_1.setImmediate(false);
		loginForm_1.setDescription("登录");
		loginForm_1.setWidth("-1px");
		loginForm_1.setHeight("-1px");
		mainLayout.addComponent(loginForm_1, 1, 1);
		mainLayout.setComponentAlignment(loginForm_1, new Alignment(48));
		
		return mainLayout;
	}

}
