package com.hros.cloth.vaadin;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.cloth.dao.ClothDao;
import com.hros.cloth.dao.Customer2Dao;
import com.hros.cloth.dao.OrderHistoryDao;
import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.domain.OrderHistory;
import com.hros.cloth.service.ClothService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class CancelOrderForm extends CustomComponent implements Button.ClickListener{

	@AutoGenerated
	private HorizontalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout verticalLayout_4;
	@AutoGenerated
	private Table table_cloth;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_2;
	@AutoGenerated
	private Button button_exchange;
	@AutoGenerated
	private Button button_bar_code_search;
	@AutoGenerated
	private TextField textField_bar_code;
	@AutoGenerated
	private VerticalLayout verticalLayout_3;
	@AutoGenerated
	private Table table_consume;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_search;
	@AutoGenerated
	private Button button_invalid;
	@AutoGenerated
	private Button button_search;
	@AutoGenerated
	private PopupDateField popupDateField_end;
	@AutoGenerated
	private PopupDateField popupDateField_start;
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
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
	private OrderHistory selectedOrder;
	private Cloth selectedCloth;
	

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public CancelOrderForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		

		// TODO add user code here
		table_consume.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	selectedOrder = (OrderHistory)event.getProperty().getValue();
            }
        });
		table_consume.setSelectable(true);
		table_consume.setMultiSelect(false);
		table_consume.setImmediate(true); 
		
		table_cloth.addListener(new Table.ValueChangeListener() {
            public void valueChange(ValueChangeEvent event) {
            	selectedCloth = (Cloth)event.getProperty().getValue();
            }
        });
		table_cloth.setSelectable(true);
		table_cloth.setMultiSelect(false);
		table_cloth.setImmediate(true); 
		
		button_exchange.addListener(this);
		button_search.addListener(this);
		button_bar_code_search.addListener(this);
		button_invalid.addListener(this);
		
		popupDateField_start.setDateFormat("yyyy-MM-dd");
		popupDateField_end.setDateFormat("yyyy-MM-dd");
		
		popupDateField_start.setResolution(PopupDateField.RESOLUTION_DAY);
		popupDateField_end.setResolution(PopupDateField.RESOLUTION_DAY);

		
	}
	@Override
	public void attach(){
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		//clothService = (ClothService) help.getBean("clothServiceImpl");
		clothDao = (ClothDao)help.getBean("clothDao");
		customerDao = (Customer2Dao)help.getBean("customer2Dao");
		orderHistoryDao = (OrderHistoryDao)help.getBean("orderHistoryDao");
		clothService = (ClothService)help.getBean("clothServiceImpl");
		//Ĭ����ʾһ���ڵ�����
		popupDateField_start.setValue(new Date(System.currentTimeMillis() - 24*7*3600*1000));
		popupDateField_end.setValue(new Date());
		
		populateOrderHistory();
		List<Cloth> clothes = clothDao.getAllClothes();
		populateCloths(clothes);
		//populateUsers();
	}
	
	private void populateOrderHistory(){
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		Map<String,String> map = new HashMap<String,String>();
		String startDate = dateFormatter.format(popupDateField_start.getValue());
		map.put("startDate", startDate);
		String endDate = dateFormatter.format(popupDateField_end.getValue());
		map.put("endDate", endDate);
		/*if(startDate.compareTo(endDate) > 0){
			getWindow().showNotification("��ʼʱ�䲻�����ڽ�ֹʱ�� ", "ʱ��ѡ�����",Notification.TYPE_ERROR_MESSAGE);
			return;
		}*/
		
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("customerName", String.class,null);
		container.addContainerProperty("cloth", String.class,null);
		container.addContainerProperty("date", String.class,null);
		container.addContainerProperty("consume", String.class,null);
		container.addContainerProperty("consumeType", String.class,null);
		
		List<OrderHistory> orderHistories = orderHistoryDao.findOrderHistoryBetweenDate(map);
		for(OrderHistory orderHistory:orderHistories){
			 Item item = container.addItem(orderHistory);
			 if(orderHistory.getCustomerID() != null && orderHistory.getCustomerID() != 0){
				 Customer2 customer = customerDao.getCustomerByID(orderHistory.getCustomerID());
				 item.getItemProperty("customerName").setValue(customer.getName());
			 }
			 else{
				 item.getItemProperty("customerName").setValue("��������");
			 }
			 Cloth boughtCloth = clothDao.getClothByID(orderHistory.getClothID());
			 item.getItemProperty("cloth").setValue(boughtCloth.getName());
			 String consumeDate = dateFormatter.format(orderHistory.getConsumeDate());
			 item.getItemProperty("date").setValue(consumeDate);
			 item.getItemProperty("consume").setValue(orderHistory.getConsumption());
			 if(orderHistory.getExchangedOrderID() == null){
				 item.getItemProperty("consumeType").setValue("��������");
			 }
			 else{
				 item.getItemProperty("consumeType").setValue("����");
			 }
			 
		}
		
		table_consume.setContainerDataSource(container);
		table_consume.setColumnHeaders(new String[] { "�˿�����","ѡ���򻻹��ķ�װ","��������","���ѽ��","��������"});
		table_consume.setVisibleColumns(new String[] { "customerName","cloth","date","consume","consumeType"});
		table_consume.setWidth("500px");
	}
	
	private void populateCloths(List<Cloth> clothes){
		table_cloth.setContainerDataSource(ClothUtil.getClothContainer(clothes));
		table_cloth.setColumnHeaders(ClothUtil.getClothTableColumnHeaders());
		table_cloth.setVisibleColumns(ClothUtil.getClothTableVisiableColumn());

		table_cloth.setWidth("400px");
		
	}
	
	
	
	@Override
	public void buttonClick(ClickEvent event) {
		//����������ť
		if(event.getSource().equals(button_search)){
			populateOrderHistory();
		}
		
		//����������������װ��ť
		if(event.getSource().equals(button_bar_code_search)){
			String barCode =  textField_bar_code.getValue().toString();
			List<Cloth> foundCloths = clothDao.findClothsByBarCode(barCode);
			populateCloths(foundCloths);
		}
		
		//����
		if(event.getSource().equals(button_exchange)){
			if(selectedOrder == null){
				getWindow().showNotification("����ѡ��һ�������ٻ��� ", "��������",Notification.TYPE_ERROR_MESSAGE);
				return;
			}
			if(selectedOrder.getState().equalsIgnoreCase(OrderHistory.STATE_EXCHANGE)){
				getWindow().showNotification("�ö����ѻ�����,�����ظ����� ", "��ʾ",Notification.TYPE_WARNING_MESSAGE);
				return;
			}
			
			//ѡ��һ������
			if(selectedCloth == null){
				getWindow().showNotification("�����ұ߷�װ�б���ѡ��һ����װ������ ", "��������",Notification.TYPE_ERROR_MESSAGE);
				return;
			}

			//����һ���Ի�������ʾ���
			Window subWindow = new Window();
			subWindow.setModal(true);
			subWindow.setWidth("500px");
			CancelOrderDialog cancelOrderDialog = new CancelOrderDialog();
			//use hastMap to get and pass parameter;
			Map<String,Object> parameters = new HashMap<String,Object>();
			parameters.put(CancelOrderDialog.PARAMETER_SELECTED_CLOTH, selectedCloth);
			parameters.put(CancelOrderDialog.PARAMETER_SELECTED_ORDER, selectedOrder);
			float total = clothService.getTotalConsumption(selectedOrder.getOrderHistoryID(), 0);
			parameters.put(CancelOrderDialog.PARAMETER_PRICE_ORIG, total);
			parameters.put(CancelOrderDialog.PARAMETER_PRICE_CURRENT, selectedCloth.getRealPrice());
			parameters.put(CancelOrderDialog.PARAMETER_PRICE_DIFF, selectedCloth.getRealPrice() - total);
			cancelOrderDialog.setParameters(parameters);
			cancelOrderDialog.setTable(table_cloth);
			cancelOrderDialog.setTable_Consume(table_consume);
			
			subWindow.addComponent(cancelOrderDialog);
			getWindow().addWindow(subWindow);
		}
		//���϶���
		if(event.getSource().equals(button_invalid)){
			if(selectedOrder == null){
				getWindow().showNotification("����ѡ��һ������������ ", "��������",Notification.TYPE_ERROR_MESSAGE);
				return;
			}
			clothService.invalidOrder(selectedOrder);
			table_consume.getContainerDataSource().removeItem(selectedOrder);
			getWindow().showNotification("�������ϳɹ� ", "��ʾ",Notification.TYPE_HUMANIZED_MESSAGE);
		}
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
		
		// verticalLayout_3
		verticalLayout_3 = buildVerticalLayout_3();
		mainLayout.addComponent(verticalLayout_3);
		
		// verticalLayout_4
		verticalLayout_4 = buildVerticalLayout_4();
		mainLayout.addComponent(verticalLayout_4);
		
		return mainLayout;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_3() {
		// common part: create layout
		verticalLayout_3 = new VerticalLayout();
		verticalLayout_3.setImmediate(false);
		verticalLayout_3.setWidth("-1px");
		verticalLayout_3.setHeight("-1px");
		verticalLayout_3.setMargin(false);
		
		// horizontalLayout_search
		horizontalLayout_search = buildHorizontalLayout_search();
		verticalLayout_3.addComponent(horizontalLayout_search);
		
		// table_consume
		table_consume = new Table();
		table_consume.setImmediate(false);
		table_consume.setWidth("-1px");
		table_consume.setHeight("-1px");
		verticalLayout_3.addComponent(table_consume);
		
		return verticalLayout_3;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_search() {
		// common part: create layout
		horizontalLayout_search = new HorizontalLayout();
		horizontalLayout_search.setImmediate(false);
		horizontalLayout_search.setWidth("-1px");
		horizontalLayout_search.setHeight("-1px");
		horizontalLayout_search.setMargin(false);
		
		// popupDateField_start
		popupDateField_start = new PopupDateField();
		popupDateField_start.setCaption("��ʼ����");
		popupDateField_start.setImmediate(false);
		popupDateField_start.setWidth("-1px");
		popupDateField_start.setHeight("-1px");
		popupDateField_start.setInvalidAllowed(false);
		horizontalLayout_search.addComponent(popupDateField_start);
		
		// popupDateField_end
		popupDateField_end = new PopupDateField();
		popupDateField_end.setCaption("��ֹ����");
		popupDateField_end.setImmediate(false);
		popupDateField_end.setWidth("-1px");
		popupDateField_end.setHeight("-1px");
		popupDateField_end.setInvalidAllowed(false);
		horizontalLayout_search.addComponent(popupDateField_end);
		
		// button_search
		button_search = new Button();
		button_search.setCaption("��������");
		button_search.setImmediate(true);
		button_search.setWidth("-1px");
		button_search.setHeight("-1px");
		horizontalLayout_search.addComponent(button_search);
		horizontalLayout_search.setComponentAlignment(button_search,
				new Alignment(24));
		
		// button_invalid
		button_invalid = new Button();
		button_invalid.setCaption("��������");
		button_invalid.setImmediate(false);
		button_invalid.setWidth("-1px");
		button_invalid.setHeight("-1px");
		horizontalLayout_search.addComponent(button_invalid);
		horizontalLayout_search.setComponentAlignment(button_invalid,
				new Alignment(9));
		
		return horizontalLayout_search;
	}
	@AutoGenerated
	private VerticalLayout buildVerticalLayout_4() {
		// common part: create layout
		verticalLayout_4 = new VerticalLayout();
		verticalLayout_4.setImmediate(false);
		verticalLayout_4.setWidth("-1px");
		verticalLayout_4.setHeight("-1px");
		verticalLayout_4.setMargin(false);
		
		// horizontalLayout_2
		horizontalLayout_2 = buildHorizontalLayout_2();
		verticalLayout_4.addComponent(horizontalLayout_2);
		
		// table_cloth
		table_cloth = new Table();
		table_cloth.setImmediate(false);
		table_cloth.setWidth("-1px");
		table_cloth.setHeight("-1px");
		verticalLayout_4.addComponent(table_cloth);
		
		return verticalLayout_4;
	}
	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_2() {
		// common part: create layout
		horizontalLayout_2 = new HorizontalLayout();
		horizontalLayout_2.setImmediate(false);
		horizontalLayout_2.setWidth("-1px");
		horizontalLayout_2.setHeight("-1px");
		horizontalLayout_2.setMargin(false);
		
		// textField_bar_code
		textField_bar_code = new TextField();
		textField_bar_code.setCaption("������");
		textField_bar_code.setImmediate(false);
		textField_bar_code.setWidth("-1px");
		textField_bar_code.setHeight("-1px");
		textField_bar_code.setSecret(false);
		horizontalLayout_2.addComponent(textField_bar_code);
		
		// button_bar_code_search
		button_bar_code_search = new Button();
		button_bar_code_search.setCaption("������װ");
		button_bar_code_search.setImmediate(true);
		button_bar_code_search.setWidth("-1px");
		button_bar_code_search.setHeight("-1px");
		horizontalLayout_2.addComponent(button_bar_code_search);
		horizontalLayout_2.setComponentAlignment(button_bar_code_search,
				new Alignment(24));
		
		// button_exchange
		button_exchange = new Button();
		button_exchange.setCaption("����");
		button_exchange.setImmediate(true);
		button_exchange.setWidth("-1px");
		button_exchange.setHeight("-1px");
		horizontalLayout_2.addComponent(button_exchange);
		horizontalLayout_2.setComponentAlignment(button_exchange,
				new Alignment(9));
		
		return horizontalLayout_2;
	}

}