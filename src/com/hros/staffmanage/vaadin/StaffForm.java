package com.hros.staffmanage.vaadin;

import java.util.HashMap;
import java.util.Map;

import com.hros.staffmanage.domain.StaffManage;
import com.hros.vaadin.myComponent.FieldAttr;
import com.hros.vaadin.myComponent.MyFactory;
import com.hros.vaadin.myComponent.MyForm;
import com.vaadin.ui.GridLayout;

@SuppressWarnings("serial")
public class StaffForm extends MyForm{
	
	private GridLayout gridLayout;
	
	public StaffForm() {
		gridLayout = new GridLayout();
		gridLayout.setColumns(2);
		gridLayout.setSpacing(true);
		gridLayout.setMargin(true);
		this.setLayout(gridLayout);
		String visibleColumns = "staffCode,staffName,staffSex,identityCard," +
				"address,phone,homeAddress,homePhone,state,age";
		this.setVisibleItemProperties(visibleColumns.split(","));
		this.setFormFieldFactory(new MyFactory(getFactoryMap()));
	}
	
	private Map<String, FieldAttr> getFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("staffCode", new FieldAttr("����","",0));
		map.put("staffName", new FieldAttr("����","",0));
		map.put("staffSex", new FieldAttr("�Ա�","",0));
		map.put("identityCard", new FieldAttr("���֤","",0));
		map.put("address", new FieldAttr("סַ","",0));
		map.put("phone", new FieldAttr("�绰","",0));
		map.put("homeAddress", new FieldAttr("��ͥסַ","",0));
		map.put("homePhone", new FieldAttr("��ͥ�绰","",0));
		map.put("state", new FieldAttr("��ְ״̬","",0));
		map.put("age", new FieldAttr("����","",0));
		return map;
	}
	
}
