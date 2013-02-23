package com.hros.cloth.vaadin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hros.bas.pubLib.PubUtil;
import com.hros.vaadin.myComponent.FieldAttr;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

@SuppressWarnings("serial")
public class ClothDataForm extends Form {
	private Button btnOk = new Button("保存");
	private Button btnCancel = new Button("取消");
	private Boolean hasDialog;
	private Map<String, FieldAttr> fieldMap = new HashMap<String, FieldAttr>();
		
	public ClothDataForm(){
		this.setWriteThrough(false);
		this.setInvalidCommitted(false);
		this.setImmediate(true);
	}
	
	public ClothDataForm(String s){
		this();
		setCaption(s);
	}
	
	public void setItemDataSource(Object obj) {
		BeanItem beanItem = new BeanItem(obj);
		this.setItemDataSource(beanItem);
	}
	
	//设置field的名称
	public void setFieldCaption(Object[] obj) {
		Iterator it = getVisibleItemProperties().iterator();
		int i = 0;
		while (it.hasNext()){
			getField(it.next()).setCaption(obj[i].toString());
			i++;
		}
	}
	
	//form下面的确定 取消按钮
	public void createBtnFoot(){
		btnOk.setIcon(new ThemeResource(PubUtil.RUNO_ICON_BTNOK));
		btnCancel.setIcon(new ThemeResource(PubUtil.RUNO_ICON_BTNCANCEL));
		
		HorizontalLayout foot = (HorizontalLayout) this.getFooter();
		foot.addComponent(btnOk);
		foot.addComponent(btnCancel);
		foot.setMargin(true, true, false, true);
		foot.setSpacing(true);
//		btnOk.addListener(ClickEvent.class, this, "btnClickEvent");
//		btnCancel.addListener(ClickEvent.class, this, "btnClickEvent");
	}
	
	
	public void btnClickEvent(ClickEvent event){
		if (event.getButton().getCaption().equals("确定")) {
			this.commit();
			this.getWindow().showNotification("保存成功！");
		} else if (event.getButton().getCaption().equals("取消")) {
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
