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
			tf.setCaption("姓名");
			tf.setWidth("165px");
		} else if ("staffSex".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("性别");
			tf.setWidth("165px");
		} else if ("identityCard".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("身份证");
			tf.setWidth("165px");
		} else if ("phone".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("电话");
			tf.setWidth("165px");
		} else if ("address".equals(propertyId)) {
			tf = (TextField) f;
			if(cust.equals(itemCust)){
				tf.setCaption("地址");
			}else {
				tf.setCaption("住址");
			}
			
			tf.setWidth("165px");
		} else if ("homeAddress".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("户口所在地");
			tf.setWidth("165px");
		} else if ("homePhone".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("家庭电话");
			tf.setWidth("165px");
		} else if ("state".equals(propertyId)) {
			f = new MyDictComboBox("状态", "006");
		} else if ("entryDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("入职时间");
		} else if ("agreeSignedDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("合同签订时间");
		} else if ("agreeExpireDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("合同到期时间");
		} else if ("toPostDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("到岗时间");
		} else if ("probation".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("试用期");
		} else if ("jobCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("工号");
			tf.setWidth("165px");
		} else if ("post".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("岗位");
			tf.setWidth("165px");
		} else if ("insuranceID".equals(propertyId)){
			f=new InsuranceComboBox("社保");
		} else if ("serviceFeeID".equals(propertyId)) {
			f=new ServiceFeeComboBox("服务费");
		} else if ("joinInsuranceDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("参保时间");
		} else if ("insurancelInDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("社保生效时间");
		} else if ("insurancelOutDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("社保过期时间");
		} else if ("agreeRenewDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("合同续签时间");
		} else if ("serviceFeeDelay".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("服务费生效延迟时间");
			tf.setWidth("165px");
		} else if ("quitApplayDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("离职申请时间");
		} else if ("livePostDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("离岗时间");
		} else if ("quitDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("离职时间");
		} else if ("disInsuranceDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("停保时间");
		} else if ("custCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("编码");
			tf.setWidth("165px");
		} else if ("custName".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("单位名称");
			tf.setWidth("165px");
		} else if ("custLegalPerson".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("负责人");
			tf.setWidth("165px");
		} else if ("industry".equals(propertyId)) {
			f = new MyDictComboBox("所属行业", "004");
		} else if ("custClass".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("客户等级");
			tf.setWidth("165px");
		} else if ("custAttr".equals(propertyId)) {
			f = new MyDictComboBox("公司性质", "002");
		} else if ("custCity".equals(propertyId)) {
			f = new MyDictComboBox("所在城市", "005");
		} else if ("custType".equals(propertyId)) {
			f = new MyDictComboBox("客户类型", "003");
		} else if ("fileLocation".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("档案位置");
			tf.setWidth("165px");
		} else if ("fileName".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("档案名称");
			tf.setWidth("165px");
		} else if ("fileCode".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("档案编码");
			tf.setWidth("165px");
		} else if ("fileType".equals(propertyId)) {

			f = new MyDictComboBox("档案类型", "008");
		} else if ("fileDate".equals(propertyId)) {
		    f = createPopupDateField();
			f.setCaption("编写时间");
		} else if ("fileUserID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("编写人");
			tf.setWidth("165px");
		} else if ("fileOutDate".equals(propertyId)) {
			f = createPopupDateField();
			f.setCaption("有效时间");
		} else if ("fileManagerID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("档案管理员");
			tf.setWidth("165px");
		} else if ("fileExamineID".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("审核员");
			tf.setWidth("165px");
		} else if ("electronicFile".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("电子档");
			tf.setWidth("165px");
		} else if ("scanningElement".equals(propertyId)) {
			tf = (TextField) f;
			tf.setCaption("扫描件");
			tf.setWidth("165px");
		} else if ("auditState".equals(propertyId)) {
			f = new MyDictComboBox("审核状态", "007");
		} else if ("recUserId".equals(propertyId)) {
			f=new RecCostComboBox("招聘人员");
		} else if ("costStartDate".equals(propertyId)) {
			f=createPopupDateField();
			f.setCaption("付费开始时间");
		} else if ("recId".equals(propertyId)) {
			f=new RecComboBox("付费方式");
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
