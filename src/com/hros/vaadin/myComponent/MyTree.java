/**
 * MyTree用法与tree相同
 * 通过setDataSetList指定数据源
 * List是对象的集合，ID，FID,CaptionField分别对应List中Object的主键、父节点、需要显示的字段
 */
package com.hros.vaadin.myComponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.bas.pubLib.PubLib;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Tree;

@SuppressWarnings("serial")
public class MyTree extends Tree {
	//tree数据源
	private List<Object> dataSetList;
	//Object中展示的字段
	private String captionField;
	//object中的ID
	private String id;
	//objcte中的fID
	private String fId;
	
	/*****右键菜单******/
	static Action actionAdd = new Action("添加同级");
	static Action actionAddChild = new Action("添加下一级");
	static Action actionDelete = new Action("删除");
	private static final Action[] Actions = new Action[] { actionAdd,
		actionAddChild, actionDelete };
	/*****右键菜单  结束******/

	public MyTree(){
		initTree();
	}
	
	public MyTree(String caption){
		this();
		setCaption(caption);
	}
	
	private void initTree(){
		this.setImmediate(true);
	}

	//添加节点
	public Object addNode(Object obj){
		Object fItemId = this.getParent(this.getValue());
		this.addItem(obj);
		if (fItemId != null) {
			this.setParent(obj, fItemId);
			PubLib.setObjFieldValue(obj, fId, PubLib.getObjFieldValue(fItemId, id));
		}
		this.setChildrenAllowed(obj, false);
		this.select(obj);
		return fItemId;
	}
	
	//添加子节点
	public Object addNodeNext(Object obj){
		Object fItemId = this.getValue();
		if (fItemId == null) {
			return null;
		}
		
		this.setChildrenAllowed(fItemId, true);
		this.addItem(obj);
		this.setParent(obj, fItemId);
		PubLib.setObjFieldValue(obj, fId, PubLib.getObjFieldValue(fItemId, id));
		
		this.setChildrenAllowed(fItemId, true);
		this.setChildrenAllowed(obj, false);
		this.expandItem(fItemId);
		this.select(obj);
		return fItemId;
	}
	
	//删除节点
	public int deleteNode() {
		Object itemId = this.getValue();
		int i = PubLib.StrToInt((PubLib.getObjFieldValue(itemId, id).toString()));
		Object fItemId = this.getParent(itemId);
		this.removeItem(itemId);
		if (fItemId != null) {
			this.select(fItemId);
			if (this.getChildren(fItemId).isEmpty()) {
				this.setChildrenAllowed(fItemId, false);
			}
		}
		return i;
	}
	
	public void updateNode(Object obj) {
		Item item = this.getItem(obj);
		String sName=PubLib.getObjFieldValue(obj, captionField).toString();
		item.getItemProperty(captionField).setValue(sName);
	}
	
	//设置tree的数据源
	private void setTreeDataSource(){
		this.setContainerDataSource(getHardwareContainer());
		this.setItemCaptionPropertyId(captionField);
		this.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
	}
	
	//生成tree数据源
	private HierarchicalContainer getHardwareContainer(){
		Item item = null;
        int itemId = 0;
        int fItemId = 0;
        Object obj = null;
        Object fObj = null;
        
        // Create new container
        HierarchicalContainer hwContainer = new HierarchicalContainer();
        hwContainer.addContainerProperty(captionField, String.class, null);
    	Map<Integer, Object> itemMap = new HashMap<Integer, Object>();
       
        for (int i = 0; i < dataSetList.size(); i++) {
        	obj = dataSetList.get(i);
        	//tree展示字段
        	String sName=PubLib.getObjFieldValue(obj, captionField).toString();
        	//节点
        	itemId=PubLib.StrToInt(PubLib.getObjFieldValue(obj, id).toString());
        	//父节点
        	fItemId=PubLib.StrToInt(PubLib.getObjFieldValue(obj, fId).toString());
        	//获取父节点的MAP
        	itemMap.put(itemId, obj);
        	item = hwContainer.addItem(obj);
        	item.getItemProperty(captionField).setValue(sName);
        	
    		hwContainer.setChildrenAllowed(obj, false);
        	if (fItemId != 0){
        		fObj = itemMap.get(fItemId);
        		hwContainer.setChildrenAllowed(fObj, true);
        		hwContainer.setParent(obj, fObj);
        	}
        }
		return hwContainer;
	}
	
	public List<Object> getDataSetList() {
		return dataSetList;
	}

	public void setDataSetList(List<Object> dataSetList, String captionField, String id, String fId) {
		this.captionField = captionField;
		this.id = id;
		this.fId = fId;
		this.dataSetList = dataSetList;
		setTreeDataSource();
	}

	public String getCaptionField() {
		return captionField;
	}

	public void setCaptionField(String captionField) {
		this.captionField = captionField;
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

	public void setDataSetList(List<Object> dataSetList) {
		this.dataSetList = dataSetList;
	}
}
