package com.hros.customer.vaadin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.bas.domain.DictInfo;
import com.hros.bas.service.DictService;
import com.hros.customer.domain.Customer;
import com.hros.customer.domain.CustomerContactPerson;
import com.hros.customer.service.CustomerContactPersonService;
import com.hros.customer.service.CustomerService;
import com.hros.servicefee.service.impl.ServiceFeeImpl;
import com.hros.vaadin.SpringContextHelper;
import com.hros.vaadin.myComponent.FieldAttr;
import com.hros.vaadin.myComponent.MyComboBox;
import com.hros.vaadin.myComponent.MyDictComboBox;
import com.hros.vaadin.myComponent.MyFactory;
import com.hros.vaadin.myComponent.MyForm;
import com.hros.vaadin.myComponent.MyGeneratorColumn;
import com.hros.vaadin.myComponent.MyServiceFeeComboBox;
import com.hros.vaadin.myComponent.MyTable;
import com.hros.vaadin.myComponent.MyTreeTable;
import com.sun.net.httpserver.Headers;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class CustomerForm extends CustomComponent {

	@AutoGenerated
	private VerticalLayout mainLayout;
	
	private HorizontalLayout topSearchLayout;
	
	private Button btnSearch;
	
	private TextField txtCustomerName;
	
	private MyDictComboBox cbCustomerType;
	
	private MyDictComboBox cbCustomerCity;
	
	private MyDictComboBox cbCustomerAttr;
	
	private MyDictComboBox cbCustomerIndustry;
	
	private HorizontalSplitPanel middleLayout;
	
	private TabSheet tsCustomer;
	
	private VerticalLayout tsTabCustomer;
	
	private MyTable tbCustomer;
	
	private HorizontalLayout buttonCustomerLayout;
	
	private Button btnAddCustomer;
	
	private Button btnUpdateCustomer;
	
	private Button btnDeleteCustomer;
	
	private CustomerMyForm fmCustomer;
	
	private MyDictComboBox cbfmCustomerType;
	
	private MyDictComboBox cbfmCustomerCity;
	
	private MyDictComboBox cbfmCustomerAttr;
	
	private MyDictComboBox cbfmCustomerIndustry;
	
	private HorizontalLayout tsTabCustomerContactPerson;
	
	private MyTable tbCustomerContactPerson;
	
	private HorizontalLayout buttonCustomerContactPersonLayout;
	
	private Button btnAddCustomerContactPerson;
	
	private Button btnDeleteCustomerContactPerson;
	
	private MyForm fmCustomerContactPerson;
	
	private CustomerService customerService;
	
	private static Map<String, DictInfo> dictMap;
	
	private CustomerContactPersonService customerContactPersonService;
	
	private int customerId;
	
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CustomerForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private void buildMainLayout() {
		// the main layout and components will be created here
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setSizeFull();
		mainLayout.addComponent(buildTopSearchLayout());
		mainLayout.addComponent(buildMiddleLayout());
		mainLayout.setExpandRatio(middleLayout, (float) 1.0);
		
		this.setSizeFull();
	}
	
	@Override
	public void attach() {
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		customerService = (CustomerService) help.getBean("customerServiceImpl");
		DictService dictService = (DictService) help.getBean("dictServiceImpl");
		dictMap = dictService.getAllDict();
		customerContactPersonService = (CustomerContactPersonService) help.getBean("customerContactPersonServiceImpl");
	}
	
	//筛选工具栏
	private HorizontalLayout buildTopSearchLayout() {
		topSearchLayout = new HorizontalLayout();
		topSearchLayout.setImmediate(false);
		btnSearch = new Button("查询");
		txtCustomerName = new TextField("客户名称");
		cbCustomerCity = new MyDictComboBox("所在城市", "005");
		cbCustomerAttr = new MyDictComboBox("公司性质", "002");
		cbCustomerType = new MyDictComboBox("客户类型", "003");
		cbCustomerIndustry = new MyDictComboBox("所属行业", "004");
		topSearchLayout.addComponent(btnSearch);
		topSearchLayout.setMargin(true);
		topSearchLayout.setSpacing(true);
		topSearchLayout.addComponent(txtCustomerName);
		topSearchLayout.addComponent(cbCustomerCity);
		topSearchLayout.addComponent(cbCustomerAttr);
		topSearchLayout.addComponent(cbCustomerType);
		topSearchLayout.addComponent(cbCustomerIndustry);
		
		btnSearch.addListener(ClickEvent.class, this, "btnSearch");
		return topSearchLayout;
	}
	
	public void btnSearch(ClickEvent event) {
		tbCustomer.removeAllItems();
		List list = customerService.selectCustomer(getFilterMap());
		tbCustomer.addItems(list);
	}
	
	private Map getFilterMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("custAttr", cbCustomerAttr.getValue());
		map.put("custCity", cbCustomerCity.getValue());
		map.put("custType", cbCustomerType.getValue());
		map.put("custCode", txtCustomerName.getValue());
		return map;
	}
	
	private HorizontalSplitPanel buildMiddleLayout() {
		middleLayout = new HorizontalSplitPanel();
		middleLayout.setImmediate(false);
		middleLayout.setSizeFull();
		middleLayout.setMargin(false,true,true,true);
		middleLayout.addComponent(buildTbCustomer());
		middleLayout.addComponent(buildTsCustomer());
		middleLayout.setSplitPosition(30);
		return middleLayout;
	}
	
	//客户列表
	private MyTable buildTbCustomer() {
		tbCustomer = new MyTable();
		tbCustomer.setSizeFull();
		tbCustomer.setBeanItem(Customer.class);
		String cols = "custCode,custName,custLegalPerson,address," +
				"phone,industry,custAttr,custCity,custType,remark";
		tbCustomer.setVisibleColumns(cols.split(","));
		String headers = "编码,名称,负责人,地址,座机,行业,公司性质,所在地区,客户类型,备注";
		tbCustomer.setColumnHeaders(headers.split(","));
		buildTableGeneratedColumn();
		tbCustomer.addListener(ValueChangeEvent.class, this, "valueChage");
		return tbCustomer;
	}
	
	//构建TABLE的特殊列
	private void buildTableGeneratedColumn() {
		tbCustomer.addGeneratedColumn("custType", 
				new MyGeneratorColumn(dictLabel.class));
		tbCustomer.addGeneratedColumn("custCity", 
				new MyGeneratorColumn(dictLabel.class));
		tbCustomer.addGeneratedColumn("custAttr", 
				new MyGeneratorColumn(dictLabel.class));
		tbCustomer.addGeneratedColumn("industry", 
				new MyGeneratorColumn(dictLabel.class));
	}
	
	//将customer中字段的编码转换为对应数据字典中的名称
	public static class dictLabel extends Label {
		public dictLabel(Table source, Object itemId, Object columnId) {
			Item item = source.getItem(itemId);
			String s = (String) item.getItemProperty(columnId).getValue();
			if (dictMap.containsKey(s)) {
				String name = dictMap.get(s).getDictName();
				setPropertyDataSource(new ObjectProperty<String>(name, String.class));
		        setContentMode(CONTENT_DEFAULT);
		        setWidth(100, UNITS_PERCENTAGE);
			}
		}
	}
	
	public void valueChage(ValueChangeEvent event) {
		Item item = tbCustomer.getItem(tbCustomer.getValue());
		if (item != fmCustomer.getValue()) {
			fmCustomer.setValue(item);
			customerId = (Integer) item.getItemProperty("custID").getValue();
			List list = customerContactPersonService.selectCustomerContactPerson(customerId);
			tbCustomerContactPerson.removeAllItems();
			tbCustomerContactPerson.addItems(list);
			if (tbCustomerContactPerson.getItemIds().size() == 0) {
				fmCustomerContactPerson.setValue(new CustomerContactPerson());
			}
		}
	}
	
	private TabSheet buildTsCustomer() {
		tsCustomer = new TabSheet();
		tsCustomer.setSizeFull();
		tsCustomer.addTab(buildTsTabCustomer(), "客户详细信息");
		tsCustomer.addTab(buildTsTabCustomerContactPerson(), "联系人信息");
		return tsCustomer;
	}
	
	//客户详细信息TAB页
	private VerticalLayout buildTsTabCustomer() {
		tsTabCustomer = new VerticalLayout();
		tsTabCustomer.setMargin(true);
		tsTabCustomer.setSpacing(true);
		tsTabCustomer.addComponent(buildButtonCustomerLayout());
		tsTabCustomer.addComponent(buildFmCustomer());
		return tsTabCustomer;
	}
	
	//客户信息操作按钮
	private HorizontalLayout buildButtonCustomerLayout() {
		buttonCustomerLayout = new HorizontalLayout();
		buttonCustomerLayout.setImmediate(false);
		buttonCustomerLayout.setSpacing(true);
		btnAddCustomer = new Button("新增");
		btnUpdateCustomer = new Button("修改");
		btnDeleteCustomer = new Button("删除");
		buttonCustomerLayout.addComponent(btnAddCustomer);
		buttonCustomerLayout.addComponent(btnUpdateCustomer);
		buttonCustomerLayout.addComponent(btnDeleteCustomer);
		btnAddCustomer.addListener(ClickEvent.class, this, "btnAddCustomer");
		btnDeleteCustomer.addListener(ClickEvent.class, this, "btnDeleteCustomer");
		return buttonCustomerLayout;
	}
	
	public void btnAddCustomer(ClickEvent event) {
		tbCustomer.addNewItem(new Customer());
	}
	
	public void btnDeleteCustomer(ClickEvent event) {
		Customer obj = (Customer) tbCustomer.getValue();
		tbCustomer.deleteItem();
		if (obj.getCustID() != 0) {
			customerService.deleteCustomer(obj.getCustID());
		}
	}
	
	//客户详情FORM
	private MyForm buildFmCustomer() {
		fmCustomer = new CustomerMyForm();
		fmCustomer.setSizeFull();
		fmCustomer.setItemDataSource(new Customer());
		String cols = "custCode,custName,custLegalPerson,address," +
				"phone,industry,custAttr,custCity,custType,remark," +
				"serviceFeeID,wholeMonthAccount";
		fmCustomer.setVisibleItemProperties(cols.split(","));
		fmCustomer.setFormFieldFactory(new MyFactory(getFactoryMap()));
		fmCustomer.setValue(new Customer());
		fmCustomer.createBtnFoot();
		fmCustomer.getBtnOk().addListener(ClickEvent.class, this, "saveCustomer");
		fmCustomer.getBtnCancel().addListener(ClickEvent.class, this, "cancelCustomer");
		return fmCustomer;
	}
	
	//customerForm保存按钮
	public void saveCustomer(ClickEvent event) {
		fmCustomer.commit();
		customerService.saveCustomer((Customer)tbCustomer.getValue());
	}
	
	public void cancelCustomer(ClickEvent event) {
		fmCustomer.discard();
	}
	
	//customerForm的字段
	private Map<String, FieldAttr> getFactoryMap() {
		cbfmCustomerType = new MyDictComboBox("客户类型", "003");
		cbfmCustomerAttr = new MyDictComboBox("公司性质", "002");
		cbfmCustomerCity = new MyDictComboBox("所在地区", "005");
		cbfmCustomerIndustry = new MyDictComboBox("所属行业", "004");
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("custCode", new FieldAttr("编码", "", 0));
		map.put("custName", new FieldAttr("名称", "", 0));
		map.put("custLegalPerson", new FieldAttr("负责人", "", 0));
		map.put("address", new FieldAttr("地址", "", 0));
		map.put("phone", new FieldAttr("座机", "", 0));
		map.put("industry", new FieldAttr("所属行业", cbfmCustomerIndustry, 0));
		map.put("custClass", new FieldAttr("客户等级", "", 0));
		map.put("custAttr", new FieldAttr("公司性质", cbfmCustomerAttr, 0));
		map.put("custCity", new FieldAttr("所在地区", cbfmCustomerCity, 0));
		map.put("custType", new FieldAttr("客户类型", cbfmCustomerType, 0));
		map.put("remark", new FieldAttr("备注", "textArea", 0));
		map.put("serviceFeeID", new FieldAttr("服务费类型", 
				new MyServiceFeeComboBox("服务费类型", "serviceFeeID","serviceFeeName"), 0));
		map.put("wholeMonthAccount", new FieldAttr("基本服务费", "", 0));
		return map;
	}
	
	//联系人TAB页
	private HorizontalLayout buildTsTabCustomerContactPerson() {
		tsTabCustomerContactPerson = new HorizontalLayout();
		tsTabCustomerContactPerson.setSizeFull();
		fmCustomerContactPerson = new MyForm();
		tsTabCustomerContactPerson.addComponent(buildTabCustomerContactPerson());
		tsTabCustomerContactPerson.addComponent(buildCustomerContactPersonLayout());
		return tsTabCustomerContactPerson;
	}
	
	/**联系人列表*/
	private MyTable buildTabCustomerContactPerson() {
		tbCustomerContactPerson = new MyTable();
		tbCustomerContactPerson.setSizeFull();
		tbCustomerContactPerson.setBeanItem(CustomerContactPerson.class);
		String cols = "contactCode,contactName";
		tbCustomerContactPerson.setVisibleColumns(cols.split(","));
		String headers = "编码,姓名";
		tbCustomerContactPerson.setColumnHeaders(headers.split(","));
		tbCustomerContactPerson.addListener(ValueChangeEvent.class, this, "customerContactPersonValueChage");
		return tbCustomerContactPerson;
	}
	
	public void customerContactPersonValueChage(ValueChangeEvent event) {
		Item item = tbCustomerContactPerson.getItem(tbCustomerContactPerson.getValue());
		if (item != fmCustomerContactPerson.getValue()) {
			fmCustomerContactPerson.setValue(item);
		}
	}
	
	private VerticalLayout buildCustomerContactPersonLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		layout.addComponent(buildButtonCustomerContactPersonLayout());
		layout.addComponent(buildFmCustomerContactPerson());
		return layout;
	}
	
	/**联系人按钮*/
	private HorizontalLayout buildButtonCustomerContactPersonLayout() {
		buttonCustomerContactPersonLayout = new HorizontalLayout();
		btnAddCustomerContactPerson = new Button("添加联系人");
		btnDeleteCustomerContactPerson = new Button("删除联系人");
		buttonCustomerContactPersonLayout.addComponent(btnAddCustomerContactPerson);
		buttonCustomerContactPersonLayout.addComponent(btnDeleteCustomerContactPerson);
		btnAddCustomerContactPerson.addListener(ClickEvent.class, this, "addCustomerContactPerson");
		btnDeleteCustomerContactPerson.addListener(ClickEvent.class, this, "deleteCustomerContactPerson");
		return buttonCustomerContactPersonLayout;
	}
	
	public void addCustomerContactPerson(ClickEvent event) {
		CustomerContactPerson p = new CustomerContactPerson();
		p.setCustID(customerId);
		tbCustomerContactPerson.addNewItem(p);
	}
	
	public void deleteCustomerContactPerson(ClickEvent event) {
		CustomerContactPerson obj = (CustomerContactPerson) tbCustomerContactPerson.getValue();
		tbCustomerContactPerson.deleteItem();
		if (obj.getContactID() != 0) {
			customerContactPersonService.deleteCustomerContactPerson(obj.getContactID());
		}
	}
	
	/**联系人FORM*/
	private MyForm buildFmCustomerContactPerson() {
		fmCustomerContactPerson = new MyForm();
		fmCustomerContactPerson.setSizeFull();
		fmCustomerContactPerson.setItemDataSource(new CustomerContactPerson());
		String cols = "contactCode,contactName,contactSex,phone," +
				"email,address,dept,pos,mobilePhone";
		fmCustomerContactPerson.setVisibleItemProperties(cols.split(","));
		fmCustomerContactPerson.setFormFieldFactory(new MyFactory(getContactFactoryMap()));
		fmCustomerContactPerson.setValue(new Customer());
		fmCustomerContactPerson.createBtnFoot();
		fmCustomerContactPerson.getBtnOk().addListener(ClickEvent.class, this, "saveCustomerContactPerson");
		fmCustomerContactPerson.getBtnCancel().addListener(ClickEvent.class, this, "cancelCustomerContactPerson");
		return fmCustomerContactPerson;
	}
	
	public void saveCustomerContactPerson() {
		fmCustomerContactPerson.commit();
		customerContactPersonService.saveCustomerContactPerson((CustomerContactPerson) tbCustomerContactPerson.getValue());
	}
	
	public void cancelCustomerContactPerson() {
		fmCustomerContactPerson.discard();
	}
	
	private Map<String, FieldAttr> getContactFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("contactCode", new FieldAttr("编码", "", 0));
		map.put("contactName", new FieldAttr("名称", "", 0));
		map.put("contactSex", new FieldAttr("负责人", "", 0));
		map.put("phone", new FieldAttr("座机", "", 0));
		map.put("email", new FieldAttr("email", "", 0));
		map.put("address", new FieldAttr("地址", "", 0));
		map.put("dept", new FieldAttr("部门", "", 0));
		map.put("pos", new FieldAttr("职位", "", 0));
		map.put("mobilePhone", new FieldAttr("手机", "", 0));
		return map;
	}
	
}
