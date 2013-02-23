package com.hros.cloth.vaadin;

import java.util.List;
import java.util.Map;

import com.hros.cloth.dao.ClothDao;
import com.hros.cloth.dao.Customer2Dao;
import com.hros.cloth.dao.OrderHistoryDao;
import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.service.ClothService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class OrderForm extends CustomComponent implements Button.ClickListener{

	@AutoGenerated
	private HorizontalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_form;
	@AutoGenerated
	private Table table_cloth;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_cloth_search;
	@AutoGenerated
	private Button button_order;
	@AutoGenerated
	private Button button_cloth_search;
	@AutoGenerated
	private TextField textField_cloth_barCode;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_form_buttons;
	@AutoGenerated
	private VerticalLayout verticalLayout_table;
	@AutoGenerated
	private Table table_customer;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_button;
	@AutoGenerated
	private Button button_customer_search;
	@AutoGenerated
	private TextField textField_customer_name;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */


	private ClothDao clothDao;
	private Customer2Dao customerDao;
	private OrderHistoryDao orderHistoryDao;
	private ClothService clothService;
	
	private static final String COMMON_FIELD_WIDTH = "12em";
	
	private Customer2 selectedCustomer;
	
	private Cloth selectedCloth;

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public OrderForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		
		table_customer.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
                // in multiselect mode, a Set of itemIds is returned,
                // in singleselect mode the itemId is returned directly
            	selectedCustomer = (Customer2)event.getProperty().getValue();
            	
            	if(selectedCustomer != null){
            		BeanItem<Customer2> customerBeanItem = new BeanItem<Customer2>(selectedCustomer);
            		
            		//formatCustomerBeanForm();
    			}
            }
        });
		table_customer.setSelectable(true);
		table_customer.setMultiSelect(false);
		table_customer.setImmediate(true); 
		
		table_cloth.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	selectedCloth = (Cloth)event.getProperty().getValue();
            }
        });
		table_cloth.setSelectable(true);
		table_cloth.setMultiSelect(false);
		table_cloth.setImmediate(true); 
		
		
		button_order.addListener(this);
		button_cloth_search.addListener(this);
		button_customer_search.addListener(this);
	}

	@Override
	public void attach(){
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		clothService = (ClothService) help.getBean("clothServiceImpl");
		clothDao = (ClothDao)help.getBean("clothDao");
		customerDao = (Customer2Dao)help.getBean("customer2Dao");
		orderHistoryDao = (OrderHistoryDao)help.getBean("orderHistoryDao");
		List<Customer2> customers = customerDao.getAllCustomers();
		populateCustomers(customers);
		List<Cloth> clothes = clothDao.getAllClothes();
		populateCloths(clothes);
		
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		
		//�����˿�
		if(event.getSource().equals(button_customer_search)){
			List<Customer2> foundCustomer = customerDao.findCustomersByName(textField_customer_name.getValue().toString());
			populateCustomers(foundCustomer);
		}
		//�����·�
		if(event.getSource().equals(button_cloth_search)){
			List<Cloth> foundCloths = clothDao.findClothsByBarCode(textField_cloth_barCode.getValue().toString());
			populateCloths(foundCloths);
		}
		
		//����ť
		if(event.getSource().equals(button_order)){
			if(selectedCloth == null ){
				getWindow().showNotification("��ѡ��һ���·�" ,"��ʾ");
				return;
			}
			if(selectedCloth.getCount() <= 0 ){
				getWindow().showNotification("��治��,�޷�����" ,"����",Notification.TYPE_ERROR_MESSAGE);
				return;
			}
			
			Window subWindow = new Window();
			subWindow.setModal(true);
			subWindow.setWidth("500px");
			OrderDialog orderDialog = new OrderDialog(selectedCloth,selectedCustomer);
			
			subWindow.addComponent(orderDialog);
			getWindow().addWindow(subWindow);
			
		}
		
	}	
	private void populateCustomers(List<Customer2> customers){
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("name", String.class,null);
		//List<Customer2> customers = customerDao.getAllCustomers();
		for(Customer2 customer:customers){
			 Item item = container.addItem(customer);
			 item.getItemProperty("name").setValue(customer.getName());
		}
		
		table_customer.setContainerDataSource(container);
		table_customer.setColumnHeaders(new String[] { "����"});
		table_customer.setVisibleColumns(new String[] { "name"});
		table_customer.setWidth("200px");
	}
	
	private void populateCloths(List<Cloth> clothes){
		table_cloth.setContainerDataSource(ClothUtil.getClothContainer(clothes));
		table_cloth.setColumnHeaders(ClothUtil.getClothTableColumnHeaders());
		table_cloth.setVisibleColumns(ClothUtil.getClothTableVisiableColumn());

		table_cloth.setWidth("400px");
	}
	
	
	
	
	@AutoGenerated
	private HorizontalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new HorizontalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// verticalLayout_table
		verticalLayout_table = buildVerticalLayout_table();
		mainLayout.addComponent(verticalLayout_table);
		
		// horizontalLayout_form_buttons
		horizontalLayout_form_buttons = new HorizontalLayout();
		horizontalLayout_form_buttons.setImmediate(false);
		horizontalLayout_form_buttons.setWidth("-1px");
		horizontalLayout_form_buttons.setHeight("-1px");
		horizontalLayout_form_buttons.setMargin(false);
		mainLayout.addComponent(horizontalLayout_form_buttons);
		
		// verticalLayout_form
		verticalLayout_form = buildVerticalLayout_form();
		mainLayout.addComponent(verticalLayout_form);
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_table() {
		// common part: create layout
		verticalLayout_table = new VerticalLayout();
		verticalLayout_table.setImmediate(false);
		verticalLayout_table.setWidth("-1px");
		verticalLayout_table.setHeight("-1px");
		verticalLayout_table.setMargin(false);
		
		// horizontalLayout_button
		horizontalLayout_button = buildHorizontalLayout_button();
		verticalLayout_table.addComponent(horizontalLayout_button);
		
		// table_customer
		table_customer = new Table();
		table_customer.setImmediate(false);
		table_customer.setWidth("-1px");
		table_customer.setHeight("-1px");
		verticalLayout_table.addComponent(table_customer);
		
		return verticalLayout_table;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_button() {
		// common part: create layout
		horizontalLayout_button = new HorizontalLayout();
		horizontalLayout_button.setImmediate(false);
		horizontalLayout_button.setWidth("-1px");
		horizontalLayout_button.setHeight("-1px");
		horizontalLayout_button.setMargin(false);
		
		// textField_customer_name
		textField_customer_name = new TextField();
		textField_customer_name.setCaption("�ͻ�����");
		textField_customer_name.setImmediate(false);
		textField_customer_name.setWidth("-1px");
		textField_customer_name.setHeight("-1px");
		textField_customer_name.setSecret(false);
		horizontalLayout_button.addComponent(textField_customer_name);
		
		// button_customer_search
		button_customer_search = new Button();
		button_customer_search.setCaption("�����ͻ�");
		button_customer_search.setImmediate(true);
		button_customer_search.setWidth("-1px");
		button_customer_search.setHeight("-1px");
		horizontalLayout_button.addComponent(button_customer_search);
		horizontalLayout_button.setComponentAlignment(button_customer_search,
				new Alignment(24));
		
		return horizontalLayout_button;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_form() {
		// common part: create layout
		verticalLayout_form = new VerticalLayout();
		verticalLayout_form.setImmediate(false);
		verticalLayout_form.setWidth("-1px");
		verticalLayout_form.setHeight("-1px");
		verticalLayout_form.setMargin(false);
		
		// horizontalLayout_cloth_search
		horizontalLayout_cloth_search = buildHorizontalLayout_cloth_search();
		verticalLayout_form.addComponent(horizontalLayout_cloth_search);
		
		// table_cloth
		table_cloth = new Table();
		table_cloth.setImmediate(false);
		table_cloth.setWidth("-1px");
		table_cloth.setHeight("-1px");
		verticalLayout_form.addComponent(table_cloth);
		
		return verticalLayout_form;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_cloth_search() {
		// common part: create layout
		horizontalLayout_cloth_search = new HorizontalLayout();
		horizontalLayout_cloth_search.setImmediate(false);
		horizontalLayout_cloth_search.setWidth("-1px");
		horizontalLayout_cloth_search.setHeight("-1px");
		horizontalLayout_cloth_search.setMargin(false);
		
		// textField_cloth_barCode
		textField_cloth_barCode = new TextField();
		textField_cloth_barCode.setCaption("��������");
		textField_cloth_barCode.setImmediate(false);
		textField_cloth_barCode.setWidth("-1px");
		textField_cloth_barCode.setHeight("-1px");
		textField_cloth_barCode.setSecret(false);
		horizontalLayout_cloth_search.addComponent(textField_cloth_barCode);
		
		// button_cloth_search
		button_cloth_search = new Button();
		button_cloth_search.setCaption("������װ");
		button_cloth_search.setImmediate(true);
		button_cloth_search.setDescription("����");
		button_cloth_search.setWidth("-1px");
		button_cloth_search.setHeight("-1px");
		horizontalLayout_cloth_search.addComponent(button_cloth_search);
		horizontalLayout_cloth_search.setComponentAlignment(
				button_cloth_search, new Alignment(24));
		
		// button_order
		button_order = new Button();
		button_order.setCaption("����");
		button_order.setImmediate(true);
		button_order.setWidth("-1px");
		button_order.setHeight("-1px");
		horizontalLayout_cloth_search.addComponent(button_order);
		horizontalLayout_cloth_search.setComponentAlignment(button_order,
				new Alignment(9));
		
		return horizontalLayout_cloth_search;
	}

}
