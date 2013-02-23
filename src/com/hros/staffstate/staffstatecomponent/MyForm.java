package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;

@SuppressWarnings("serial")
public class MyForm extends Form {

	public MyForm() {
		// TODO Auto-generated constructor stub
	}

	public MyForm(int m, int n) {

		GridLayout gridLayout = new GridLayout(m, n);
		gridLayout.setSpacing(true);
		gridLayout.setMargin(true, true, false, true);
		setLayout(gridLayout);
	}
	
	public void setFactory(DefaultFieldFactory fieldFactory){
		this.setFormFieldFactory(fieldFactory);
	}

	public void setDateSource(BeanItem<?> beanItem){
		this.setItemDataSource(beanItem);
	}
	
	public void setVisible(List<?> list){
		this.setVisibleItemProperties(list);
	}
}
