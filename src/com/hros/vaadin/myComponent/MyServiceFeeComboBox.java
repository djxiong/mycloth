package com.hros.vaadin.myComponent;

import com.hros.bas.service.BaseService;
import com.hros.vaadin.SpringContextHelper;

@SuppressWarnings("serial")
public class MyServiceFeeComboBox extends MyComboBox {
	
	private BaseService serviceFeeService;

	public MyServiceFeeComboBox(String caption, String itemCode, String itemName) {
		super(caption, itemCode, itemName);
	}
	
	@Override
	public void attach() {
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		serviceFeeService = (BaseService) help.getBean("serviceFeeImpl");
		this.loadList(serviceFeeService.getTreeTableItems());
	}

}
