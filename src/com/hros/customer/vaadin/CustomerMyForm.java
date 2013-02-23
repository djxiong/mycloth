package com.hros.customer.vaadin;

import com.hros.vaadin.myComponent.MyForm;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;

@SuppressWarnings("serial")
public class CustomerMyForm extends MyForm {
	private GridLayout ourLayout;
	
	public CustomerMyForm() {
		ourLayout = new GridLayout(3,5);
		ourLayout.setMargin(false);
		ourLayout.setSpacing(true);
		ourLayout.setStyleName("gridexample");
		this.setLayout(ourLayout);
	}
	
	public CustomerMyForm(String caption) {
		this();
		this.setCaption(caption);
	}
	
	@Override
	protected void attachField(Object propertyId, Field field) {
		if (propertyId.equals("custCode")) {
			ourLayout.addComponent(field , 0, 0);
		} else if (propertyId.equals("custName")) {
			ourLayout.addComponent(field , 1, 0);
		} else if (propertyId.equals("custLegalPerson")) {
			ourLayout.addComponent(field , 2, 0);
		} else if (propertyId.equals("address")) {
			ourLayout.addComponent(field , 0, 1, 1, 1);
			field.setWidth("100%");
		} else if (propertyId.equals("phone")) {
			ourLayout.addComponent(field , 2, 1);
		} else if (propertyId.equals("industry")) {
			ourLayout.addComponent(field , 0, 2);
		} else if (propertyId.equals("custAttr")) {
			ourLayout.addComponent(field , 1, 2);
		} else if (propertyId.equals("custCity")) {
			ourLayout.addComponent(field , 2, 2);
		} else if (propertyId.equals("custType")) {
			ourLayout.addComponent(field , 0, 3);
		} else if (propertyId.equals("serviceFeeID")) {
			ourLayout.addComponent(field , 1, 3);
		} else if (propertyId.equals("wholeMonthAccount")) {
			ourLayout.addComponent(field , 2, 3);
		} else if (propertyId.equals("remark")) {
			ourLayout.addComponent(field , 0, 4, 2, 4);
			field.setWidth("100%");
		}
	}

}
