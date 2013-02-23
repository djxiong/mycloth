package com.hros.vaadin.myComponent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.hros.customer.vaadin.CustomerForm.dictLabel;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

@SuppressWarnings("serial")
public class MyTable extends Table {
	
	public MyTable() {
		this.setImmediate(true);
		this.setNullSelectionAllowed(false);
		this.setSelectable(true);
		this.setColumnCollapsingAllowed(true);
		this.setColumnReorderingAllowed(true);
	}
	
	public void setBeanItem(Class cls) {
		BeanItemContainer item = new BeanItemContainer(cls);
		this.setContainerDataSource(item);
	}
	
	public void addItems(List list) {
		for (Object obj: list) {
			this.addItem(obj);
		}
		this.select(this.firstItemId());
	}
	
	public Object addNewItem(Object obj) {
		this.addItem(obj);
		this.select(obj);
		return obj;
	}
	
	public void deleteItem() {
		this.removeItem(this.getValue());
		this.select(this.firstItemId());
	}
}
