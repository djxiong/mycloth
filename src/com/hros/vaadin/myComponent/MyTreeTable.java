package com.hros.vaadin.myComponent;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.Data;

import com.hros.bas.pubLib.PubLib;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.ui.TreeTable;

/**
 * 封装treetable
 * @author pb
 */
@SuppressWarnings("serial")
public class MyTreeTable extends TreeTable {
	
	//key为field，value为表头显示
	Map<String, String> colMap = new LinkedHashMap<String, String>();
	
	String id = "";
	String fId = "";
	
	public MyTreeTable() {
		this.setSelectable(true);
		this.setFooterVisible(true);
		this.setColumnReorderingAllowed(true);
		this.setColumnCollapsingAllowed(false);
		this.setImmediate(true);
		this.setNullSelectionAllowed(false);
	}
	
	/**
	 * 设置树为多选模式
	 */
	public void setMultiTreeTable() {
		this.setMultiSelect(true);
		this.setMultiSelectMode(MultiSelectMode.SIMPLE);
	}
	
	//根据对象创建列
	public void addColumns(Object obj) {
		for (Field f:obj.getClass().getDeclaredFields()){
			this.addContainerProperty(f.getName(), PubLib.getClsByField(f), 
					PubLib.getObjFieldValue(obj, f.getName()));
		}
	}
	
	public void setContainerDataSource(Object cls) {
		BeanItemContainer item = new BeanItemContainer(cls.getClass());
		setContainerDataSource(item);
	}
	
	/**
	 * 增加table状列表
	 * @param list
	 */
	public void addTableItems(List list) {
		Hierarchical dataSource = getContainerDataSource();
		for (Object obj:list) {
			dataSource.addItem(obj);
			this.setChildrenAllowed(obj, false);
		}
	}
	
	/**
	 * 指定树的ID和FID，如果是TABLE样式的，不需要
	 * @param id
	 * @param fId
	 */
	public void setTreeField(Map map) {
		try {
			for (Field f : this.getClass().getDeclaredFields()) {
				if (map.containsKey(f.getName())) {
//					f.setAccessible(true);
					f.set(this, map.get(f.getName()));
				}
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加树状列表
	 * @param list
	 */
	public void addTreeItems(List list) {
		int itemId = 0;
		int fitemId = 0;
		Map<Integer, Object> fMap = new HashMap<Integer, Object>();
		Hierarchical dataSource = getContainerDataSource();
		for (Object obj:list) {
			itemId = PubLib.StrToInt(PubLib.getObjFieldValue(obj, id).toString());
			fitemId = PubLib.StrToInt(PubLib.getObjFieldValue(obj, fId).toString());
			dataSource.addItem(obj);
			fMap.put(itemId, obj);
			dataSource.setChildrenAllowed(obj, false);
			if (fitemId > 0) {
				dataSource.setChildrenAllowed(fMap.get(fitemId), true);
				dataSource.setParent(obj, fMap.get(fitemId));
			}
		}
		this.select(this.firstItemId());
	}
	
	/**重写addItem方法
	 * 根据带入的OBJ自动创建行，返回ITEMID
	 * @param obj  需要展示的对象
	 * @param itemId  生成的节点ID
	 * @return  返回节点ID
	 */
	public Object addItem(Object obj, Object itemId) {
		Item item = null;
		if (itemId == null) {
			itemId = addItem();
			if (itemId == null) {
				return null;
			}
			item = getItem(itemId);
			this.setChildrenAllowed(itemId, false);
		} else if (this.getItemIds().contains(itemId)) {
			item = getItem(itemId);
		} else {
			item = addItem(itemId);
			this.setChildrenAllowed(itemId, false);
		}
		
		for (Field f : obj.getClass().getDeclaredFields()) {
			Object fieldValue = PubLib.getObjFieldValue(obj, f.getName());
			item.getItemProperty(f.getName()).setValue(fieldValue);
			//设置树的父节点
			if (fId !=null && fId != "" && fId == f.getName() 
					&& PubLib.StrToInt(fieldValue.toString()) > 0) {
				this.setChildrenAllowed(fieldValue, true);
				this.setParent(itemId, fieldValue);
			}
		}
		return itemId;
	}
	
	/**
	 * 根据数据库中取出的LIST自动生成树
	 * 该LIST按照FID排列
	 * @param list
	 */
	public void addItemsById(List list) {
		int itemId = 0;
		for (Object obj:list) {
			itemId = PubLib.StrToInt(PubLib.getObjFieldValue(obj, id).toString());
			addItem(obj, itemId);
			this.setChildrenAllowed(itemId, false);
		}
	}

	//自动添加数据库查询出来的list, 根据父子节点排序
	public void addItemsById2(List list) {
		Map<Integer, Object> objMap = new HashMap<Integer, Object>();
		int itemId = 0;
		int fItemId = 0;
		for (Object obj:list) {
			itemId = PubLib.StrToInt(PubLib.getObjFieldValue(obj, id).toString());
			fItemId = PubLib.StrToInt(PubLib.getObjFieldValue(obj, fId).toString());
			addItem(obj, obj);
			objMap.put(itemId, obj);
			this.setChildrenAllowed(obj, false);
			if (fItemId > 0) {
				Object fObj = objMap.get(fItemId);
				this.setChildrenAllowed(fObj, true);
				this.setParent(obj, fObj);
			}
		}
	}
	
	//添加同级节点
	public Object addNode(Object obj) {
		Object value =this.getValue();
		Object fnode = null;
		if (value != null) {
			fnode = this.getParent(this.getValue());
		}
		Object itemId = addItem(obj, null);
		setChildrenAllowed(itemId, false);
		if (fId!="") {
			this.getItem(itemId).getItemProperty(fId).setValue(fnode==null?0:fnode);
			this.setParent(itemId, fnode);
		}
		this.select(itemId);
		return itemId;
	}
	
	//添加下级节点
	public Object addNodeNext(Object obj) {
		Object fnode = this.getValue();
		if (fnode == null) {
			return null;
		}
		
		Object itemId = addItem(obj, null);
		setChildrenAllowed(itemId, false);
		if (fId!="") {
			this.getItem(itemId).getItemProperty(fId).setValue(fnode==null?0:fnode);
			this.setChildrenAllowed(fnode, true);
			this.setParent(itemId, fnode);
			this.setCollapsed(fnode, false);
		}
		this.select(itemId);
		return itemId;
	}
	
	//删除节点
	public Object deleteNode() {
		Object node = this.getValue();
		Object fnode = this.getParent(node);
		this.removeItem(node);
		if (fnode != null) {
			this.select(fnode);
		} else {
			this.select(firstItemId());
		}
		return node;
	}
	
	//保存节点
	public void updateNode(Object obj) {
		if (obj != null) {
			Object itemId = PubLib.getObjFieldValue(obj, id);
			if (!this.getItemIds().contains(itemId)) {
				this.removeItem(this.getValue());
			}
			this.addItem(obj, itemId);
			this.select(itemId);
		}
	}
	
	/**
	 * 将TABLE中的ITEM转化为OBJ
	 * 在提交数据库之前调用
	 * @param obj
	 * @return
	 */
	public Object takeItemToObj(Object obj) {
		Item item = this.getItem(this.getValue());
		for (Field f:obj.getClass().getDeclaredFields()) {
			PubLib.setObjFieldValue(obj, f.getName(), item.getItemProperty(f.getName()).getValue());
		}
		return obj;
	}
	
	public Map<String, String> getColMap() {
		return colMap;
	}

	public void setColMap(Map<String, String> colMap) {
		this.colMap = colMap;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

}
