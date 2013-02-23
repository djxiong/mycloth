package com.hros.staffmanage.vaadin;

import com.hros.staffmanage.domain.StaffManage;
import com.hros.staffmanage.service.StaffManageService;
import com.hros.vaadin.myComponent.BasePageForm;
import com.hros.vaadin.myComponent.MyForm;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class StaffManagerForm extends BasePageForm {
	
	private StaffManageService staffManageService;
	
	@Override
	public void attach() {
		super.attach();
		staffManageService = (StaffManageService) springHelp.getBean("staffManageServiceImpl");
	}

	@Override
	public void initCompany() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getBeanItem() {
		return new StaffManage();
	}

	@Override
	public void btnSearch(ClickEvent event) {
		StaffManage staffManage =  new StaffManage();
		staffManageService.findStafffilter(staffManage);
	}

	@Override
	public HorizontalLayout buildFilterLayout() {
		filterLayout = new HorizontalLayout();
		return filterLayout;
	}

	@Override
	public void btnAdd(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void btnEdit(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void btnDelete(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public MyForm initForm() {
		return new StaffForm();
	}

	@Override
	public void saveCustomer(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCustomer(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
