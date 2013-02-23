package com.hros.bas.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hros.vaadin.myComponent.FieldAttr;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.ui.FormFieldFactory;

/**
 * service基类接口，用于实现窗口通用的接口发放
 * @author PB
 *
 */
public interface BaseService {

	//获取talbe的bean
	public Object getBeanItem();
	
	//table的可见列
	public Object[] getTableVisibleColumns();
	
	//table的表头
	public String[] getTableHeaders();
	
	//form的可见字段
	public Object[] getFormVisibleItems();
	
	//form的各字段具体显示
	public Map<String, FieldAttr> getFactoryMap();
	
	//获取树的数据源
	public List getTreeTableItems();
	
	//保存数据
	public Object saveNode(Object obj);
	
	//删除数据
	public boolean deleteNode(Object obj);

	//获取需要赋值的字段
	public Map getFieldName();
}
