package com.hros.vaadin.myComponent;

/**
 * 设置form的field属性
 * @author pb
 */
public class FieldAttr {
		//对应的类中的属性
		String fieldName;
		//显示的中文名
		String fieldCName = "";
		//宽度
		int iWidth = 0;
		//创建控件的类型
		Object fieldType = "";
		//是否必填
		Boolean required = false;
		//错误信息
		String requiredError = "";
		//是否只读
		Boolean readOnly = false;
		
		public FieldAttr() {
			
		}
		
		public FieldAttr(String fieldCName, Object fieldType, int iWidth) {
			this.fieldCName = fieldCName;
			this.fieldType = fieldType;
			this.iWidth = iWidth;
		}
		
		public FieldAttr(String fieldName, String fieldCName, Object fieldType, 
				int iWidth, Boolean required, String requiredError, Boolean readOnly) {
			this.fieldName = fieldName;
			this.fieldCName = fieldCName;
			this.fieldType = fieldType;
			this.iWidth = iWidth;
			this.required = required;
			this.requiredError = requiredError;
			this.readOnly = readOnly;
		}
		
		public String getFieldName() {
			return fieldName;
		}
		
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		
		public String getFieldCName() {
			return fieldCName;
		}
		
		public void setFieldCName(String fieldCName) {
			this.fieldCName = fieldCName;
		}
		
		public Boolean getRequired() {
			return required;
		}
		
		public void setRequired(Boolean required) {
			this.required = required;
		}
		
		public String getRequiredError() {
			return requiredError;
		}
		
		public void setRequiredError(String requiredError) {
			this.requiredError = requiredError;
		}
		
		public Boolean getReadOnly() {
			return readOnly;
		}
		
		public void setReadOnly(Boolean readOnly) {
			this.readOnly = readOnly;
		}

		public int getiWidth() {
			return iWidth;
		}

		public void setiWidth(int iWidth) {
			this.iWidth = iWidth;
		}

		public Object getFieldType() {
			return fieldType;
		}

		public void setFieldType(Object fieldType) {
			this.fieldType = fieldType;
		}
	}