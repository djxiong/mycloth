package com.hros.vaadin.myComponent;

import java.util.List;

import com.hros.bas.pubLib.PubLib;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class MyComboBox extends ComboBox{
	
	Object firstObj;
	
	String itemName;
	
	String itemCode;
	
	boolean hasRootNode = true;
	
	/**
	 * ����һ��COMBBOX
	 * @param caption	����
	 * @param dataList	��Ҫ���ص�LIST
	 * @param itemCode	ʵ��ֵ(list��OBJ�еĶ�������)
	 * @param itemName	��ʾ��ֵ(list��OBJ�еĶ�������)
	 */
	public MyComboBox(String caption, 
			String itemCode, String itemName) {
		this.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		this.setImmediate(true);
		this.setNullSelectionAllowed(false);

		this.setCaption(caption);
		this.itemCode = itemCode;
		this.itemName = itemName;
	}
	
	@Override
	public void attach() {
		super.attach();
		//Ĭ��ѡ���һ��
		if (this.getValue() != null) {
			this.select(this.getValue());
		} else {
			this.select(firstObj);
		}
	}
	
	//��������
	public void loadList(List dataList) {
		this.addContainerProperty(itemName, String.class, "");
		this.setItemCaptionPropertyId(itemName);
		Object code = null;
		String name = "";
		for (Object obj: dataList) {
			//û�е�һ�����ڵ�
			if (!hasRootNode) {
				hasRootNode = true;
				continue;
			}
			name = (String) PubLib.getObjFieldValue(obj, itemName);
			code = PubLib.getObjFieldValue(obj, itemCode);
			if (this.getItemIds().contains(code)) {
				continue;
			}
			if (firstObj == null) {
				firstObj = code;
			}
			addItem(code).getItemProperty(itemName).setValue(name);
		}
	}
}
