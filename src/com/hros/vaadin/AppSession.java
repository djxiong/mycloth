package com.hros.vaadin;

import com.hros.user.domain.UserInfo;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.Application;

public class AppSession {
	private SpringContextHelper help;
	
	private UserInfo userInfo = new UserInfo();
	
	public SpringContextHelper getHelp() {
		return help;
	}

	public void setHelp(SpringContextHelper help) {
		this.help = help;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
