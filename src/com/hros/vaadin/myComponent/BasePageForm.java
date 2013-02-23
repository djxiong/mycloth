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
	 * Tab���Ի����ô洢��Service
	 */
	protected TabColumnService tabColumnService;
	/**
	 * service����ӿ�
	 */
	protected BaseService baseService;
	/**
	 * ���嶥����ѯģ��
	 */
	protected HorizontalLayout topTollbarLayout;
	
	protected Button btnSearch;
	
	protected Button btnFilter;
	
	protected Button btnImport;
	
	protected Button btnExport;
	
	protected Button btnPrint;
	
	/**
	 * ɾѡ��������ģ��
	 */
	protected HorizontalLayout filterLayout;
	
	/**
	 * �м�����ģ��
	 */
	protected HorizontalSplitPanel middleLayout;
	
	protected MyTable tbMain;
	
	/**
	 * �����ұ�TABSHEET
	 */
	protected TabSheet tsDetail;
	
	protected VerticalLayout tsTabDetail;
	
	protected HorizontalLayout btnToolbarLayout;
	
	protected Button btnAdd;
	
	protected Button btnEdit;
	
	protected Button btnDelete;
	
	/**
	 * ��ϸ��Ϣչʾ
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
	 * ���ø��Ի��Ľ�������
	 * �磺TABLE�������У�FORM�����Ⲽ�֣�������TABSHEETҳ
	 */
	public abstract void initCompany();
	
	/**
	 * �����ݿ��ȡtab���е�����
	 */
	private void configTabColumn() {
		tabColumnService = (TabColumnService) springHelp.getBean("tabColumnServiceImpl");
		Map map = tabColumnService.selectTabColumn("Ա������", "tbMain", user.getUserID());
		tbMain.setVisibleColumns((Object[]) map.get("visibleColumns"));
		tbMain.setColumnHeaders((String[]) map.get("columnHeaders"));
	}
	
	/**
	 * TABLE��FROM��Ҫչʾ�Ķ���
	 * @return Object
	 */
	public abstract Object getBeanItem();
	
	//ɸѡ������
	protected HorizontalLayout buildTopTollbarLayout() {
		topTollbarLayout = new HorizontalLayout();
		topTollbarLayout.setImmediate(false);
//		topTollbarLayout.setStyleName("toolbar");
		topTollbarLayout.setMargin(true);
		topTollbarLayout.setSpacing(true);
		topTollbarLayout.setStyleName("toolbar");
		topTollbarLayout.setWidth("100%");
		
		btnSearch = new Button("��ѯ");
		btnFilter = new Button("ɸѡ");
		btnImport = new Button("����");
		btnExport = new Button("����");
		btnPrint = new Button("��ӡ");
		
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
	
	/**��ѯ��ť����¼�*/
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
	 * ��Ϣ�б�
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
	 * ����TABLE�������Լ��ض���TABLE�����ع��÷���
	 * @return
	 */
	public MyTable initTable() {
		return new MyTable();
	}
	
	/**
	 * TABLEѡ�������д����¼�
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
		tsDetail.addTab(buildTsTabDetail(), "��ϸ��Ϣ");
		return tsDetail;
	}
	
	//�ͻ���ϸ��ϢTABҳ
	protected VerticalLayout buildTsTabDetail() {
		tsTabDetail = new VerticalLayout();
		tsTabDetail.setMargin(true);
		tsTabDetail.setSpacing(true);
		tsTabDetail.addComponent(buildBtnToolbarLayout());
		tsTabDetail.addComponent(buildFmCustomer());
		return tsTabDetail;
	}
	
	/**��ϸ��Ϣ������ť*/
	protected HorizontalLayout buildBtnToolbarLayout() {
		btnToolbarLayout = new HorizontalLayout();
		btnToolbarLayout.setImmediate(false);
		btnToolbarLayout.setSpacing(true);
		btnAdd = new Button("����");
		btnEdit = new Button("�޸�");
		btnDelete = new Button("ɾ��");
		btnToolbarLayout.addComponent(btnAdd);
		btnToolbarLayout.addComponent(btnEdit);
		btnToolbarLayout.addComponent(btnDelete);
		btnAdd.addListener(ClickEvent.class, this, "btnAdd");
		btnEdit.addListener(ClickEvent.class, this, "btnEdit");
		btnDelete.addListener(ClickEvent.class, this, "btnDelete");
		return btnToolbarLayout;
	}
	
	/**��Ӱ�ť����¼�*/
	public abstract void btnAdd(ClickEvent event);

	/**�޸İ�ť����¼�*/
	public abstract void btnEdit(ClickEvent event);
	
	/**ɾ����ť����¼�*/
	public abstract void btnDelete(ClickEvent event);
	
	//�ͻ�����FORM
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
	 * ����FROM�������Լ����ض���FROM���ع��÷���
	 * @return
	 */
	public MyForm initForm() {
		return new MyForm();
	}
	
	/**form�ı��水ť����¼�*/
	public abstract void saveCustomer(ClickEvent event);
	
	/**form��ȡ����ť����¼�*/
	public abstract void cancelCustomer(ClickEvent event);
	
	public void setReadOnly(boolean isReadOnly) {
		detailForm.setReadOnly(isReadOnly);
	}
}
