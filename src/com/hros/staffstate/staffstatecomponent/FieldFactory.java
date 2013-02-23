package com.hros.staffstate.staffstatecomponent;

import com.hros.customer.domain.Customer;
import com.hros.vaadin.myComponent.MyDictComboBox;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class FieldFactory extends DefaultFieldFactory {

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		BeanItem beanItem = (BeanItem) item;
		String cust=Customer.class.toString().substring(31);
		String itemCust=beanItem.getBean().getClass().getName().substring(25);
		// TODO Auto-generated method stub
		Field f = super.createField(item, propertyId, uiContext);
		
		TextField tf = null;
		if ("staffName".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("����");
			tf.setWidth("165px");
		} else if ("staffSex".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("�Ա�");
			tf.setWidth("165px");
		} else if ("identityCard".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("���֤");
			tf.setWidth("165px");
		} else if ("phone".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("�绰");
			tf.setWidth("165px");
		} else if ("address".equals(propertyId)) {
			tf = (TextField) f;
			if(cust.equals(itemCust)){
				tf.setCaption("��ַ");
			}else {
				tf.setCaption("סַ");
			}
			
			tf.setWidth("165px");
		} else if ("homeAddress".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("�������ڵ�");
			tf.setWidth("165px");
		} else if ("homePhone".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��ͥ�绰");
			tf.setWidth("165px");
		} else if ("state".equals(propertyId)) {
			f = new MyDictComboBox("״̬", "006");
		} else if ("entryDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ְʱ��");
		} else if ("agreeSignedDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ͬǩ��ʱ��");
		} else if ("agreeExpireDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ͬ����ʱ��");
		} else if ("toPostDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("����ʱ��");
		} else if ("probation".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("������");
		} else if ("jobCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("����");
			tf.setWidth("165px");
		} else if ("post".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��λ");
			tf.setWidth("165px");
		} else if ("insuranceID".equals(propertyId)){
			f=new InsuranceComboBox("�籣");
		} else if ("serviceFeeID".equals(propertyId)) {
			f=new ServiceFeeComboBox("�����");
		} else if ("joinInsuranceDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("�α�ʱ��");
		} else if ("insurancelInDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("�籣��Чʱ��");
		} else if ("insurancelOutDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("�籣����ʱ��");
		} else if ("agreeRenewDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ͬ��ǩʱ��");
		} else if ("serviceFeeDelay".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("�������Ч�ӳ�ʱ��");
			tf.setWidth("165px");
		} else if ("quitApplayDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ְ����ʱ��");
		} else if ("livePostDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("���ʱ��");
		} else if ("quitDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��ְʱ��");
		} else if ("disInsuranceDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("ͣ��ʱ��");
		} else if ("custCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("����");
			tf.setWidth("165px");
		} else if ("custName".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��λ����");
			tf.setWidth("165px");
		} else if ("custLegalPerson".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("������");
			tf.setWidth("165px");
		} else if ("industry".equals(propertyId)) {
			f = new MyDictComboBox("������ҵ", "004");
		} else if ("custClass".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("�ͻ��ȼ�");
			tf.setWidth("165px");
		} else if ("custAttr".equals(propertyId)) {
			f = new MyDictComboBox("��˾����", "002");
		} else if ("custCity".equals(propertyId)) {
			f = new MyDictComboBox("���ڳ���", "005");
		} else if ("custType".equals(propertyId)) {
			f = new MyDictComboBox("�ͻ�����", "003");
		} else if ("fileLocation".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("����λ��");
			tf.setWidth("165px");
		} else if ("fileName".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��������");
			tf.setWidth("165px");
		} else if ("fileCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��������");
			tf.setWidth("165px");
		} else if ("fileType".equals(propertyId)) {

			f = new MyDictComboBox("��������", "008");
		} else if ("fileDate".equals(propertyId)) {
		    f = createPopupDateField();
			f.setCaption("��дʱ��");
		} else if ("fileUserID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��д��");
			tf.setWidth("165px");
		} else if ("fileOutDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("��Чʱ��");
		} else if ("fileManagerID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("��������Ա");
			tf.setWidth("165px");
		} else if ("fileExamineID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("���Ա");
			tf.setWidth("165px");
		} else if ("electronicFile".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("���ӵ�");
			tf.setWidth("165px");
		} else if ("scanningElement".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("ɨ���");
			tf.setWidth("165px");
		} else if ("auditState".equals(propertyId)) {
			f = new MyDictComboBox("���״̬", "007");
		} else if ("recUserId".equals(propertyId)) {
			f=new RecCostComboBox("��Ƹ��Ա");
		} else if ("costStartDate".equals(propertyId)) {
			f=createPopupDateField();
			f.setCaption("���ѿ�ʼʱ��");
		} else if ("recId".equals(propertyId)) {
			f=new RecComboBox("���ѷ�ʽ");
		}
		return f;
	}

	private PopupDateField createPopupDateField() {
		PopupDateField pd = new PopupDateField();
		pd.setResolution(PopupDateField.RESOLUTION_DAY);
		pd.setWidth("165px");
		return pd;

	}

}
