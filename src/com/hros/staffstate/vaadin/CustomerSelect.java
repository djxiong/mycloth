package com.hros.staffstate.vaadin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.customer.domain.Customer;
import com.hros.customer.service.CustomerService;
import com.hros.staffstate.service.StaffStateService;
import com.hros.staffstate.staffstatecomponent.MyTable;
import com.hros.staffstate.vaadin.NewLayout.Dict;
import com.hros.vaadin.SpringContextHelper;
import com.hros.vaadin.myComponent.MyDictComboBox;
import com.hros.vaadin.myComponent.MyGeneratorColumn;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class CustomerSelect extends Window {

	private VerticalLayout verticalLayout;
	private HorizontalLayout horizontalLayout;
	private HorizontalLayout hLayout;
	private VerticalLayout vLayout;
	private TextField txtCustomerName;
	private MyDictComboBox cbCustomerType;
	private MyDictComboBox cbCustomerCity;
	private MyDictComboBox cbCustomerAttr;
	private MyDictComboBox cbCustomerIndustry;
	private MyTable custTable;
	private Button queryButton;
	private Button close;
	StaffStateService staffStateService;

	List<String> customerList;
	public CustomerSelect() {
		setCaption("选择客户");
		setModal(true);
		setWidth("600px");
		setHeight("600px");
		addComponent(buildVerticalLayout());
	}
	CustomerService customerService;
	private VerticalLayout buildVerticalLayout() {
		verticalLayout = new VerticalLayout();

		verticalLayout.addComponent(buildVHorizontalLayout());
		verticalLayout.addComponent(buildHorLayout());
		verticalLayout.addComponent(bLayout());
		return verticalLayout;

	}
	@Override
	public void attach() {
		super.attach();
		SpringContextHelper sch=new SpringContextHelper(this.getApplication());
		staffStateService=(StaffStateService) sch.getBean("staffStateServiceImpl");
		customerService = (CustomerService) sch.getBean("customerServiceImpl");
	}
	private HorizontalLayout buildVHorizontalLayout() {
		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(true,true,false,true);
		horizontalLayout.setSpacing(true);
		cbCustomerCity = new MyDictComboBox("所在城市", "005");
		cbCustomerAttr = new MyDictComboBox("公司性质", "002");
		cbCustomerType = new MyDictComboBox("客户类型", "003");
		horizontalLayout.addComponent(cbCustomerCity);
		horizontalLayout.addComponent(cbCustomerAttr);
		horizontalLayout.addComponent(cbCustomerType);

		return horizontalLayout;

	}
	
	private HorizontalLayout buildHorLayout() {
		hLayout = new HorizontalLayout();
		hLayout.setMargin(false,true,true,true);
		hLayout.setSpacing(true);
		cbCustomerIndustry = new MyDictComboBox("所属行业", "004");
		txtCustomerName = new TextField("客户名称");
		txtCustomerName.setWidth("165px");
		queryButton = new Button("查询");
		hLayout.addComponent(cbCustomerIndustry);
		hLayout.addComponent(txtCustomerName);
		hLayout.addComponent(queryButton);
		hLayout.setComponentAlignment(queryButton, Alignment.BOTTOM_CENTER);
		queryButton.addListener(ClickEvent.class, this, "queryButton");
		return hLayout;

	}

	
	public void queryButton(ClickEvent event) {
		custTable.removeAllItems();
		List<Customer> list=staffStateService.selectCustomer(getMap());
		custTable.setItems(list);
	}
	
	private Map<String,Object> getMap(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("custCity", cbCustomerCity.getValue());
		map.put("custAttr", cbCustomerAttr.getValue());
		map.put("custType", cbCustomerType.getValue());
		map.put("industry", cbCustomerIndustry.getValue());
		map.put("custName", txtCustomerName.getValue());
		return map;
		
	}

	private VerticalLayout bLayout() {
		vLayout = new VerticalLayout();
		close = new Button("关闭");
		vLayout.addComponent(buidlCustTable());
		vLayout.addComponent(close);
		vLayout.setComponentAlignment(close, Alignment.BOTTOM_CENTER);
		close.addListener(ClickEvent.class, this, "close");
		return vLayout;

	}

	public void close(ClickEvent event) {
		getParent().removeWindow(getWindow());

		
	}
	
	private MyTable buidlCustTable(){
		BeanItemContainer<Customer> custBean=new BeanItemContainer<Customer>(Customer.class);
		Object obj[] = { "custCode", "custName", "industry", "custClass",
				"custAttr", "custCity", "custType", "remark" };
		String str[] = { "编码", "名称", "行业", "客户等级", "公司性质", "所在地区", "客户类型", "备注" };
		custTable=new MyTable();
		custTable.setHeight("360px");
		custTable.setDateSource(custBean);
		buildTableGeneratedColumn();
		custTable.setColumns(obj);
		custTable.setHeader(str);
		custTable.addListener(ValueChangeEvent.class, this, "getCustomer");
		return custTable;
		
	}
	//获取行值
	public void getCustomer(ValueChangeEvent event){
		if(custTable.getValue()==null){return;}
		Entry.customer=(Customer) custTable.getValue();
		Entry.customerForm.setValue(Entry.customer);
			}
	//创建客户table特殊列
	private void buildTableGeneratedColumn(){
		custTable.addGeneratedColumn("custType", new MyGeneratorColumn(Dict.class));
		custTable.addGeneratedColumn("custCity", new MyGeneratorColumn(Dict.class));
		custTable.addGeneratedColumn("custAttr", new MyGeneratorColumn(Dict.class));
		custTable.addGeneratedColumn("industry", new MyGeneratorColumn(Dict.class));
	}
	
	
}
