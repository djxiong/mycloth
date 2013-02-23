package com.hros.vaadin.myComponent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hros.bas.pubLib.PubUtil;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.terminal.Sizeable;
import com.vaadin.terminal.ThemeResource;

@SuppressWarnings("serial")
public class MyForm extends Form {
	private Button btnOk = new Button("����");
	private Button btnCancel = new Button("ȡ��");
	private Boolean hasDialog;
	private Map<String, FieldAttr> fieldMap = new HashMap<String, FieldAttr>();
		
	public MyForm(){
		this.setWriteThrough(false);
		this.setInvalidCommitted(false);
		this.setImmediate(true);
	}
	
	public MyForm(String s){
		this();
		setCaption(s);
	}
	
	public void setItemDataSource(Object obj) {
		BeanItem beanItem = new BeanItem(obj);
		this.setItemDataSource(beanItem);
	}
	
	//����field������
	public void setFieldCaption(Object[] obj) {
		Iterator it = getVisibleItemProperties().iterator();
		int i = 0;
		while (it.hasNext()){
			getField(it.next()).setCaption(obj[i].toString());
			i++;
		}
	}
	
	//form�����ȷ�� ȡ����ť
	public void createBtnFoot(){
		btnOk.setIcon(new ThemeResource(PubUtil.RUNO_ICON_BTNOK));
		btnCancel.setIcon(new ThemeResource(PubUtil.RUNO_ICON_BTNCANCEL));
		
		HorizontalLayout foot = (HorizontalLayout) this.getFooter();
		foot.addComponent(btnOk);
		foot.addComponent(btnCancel);
		foot.setMargin(true, false, false, false);
		foot.setSpacing(true);
//		btnOk.addListener(ClickEvent.class, this, "btnClickEvent");
//		btnCancel.addListener(ClickEvent.class, this, "btnClickEvent");
	}
	
	
	public void btnClickEvent(ClickEvent event){
		if (event.getButton().getCaption().equals("ȷ��")) {
			this.commit();
			this.getWindow().showNotification("����ɹ���");
		} else if (event.getButton().getCaption().equals("ȡ��")) {
			this.setValue(null);
		}
	}
	
	public Button getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(Button btnOk) {
		this.btnOk = btnOk;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(Button btnCancel) {
		this.btnCancel = btnCancel;
	}

	public Boolean getHasDialog() {
		return hasDialog;
	}

	public void setHasDialog(Boolean hasDialog) {
		this.hasDialog = hasDialog;
	}

	public Map<String, FieldAttr> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Map<String, FieldAttr> fieldMap) {
		this.fieldMap = fieldMap;
	}
	
}
