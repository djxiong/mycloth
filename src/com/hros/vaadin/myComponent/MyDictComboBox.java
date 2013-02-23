package com.hros.vaadin.myComponent;

import java.util.List;

import com.hros.bas.service.DictService;
import com.hros.bas.domain.DictInfo;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class MyDictComboBox extends ComboBox {
	
	String dictCode;
	
	DictService dictService;
	
	List<DictInfo> dictList;
	
	Object firstObj;
	
	final String CB_CAPTION = "name";
	
	boolean hasRootNode = true;
	
	public MyDictComboBox(String caption, String dictCode) {
		this.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		this.setImmediate(true);
		this.setNullSelectionAllowed(false);

		this.setCaption(caption);
		this.dictCode = dictCode;
	}
	
	public MyDictComboBox(String caption, String dictCode, boolean hasRootNode) {
		this(caption, dictCode);
		this.hasRootNode = hasRootNode;
	}
	
	@Override
	public void attach() {
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		dictService = (DictService) help.getBean("dictServiceImpl");
		dictList = dictService.selectDiceByCode(dictCode);
		loadDictList();
		if (this.getValue() != null) {
			this.select(this.getValue());
		} else {
			this.select(firstObj);
		}
	}

	//加载数据
	private void loadDictList() {
		this.addContainerProperty(CB_CAPTION, String.class, "");
		this.setItemCaptionPropertyId(CB_CAPTION);
		for (DictInfo dict:	dictList) {
			//没有第一个根节点
			if (!hasRootNode) {
				hasRootNode = true;
				continue;
			}
			if (firstObj == null) {
				firstObj = dict.getDictCode();
			}
			if (this.getItemIds().contains(dict.getDictCode())) {
				continue;
			}
			addItem(dict.getDictCode()).getItemProperty(CB_CAPTION)
				.setValue(dict.getDictName());
		}
	}
	
}
