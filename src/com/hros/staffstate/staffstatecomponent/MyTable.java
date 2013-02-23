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
		setSelectable(true);//ѡȡ��
		setNullSelectionAllowed(false);//trueȡ��ѡ����
		setColumnReorderingAllowed(true);//�ı���˳��
		setColumnCollapsingAllowed(true);//������
		setRowHeaderMode(Table.ROW_HEADER_MODE_INDEX);
		
		
		
		
	}
	
	public void setDateSource(BeanItemContainer<?> beanItem){
		this.setContainerDataSource(beanItem);
	}
	
	public void setColumns(Object[] obj){
		this.setVisibleColumns(obj);//������ʾ�б���
	}
	public void setHeader(String[] str){
		this.setColumnHeaders(str);//���¶����б���
	}
	
	public void setItems(List<?> list){
		for(Object obj:list){
			this.addItem(obj);
		}
	}

}
