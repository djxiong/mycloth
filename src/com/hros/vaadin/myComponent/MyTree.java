/**
 * MyTree�÷���tree��ͬ
 * ͨ��setDataSetListָ������Դ
 * List�Ƕ���ļ��ϣ�ID��FID,CaptionField�ֱ��ӦList��Object�����������ڵ㡢��Ҫ��ʾ���ֶ�
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
	//tree����Դ
	private List<Object> dataSetList;
	//Object��չʾ���ֶ�
	private String captionField;
	//object�е�ID
	private String id;
	//objcte�е�fID
	private String fId;
	
	/*****�Ҽ��˵�******/
	static Action actionAdd = new Action("���ͬ��");
	static Action actionAddChild = new Action("�����һ��");
	static Action actionDelete = new Action("ɾ��");
	private static final Action[] Actions = new Action[] { actionAdd,
		actionAddChild, actionDelete };
	/*****�Ҽ��˵�  ����******/

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

	//��ӽڵ�
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
	
	//����ӽڵ�
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
	
	//ɾ���ڵ�
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
	
	//����tree������Դ
	private void setTreeDataSource(){
		this.setContainerDataSource(getHardwareContainer());
		this.setItemCaptionPropertyId(captionField);
		this.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
	}
	
	//����tree����Դ
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
        	//treeչʾ�ֶ�
        	String sName=PubLib.getObjFieldValue(obj, captionField).toString();
        	//�ڵ�
        	itemId=PubLib.StrToInt(PubLib.getObjFieldValue(obj, id).toString());
        	//���ڵ�
        	fItemId=PubLib.StrToInt(PubLib.getObjFieldValue(obj, fId).toString());
        	//��ȡ���ڵ��MAP
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
