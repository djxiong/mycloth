package com.hros.staffstate.staffstatecomponent;


import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class MyTable extends Table{
	
	public MyTable(){
		setImmediate(true);
		setWidth("100%");
		setHeight("100%");
		setSelectable(true);//选取行
		setNullSelectionAllowed(false);//true取消选择行
		setColumnReorderingAllowed(true);//改变列顺序
		setColumnCollapsingAllowed(true);//隐藏列
		setRowHeaderMode(Table.ROW_HEADER_MODE_INDEX);
		
		
		
		
	}
	
	public void setDateSource(BeanItemContainer<?> beanItem){
		this.setContainerDataSource(beanItem);
	}
	
	public void setColumns(Object[] obj){
		this.setVisibleColumns(obj);//设置显示列标题
	}
	public void setHeader(String[] str){
		this.setColumnHeaders(str);//重新定义列标题
	}
	
	public void setItems(List<?> list){
		for(Object obj:list){
			this.addItem(obj);
		}
	}

}
