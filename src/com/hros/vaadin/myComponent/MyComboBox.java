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
	 * 创建一个COMBBOX
	 * @param caption	标题
	 * @param dataList	需要加载的LIST
	 * @param itemCode	实际值(list的OBJ中的对象属性)
	 * @param itemName	显示的值(list的OBJ中的对象属性)
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
		//默认选择第一个
		if (this.getValue() != null) {
			this.select(this.getValue());
		} else {
			this.select(firstObj);
		}
	}
	
	//加载数据
	public void loadList(List dataList) {
		this.addContainerProperty(itemName, String.class, "");
		this.setItemCaptionPropertyId(itemName);
		Object code = null;
		String name = "";
		for (Object obj: dataList) {
			//没有第一个根节点
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
