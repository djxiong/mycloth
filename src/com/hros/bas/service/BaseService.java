package com.hros.bas.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.hros.vaadin.myComponent.FieldAttr;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.ui.FormFieldFactory;

/**
 * service����ӿڣ�����ʵ�ִ���ͨ�õĽӿڷ���
 * @author PB
 *
 */
public interface BaseService {

	//��ȡtalbe��bean
	public Object getBeanItem();
	
	//table�Ŀɼ���
	public Object[] getTableVisibleColumns();
	
	//table�ı�ͷ
	public String[] getTableHeaders();
	
	//form�Ŀɼ��ֶ�
	public Object[] getFormVisibleItems();
	
	//form�ĸ��ֶξ�����ʾ
	public Map<String, FieldAttr> getFactoryMap();
	
	//��ȡ��������Դ
	public List getTreeTableItems();
	
	//��������
	public Object saveNode(Object obj);
	
	//ɾ������
	public boolean deleteNode(Object obj);

	//��ȡ��Ҫ��ֵ���ֶ�
	public Map getFieldName();
}
