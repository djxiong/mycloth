package com.hros.vaadin.myComponent;

import java.util.Map;

import com.hros.bas.pubLib.PubUtil;
import com.hros.bas.service.BaseService;
import com.hros.bas.service.TabColumnService;
import com.hros.vaadin.myComponent.MyForm;
import com.hros.vaadin.myComponent.MyTable;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public abstract class BasePageForm extends BaseForm {

	/**
	 * Tab个性化设置存储的Service
	 */
	protected TabColumnService tabColumnService;
	/**
	 * service基类接口
	 */
	protected BaseService baseService;
	/**
	 * 窗体顶部查询模块
	 */
	protected HorizontalLayout topTollbarLayout;
	
	protected Button btnSearch;
	
	protected Button btnFilter;
	
	protected Button btnImport;
	
	protected Button btnExport;
	
	protected Button btnPrint;
	
	/**
	 * 删选条件放置模块
	 */
	protected HorizontalLayout filterLayout;
	
	/**
	 * 中间整体模块
	 */
	protected HorizontalSplitPanel middleLayout;
	
	protected MyTable tbMain;
	
	/**
	 * 窗体右边TABSHEET
	 */
	protected TabSheet tsDetail;
	
	protected VerticalLayout tsTabDetail;
	
	protected HorizontalLayout btnToolbarLayout;
	
	protected Button btnAdd;
	
	protected Button btnEdit;
	
	protected Button btnDelete;
	
	/**
	 * 详细信息展示
	 */
	protected MyForm detailForm;
	
	@Override
	protected void buildMainLayout() {
		// the main layout and components will be created here
		super.buildMainLayout();
		mainLayout.addComponent(buildTopTollbarLayout());
		mainLayout.addComponent(buildFilterLayout());
		mainLayout.addComponent(buildMiddleLayout());
		mainLayout.setExpandRatio(middleLayout, (float) 1.0);
	}
	
	@Override
	public void attach() {
		super.attach();
		configTabColumn();
		initCompany();
	}
	
	/**
	 * 放置个性化的界面设置
	 * 如：TABLE的特殊列，FORM的特殊布局，需加入的TABSHEET页
	 */
	public abstract void initCompany();
	
	/**
	 * 从数据库读取tab的列的配置
	 */
	private void configTabColumn() {
		tabColumnService = (TabColumnService) springHelp.getBean("tabColumnServiceImpl");
		Map map = tabColumnService.selectTabColumn("员工管理", "tbMain", user.getUserID());
		tbMain.setVisibleColumns((Object[]) map.get("visibleColumns"));
		tbMain.setColumnHeaders((String[]) map.get("columnHeaders"));
	}
	
	/**
	 * TABLE和FROM中要展示的对象
	 * @return Object
	 */
	public abstract Object getBeanItem();
	
	//筛选工具栏
	protected HorizontalLayout buildTopTollbarLayout() {
		topTollbarLayout = new HorizontalLayout();
		topTollbarLayout.setImmediate(false);
//		topTollbarLayout.setStyleName("toolbar");
		topTollbarLayout.setMargin(true);
		topTollbarLayout.setSpacing(true);
		topTollbarLayout.setStyleName("toolbar");
		topTollbarLayout.setWidth("100%");
		
		btnSearch = new Button("查询");
		btnFilter = new Button("筛选");
		btnImport = new Button("导入");
		btnExport = new Button("导出");
		btnPrint = new Button("打印");
		
		topTollbarLayout.addComponent(btnSearch);
		topTollbarLayout.addComponent(btnFilter);
		topTollbarLayout.addComponent(btnImport);
		topTollbarLayout.addComponent(btnExport);
		topTollbarLayout.addComponent(btnPrint);
		
		btnSearch.addListener(ClickEvent.class, this, "btnSearch");
		btnFilter.addListener(ClickEvent.class, this, "btnFilter");
		btnImport.addListener(ClickEvent.class, this, "btnImport");
		btnExport.addListener(ClickEvent.class, this, "btnExport");
		btnPrint.addListener(ClickEvent.class, this, "btnPrint");
		
		btnSearch.setIcon(new ThemeResource(PubUtil.RUNO_ICON_SERCH_32));
		btnFilter.setIcon(new ThemeResource(PubUtil.RUNO_ICON_FILTER_32));
		
		HorizontalLayout fillLayout = new HorizontalLayout();
		topTollbarLayout.addComponent(fillLayout);
		fillLayout.setSizeFull();
		topTollbarLayout.setExpandRatio(fillLayout, (float) 1.0);
		return topTollbarLayout;
	}
	
	/**查询按钮点击事件*/
	public abstract void btnSearch(ClickEvent event);
	
	public void btnFilter(ClickEvent event) {
		if (filterLayout != null) {
			filterLayout.setVisible(!filterLayout.isVisible());
		}
	}
	
	public void btnImport() {
		
	}
	
	public void btnExport() {
		
	}
	
	public void btnPrint() {
		
	}
	
	public abstract HorizontalLayout buildFilterLayout();
	
	protected HorizontalSplitPanel buildMiddleLayout() {
		middleLayout = new HorizontalSplitPanel();
		middleLayout.setImmediate(false);
		middleLayout.setSizeFull();
		middleLayout.addComponent(buildTbMain());
		middleLayout.addComponent(buildTsDetail());
		middleLayout.setSplitPosition(30);
		return middleLayout;
	}
	
	/**
	 * 信息列表
	 * @return
	 */
	protected MyTable buildTbMain() {
		tbMain = initTable();
		tbMain.setSizeFull();
		tbMain.setBeanItem(getBeanItem().getClass());
		tbMain.addListener(ValueChangeEvent.class, this, "valueChage");
		return tbMain;
	}
	
	/**
	 * 构造TABLE，如有自己特定的TABLE，请重构该方法
	 * @return
	 */
	public MyTable initTable() {
		return new MyTable();
	}
	
	/**
	 * TABLE选择其他行触发事件
	 * @param event
	 */
	public void valueChage(ValueChangeEvent event) {
		Item item = tbMain.getItem(tbMain.getValue());
		if (item != detailForm.getValue()) {
			detailForm.setValue(item);
		}
	}
	
	protected TabSheet buildTsDetail() {
		tsDetail = new TabSheet();
		tsDetail.setSizeFull();
		tsDetail.addTab(buildTsTabDetail(), "详细信息");
		return tsDetail;
	}
	
	//客户详细信息TAB页
	protected VerticalLayout buildTsTabDetail() {
		tsTabDetail = new VerticalLayout();
		tsTabDetail.setMargin(true);
		tsTabDetail.setSpacing(true);
		tsTabDetail.addComponent(buildBtnToolbarLayout());
		tsTabDetail.addComponent(buildFmCustomer());
		return tsTabDetail;
	}
	
	/**详细信息操作按钮*/
	protected HorizontalLayout buildBtnToolbarLayout() {
		btnToolbarLayout = new HorizontalLayout();
		btnToolbarLayout.setImmediate(false);
		btnToolbarLayout.setSpacing(true);
		btnAdd = new Button("新增");
		btnEdit = new Button("修改");
		btnDelete = new Button("删除");
		btnToolbarLayout.addComponent(btnAdd);
		btnToolbarLayout.addComponent(btnEdit);
		btnToolbarLayout.addComponent(btnDelete);
		btnAdd.addListener(ClickEvent.class, this, "btnAdd");
		btnEdit.addListener(ClickEvent.class, this, "btnEdit");
		btnDelete.addListener(ClickEvent.class, this, "btnDelete");
		return btnToolbarLayout;
	}
	
	/**添加按钮点击事件*/
	public abstract void btnAdd(ClickEvent event);

	/**修改按钮点击事件*/
	public abstract void btnEdit(ClickEvent event);
	
	/**删除按钮点击事件*/
	public abstract void btnDelete(ClickEvent event);
	
	//客户详情FORM
	protected MyForm buildFmCustomer() {
		detailForm = initForm();
		detailForm.setItemDataSource(getBeanItem());
		detailForm.setValue(getBeanItem());
		detailForm.setSizeFull();
		detailForm.createBtnFoot();
		detailForm.getBtnOk().addListener(ClickEvent.class, this, "saveCustomer");
		detailForm.getBtnCancel().addListener(ClickEvent.class, this, "cancelCustomer");
		return detailForm;
	}
	
	/**
	 * 构造FROM，如有自己的特定的FROM，重构该方法
	 * @return
	 */
	public MyForm initForm() {
		return new MyForm();
	}
	
	/**form的保存按钮点击事件*/
	public abstract void saveCustomer(ClickEvent event);
	
	/**form的取消按钮点击事件*/
	public abstract void cancelCustomer(ClickEvent event);
	
	public void setReadOnly(boolean isReadOnly) {
		detailForm.setReadOnly(isReadOnly);
	}
}
