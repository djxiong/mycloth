package com.hros.cloth.vaadin;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.cloth.dao.ClothDao;
import com.hros.cloth.dao.Customer2Dao;
import com.hros.cloth.dao.OrderHistoryDao;
import com.hros.cloth.domain.OrderHistory;
import com.hros.cloth.service.ClothService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class OrderHistoryForm extends CustomComponent {

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_data;
	@AutoGenerated
	private VerticalLayout verticalLayout_exchange;
	@AutoGenerated
	private Table table_exchange;
	@AutoGenerated
	private TextField textField_total_exchange;
	@AutoGenerated
	private VerticalLayout verticalLayout_return;
	@AutoGenerated
	private Table table_return;
	@AutoGenerated
	private TextField textField_total_return;
	@AutoGenerated
	private VerticalLayout verticalLayout_sales;
	@AutoGenerated
	private Table table_consume;
	@AutoGenerated
	private TextField textField_consume_count;
	@AutoGenerated
	private TextField textField_total_consume;
	@AutoGenerated
	private HorizontalLayout horizontalLayout_search;
	@AutoGenerated
	private Button button_search;
	@AutoGenerated
	private PopupDateField popupDateField_end;
	@AutoGenerated
	private PopupDateField popupDateField_start;

	private ClothDao clothDao;
	private Customer2Dao customerDao;
	private OrderHistoryDao orderHistoryDao; 
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public OrderHistoryForm() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		

		// TODO add user code here
		popupDateField_end.setResolution(PopupDateField.RESOLUTION_DAY);
		popupDateField_start.setResolution(PopupDateField.RESOLUTION_DAY);

		
	}
	@Override
	public void attach(){
		super.attach();
		SpringContextHelper help = new SpringContextHelper(this.getApplication());
		//clothService = (ClothService) help.getBean("clothServiceImpl");
		clothDao = (ClothDao)help.getBean("clothDao");
		customerDao = (Customer2Dao)help.getBean("customer2Dao");
		orderHistoryDao = (OrderHistoryDao)help.getBean("orderHistoryDao");
		
		//默认显示最近一周的订单

		popupDateField_start.setValue(new Date(System.currentTimeMillis() - 24*7*3600*1000));
		popupDateField_end.setValue(new Date());
		
		
		populateOrderHistory();
		//populateCloths();
		//populateUsers();
	}
	
	private void populateOrderHistory(){
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		Map<String,String> map = new HashMap<String,String>();
		String startDate = dateFormatter.format(popupDateField_start.getValue());
		map.put("startDate", startDate);
		String endDate = dateFormatter.format(popupDateField_end.getValue());
		map.put("endDate", endDate);
		IndexedContainer container = new IndexedContainer();
		container.addContainerProperty("consume", String.class,null);
		List<OrderHistory> orderHistories = orderHistoryDao.findOrderHistoryBetweenDate(map);
		for(OrderHistory orderHistory:orderHistories){
			 Item item = container.addItem(orderHistory);
			 item.getItemProperty("consume").setValue(orderHistory.getConsumption());
		}
		
		table_consume.setContainerDataSource(container);
		table_consume.setColumnHeaders(new String[] { "名称"});
		table_consume.setVisibleColumns(new String[] { "consume"});
		table_consume.setWidth("300px");
	}
	
	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// horizontalLayout_search
		horizontalLayout_search = buildHorizontalLayout_search();
		mainLayout.addComponent(horizontalLayout_search);
		
		// horizontalLayout_data
		horizontalLayout_data = buildHorizontalLayout_data();
		mainLayout.addComponent(horizontalLayout_data);
		mainLayout.setExpandRatio(horizontalLayout_data, 1.0f);
		
		return mainLayout;
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
		popupDateField_start.setCaption("开始日期");
		popupDateField_start.setImmediate(false);
		popupDateField_start.setWidth("-1px");
		popupDateField_start.setHeight("-1px");
		popupDateField_start.setInvalidAllowed(false);
		horizontalLayout_search.addComponent(popupDateField_start);
		
		// popupDateField_end
		popupDateField_end = new PopupDateField();
		popupDateField_end.setCaption("截止日期");
		popupDateField_end.setImmediate(false);
		popupDateField_end.setWidth("-1px");
		popupDateField_end.setHeight("-1px");
		popupDateField_end.setInvalidAllowed(false);
		horizontalLayout_search.addComponent(popupDateField_end);
		
		// button_search
		button_search = new Button();
		button_search.setCaption("搜索");
		button_search.setImmediate(false);
		button_search.setWidth("-1px");
		button_search.setHeight("-1px");
		horizontalLayout_search.addComponent(button_search);
		horizontalLayout_search.setComponentAlignment(button_search,
				new Alignment(24));
		
		return horizontalLayout_search;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout_data() {
		// common part: create layout
		horizontalLayout_data = new HorizontalLayout();
		horizontalLayout_data.setImmediate(false);
		horizontalLayout_data.setWidth("-1px");
		horizontalLayout_data.setHeight("-1px");
		horizontalLayout_data.setMargin(false);
		
		// verticalLayout_sales
		verticalLayout_sales = buildVerticalLayout_sales();
		horizontalLayout_data.addComponent(verticalLayout_sales);
		
		// verticalLayout_return
		verticalLayout_return = buildVerticalLayout_return();
		horizontalLayout_data.addComponent(verticalLayout_return);
		
		// verticalLayout_exchange
		verticalLayout_exchange = buildVerticalLayout_exchange();
		horizontalLayout_data.addComponent(verticalLayout_exchange);
		
		return horizontalLayout_data;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_sales() {
		// common part: create layout
		verticalLayout_sales = new VerticalLayout();
		verticalLayout_sales.setImmediate(false);
		verticalLayout_sales.setWidth("-1px");
		verticalLayout_sales.setHeight("-1px");
		verticalLayout_sales.setMargin(false);
		
		// textField_total_consume
		textField_total_consume = new TextField();
		textField_total_consume.setCaption("总销售额");
		textField_total_consume.setImmediate(false);
		textField_total_consume.setWidth("-1px");
		textField_total_consume.setHeight("-1px");
		textField_total_consume.setSecret(false);
		verticalLayout_sales.addComponent(textField_total_consume);
		
		// textField_consume_count
		textField_consume_count = new TextField();
		textField_consume_count.setCaption("总销售数量");
		textField_consume_count.setImmediate(false);
		textField_consume_count.setWidth("-1px");
		textField_consume_count.setHeight("-1px");
		textField_consume_count.setSecret(false);
		verticalLayout_sales.addComponent(textField_consume_count);
		
		// table_consume
		table_consume = new Table();
		table_consume.setImmediate(false);
		table_consume.setWidth("-1px");
		table_consume.setHeight("-1px");
		verticalLayout_sales.addComponent(table_consume);
		
		return verticalLayout_sales;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_return() {
		// common part: create layout
		verticalLayout_return = new VerticalLayout();
		verticalLayout_return.setImmediate(false);
		verticalLayout_return.setWidth("-1px");
		verticalLayout_return.setHeight("-1px");
		verticalLayout_return.setMargin(false);
		
		// textField_total_return
		textField_total_return = new TextField();
		textField_total_return.setCaption("总退货量");
		textField_total_return.setImmediate(false);
		textField_total_return.setWidth("-1px");
		textField_total_return.setHeight("-1px");
		textField_total_return.setSecret(false);
		verticalLayout_return.addComponent(textField_total_return);
		
		// table_return
		table_return = new Table();
		table_return.setImmediate(false);
		table_return.setWidth("-1px");
		table_return.setHeight("-1px");
		verticalLayout_return.addComponent(table_return);
		
		return verticalLayout_return;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_exchange() {
		// common part: create layout
		verticalLayout_exchange = new VerticalLayout();
		verticalLayout_exchange.setImmediate(false);
		verticalLayout_exchange.setWidth("-1px");
		verticalLayout_exchange.setHeight("-1px");
		verticalLayout_exchange.setMargin(false);
		
		// textField_total_exchange
		textField_total_exchange = new TextField();
		textField_total_exchange.setCaption("总换货量");
		textField_total_exchange.setImmediate(false);
		textField_total_exchange.setWidth("-1px");
		textField_total_exchange.setHeight("-1px");
		textField_total_exchange.setSecret(false);
		verticalLayout_exchange.addComponent(textField_total_exchange);
		
		// table_exchange
		table_exchange = new Table();
		table_exchange.setImmediate(false);
		table_exchange.setWidth("-1px");
		table_exchange.setHeight("-1px");
		verticalLayout_exchange.addComponent(table_exchange);
		
		return verticalLayout_exchange;
	}

}
