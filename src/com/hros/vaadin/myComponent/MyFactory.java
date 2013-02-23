package com.hros.vaadin.myComponent;

import java.util.HashMap;
import java.util.Map;

import com.hros.bas.pubLib.PubLib;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextArea;

/**
 * �ؽ�Form��fieldFactory
 * @author pb
 */
@SuppressWarnings("serial")
public class MyFactory extends DefaultFieldFactory {
	Map<String, FieldAttr> fieldMap = new HashMap<String, FieldAttr>();
	
	final String DEF_FIELD_WIDTH = "12em";
	
	public MyFactory(Map<String, FieldAttr> map) {
		this.fieldMap = map;
	}
	
	@Override
	public Field createField(Item item, Object propertyId,
            Component uiContext){
		Field f = super.createField(item, propertyId, uiContext);
		FieldAttr fieldAttr = fieldMap.get(propertyId);
		if (fieldAttr != null) {
			if (fieldAttr.getFieldType() != "") {
				f = createFieldByType(fieldAttr.getFieldType());
			}
			if (fieldAttr.getFieldCName() != "") {
				f.setCaption(fieldAttr.getFieldCName());
			}
			if (fieldAttr.getiWidth() > 0) {
				f.setWidth(fieldAttr.getiWidth()+"px");
			} else {
				f.setWidth(DEF_FIELD_WIDTH);
			}
		}
		return f;
	}
	
	/**
	 * ����������������Field
	 * @param object
	 * @return
	 */
	private Field createFieldByType(Object object) {
		if (!String.class.equals(object.getClass())) {
			return (Field)object;
		} else if ("password".equals(object)) {
			return new PasswordField();
		} else if ("textArea".equals(object)) {
			return txtRemark();
		} else if (object.toString().indexOf("MyDictComboBox")>-1) {
			return myDictComboBox(object.toString());
		} else {
			return (Field)object;
		}
	}
	
	/**
	 * �����Ҫmydictcombobox���͵������б�
	 * ָ��fieldTypeΪ��MyDictComboBox,caption,007,false��
	 * ���������ֱ�Ϊfield��caption����Ҫɾѡ�����͡��Ƿ���Ҫ���ڵ�
	 * @param fieldType
	 * @return
	 */
	private MyDictComboBox myDictComboBox(String fieldType) {
		String[] s = fieldType.split(",");
		boolean b = Boolean.parseBoolean(s[3]);
		return new MyDictComboBox(s[1], s[2], b);
	}
	
	private TextArea txtRemark() {
		TextArea remark = new TextArea();
		remark.setImmediate(true);
		remark.setRows(3);
		return remark;
	}
}
