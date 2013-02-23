package com.hros.staffstate.vaadin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.customer.domain.Customer;
import com.hros.file.domain.File;
import com.hros.staffstate.domain.Staff;
import com.hros.staffstate.domain.StaffState;
import com.hros.staffstate.service.StaffStateService;
import com.hros.staffstate.staffstatecomponent.FieldFactory;
import com.hros.staffstate.staffstatecomponent.MyButton;
import com.hros.staffstate.staffstatecomponent.MyForm;
import com.hros.staffstate.staffstatecomponent.MyTable;
import com.hros.staffstate.staffstatecomponent.MyTextField;
import com.hros.staffstate.vaadin.NewLayout.CustomerLabel;
import com.hros.staffstate.vaadin.NewLayout.Dict;
import com.hros.staffstate.vaadin.NewLayout.FileLabel;
import com.hros.staffstate.vaadin.NewLayout.StaffLabel;
import com.hros.staffstate.vaadin.NewLayout.UserLabel;
import com.hros.vaadin.SpringContextHelper;
import com.hros.vaadin.myComponent.MyDictComboBox;
import com.hros.vaadin.myComponent.MyGeneratorColumn;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class Quit extends CustomComponent {

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private AbsoluteLayout absoluteLayout;
	@AutoGenerated
	private Button queryButton;
	@AutoGenerated
	private Button updateButton;
	@AutoGenerated
	private TextField textFieldName;
	@AutoGenerated
	private TextField textFieldIdCard;
	@AutoGenerated
	private TextField textFieldCus;
	@AutoGenerated
	private MyDictComboBox nativeSelectStatus;

	private StaffStateService staffStateService;
	private NewLayout newLayout;
	private BeanItem<StaffState> stateItem;
	private BeanItem<Staff> staffItem;
	private BeanItem<Customer> custItem;
	private BeanItem<File> fItem;
	private StaffState staffState = new StaffState();
	private Staff staff = new Staff();
	private Customer customer = new Customer();
	public static File file = new File();
	private MyForm staffForm;
	private MyForm staffStateForm;
	private MyForm customerForm;
	static MyForm fileForm;
	private MyTable myTable;
	private Map<String, Object> map;
	FieldFactory fieldFactory = new FieldFactory();
	private TabSheet tabSheet;

	public Quit() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);

		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");

		absoluteLayout = buildAbsoluteLayout();
		// tlist = buildTabList();

		tabSheet = buildTabSheet();
		myTable = buildTable();
		newLayout = new NewLayout(absoluteLayout, myTable, tabSheet);
		mainLayout.addComponent(newLayout);

		return mainLayout;

	}

	@Override
	public void attach() {
		super.attach();
		SpringContextHelper sch = new SpringContextHelper(this.getApplication());
		staffStateService = (StaffStateService) sch
				.getBean("staffStateServiceImpl");
	}

	@AutoGenerated
	private AbsoluteLayout buildAbsoluteLayout() {
		absoluteLayout = new AbsoluteLayout();
		absoluteLayout.setImmediate(false);
		absoluteLayout.setWidth("100.0%");
		absoluteLayout.setHeight("100.0%");
		absoluteLayout.setMargin(false);
		absoluteLayout
				.addComponent(buildQueryButton(), "top:5.0px;left:5.0px;");
		absoluteLayout.addComponent(buildUpdateButton(),
				"top:5.0px;left:65.0px;");
		textFieldName = new MyTextField("����", "-1px", "-1px");
		absoluteLayout.addComponent(textFieldName, "top:50.0px;left:5.0px;");
		textFieldIdCard = new MyTextField("����֤", "-1px", "-1px");
		absoluteLayout
				.addComponent(textFieldIdCard, "top:50.0px;left:150.0px;");
		textFieldCus = new MyTextField("��ǲ��λ", "-1px", "-1px");
		absoluteLayout.addComponent(textFieldCus, "top:50.0px;left:295.0px;");
		absoluteLayout.addComponent(buildNativeSelect(),
				"top:50.0px;left:440.0px;");
		return absoluteLayout;

	}

	// ������ѯ��ť
	private Button buildQueryButton() {
		queryButton = new MyButton("��ѯ", "-1px", "-1px");
		queryButton.addListener(ClickEvent.class, this, "queryButton");
		return queryButton;

	}

	// ��ѯ�¼�
	public void queryButton(ClickEvent event) {
		updateButton.setReadOnly(true);
		query();
	}

	// ��ѯ
	private void query() {
		myTable.removeAllItems();
		map = getSelectMap();
		if (!"006001".equals(nativeSelectStatus.getValue().toString())) {
			map.put("state", "006002");
		} else {
			map.put("state", "006001");
		}
		List<StaffState> list = staffStateService.selectStaffState(map);
		myTable.setItems(list);
	}

	// ��ȡ��ѯ����
	private Map<String, Object> getSelectMap() {
		map = new HashMap<String, Object>();
		map.put("staffName", textFieldName.getValue());
		map.put("identityCard", textFieldIdCard.getValue());
		map.put("custName", textFieldCus.getValue());
		return map;

	}

	// �����޸İ�ť
	private Button buildUpdateButton() {
		updateButton = new MyButton("�޸�", "-1px", "-1px");
		updateButton.setReadOnly(true);
		updateButton.addListener(ClickEvent.class, this, "updateButton");
		return updateButton;

	}

	// �޸��¼�
	public void updateButton(ClickEvent event) {
		if (staffState.quitDate == null) {
			getWindow().showNotification("��������ְʱ��");
			return;
		}
		staffForm.commit();
		customerForm.commit();
		fileForm.commit();
		Item item = myTable.getItem(myTable.getValue());
		item.getItemProperty("state").setValue("006002");
		item.getItemProperty("custID").setValue(customer.getCustID());
		item.getItemProperty("quitFileID").setValue(file.getFileID());
		staffStateForm.commit();

		staffState.setQuitFileID(file.getFileID());
		staffState.setQuitUserID(1);
		staffStateService.updateStaffQuit(staffState);

		staff.setState("006002");
		staffStateService.updateState(staff);
	}

	@AutoGenerated
	private MyDictComboBox buildNativeSelect() {
		nativeSelectStatus = new MyDictComboBox("״̬", "006");
		return nativeSelectStatus;

	}

	// ����table
	private MyTable buildTable() {
		myTable = new MyTable();
		Object[] obj = { "staffID", "����֤", "state", "custID", "post",
				"entryDate", "quitDate", "quitApplayDate", "livePostDate",
				"disInsuranceDate", "userId", "quitUserID", "quitFileID" };
		String[] str = { "Ա��", "����֤", "״̬", "�ͻ�", "��λ", "��ְʱ��", "��ְʱ��",
				"��ְ����ʱ��", "���ʱ��", "ͣ��ʱ��", "�û�", "��ְ����Ա", "��ְ����" };
		BeanItemContainer<StaffState> beanItem = new BeanItemContainer<StaffState>(
				StaffState.class);
		myTable.setDateSource(beanItem);
		changeTableCloumn();
		myTable.setColumns(obj);
		myTable.setHeader(str);
		myTable.addListener(ValueChangeEvent.class, this, "valueChange");
		return myTable;

	}

	public void valueChange(ValueChangeEvent event) {
		List<File> flist;
		staffState = (StaffState) myTable.getValue();
		if (staffState == null) {
			return;
		}
		List<Customer> clist = staffStateService.selectCustomerById(staffState
				.getCustID());
		customer = clist.get(0);
		customerForm.setValue(customer);
		if (staffState.getQuitFileID() != 0) {
			flist = staffStateService
					.selectFileById(staffState.getQuitFileID());
		} else {
			flist = staffStateService.selectFileById(staffState
					.getEntryFileID());
		}
		file = flist.get(0);
		fileForm.setValue(file);

		List<Staff> slist = staffStateService.selectStaffById(staffState
				.getStaffID());
		staff = slist.get(0);
		staffForm.setValue(staff);
		staffStateForm.setValue(myTable.getItem(myTable.getValue()));
		updateButton.setReadOnly(false);
	}

	// �滻Table�е�ֵ
	private void changeTableCloumn() {
		myTable.addGeneratedColumn("staffID", new MyGeneratorColumn(
				StaffLabel.class));
		myTable.addGeneratedColumn("custID", new MyGeneratorColumn(
				CustomerLabel.class));
		myTable.addGeneratedColumn("����֤", new MyGeneratorColumn(
				StaffLabel.class));
		myTable.addGeneratedColumn("state", new MyGeneratorColumn(Dict.class));
		myTable.addGeneratedColumn("quitFileID", new MyGeneratorColumn(
				FileLabel.class));
		myTable.addGeneratedColumn("userId", new MyGeneratorColumn(
				UserLabel.class));
		myTable.addGeneratedColumn("quitUserID", new MyGeneratorColumn(
				UserLabel.class));
	}

	// ���� TabSheet
	private TabSheet buildTabSheet() {
		tabSheet = new TabSheet();
		tabSheet.setSizeFull();
		tabSheet.addTab(buildStaffForm(), "������Ϣ");
		tabSheet.addTab(buildStaffStateForm(), "��ְ��Ϣ");
		tabSheet.addTab(buildCustomerForm(), "�ͻ���Ϣ");
		tabSheet.addTab(buildFileForm(), "������Ϣ");
		return tabSheet;

	}

	// ����������ϢForm
	private MyForm buildStaffForm() {
		staffForm = new MyForm(2, 4);
		String[] str = { "staffName", "staffSex", "identityCard", "phone",
				"address", "homeAddress", "homePhone", "state" };
		staffItem = new BeanItem<Staff>(staff);
		staffForm.setFactory(fieldFactory);
		staffForm.setDateSource(staffItem);
		staffForm.setVisible(Arrays.asList(str));
		return staffForm;

	}

	// ������ְ��ϢForm
	private MyForm buildStaffStateForm() {
		staffStateForm = new MyForm(2, 1);
		String[] str = { "quitApplayDate", "livePostDate", "quitDate",
				"disInsuranceDate" };
		stateItem = new BeanItem<StaffState>(staffState);
		staffStateForm.setFactory(fieldFactory);
		staffStateForm.setDateSource(stateItem);
		staffStateForm.setVisible(Arrays.asList(str));
		return staffStateForm;

	}

	// �����ͻ���ϢForm
	private MyForm buildCustomerForm() {
		customerForm = new MyForm(2, 2);
		String[] str = { "custCode", "custName", "custLegalPerson", "address",
				"phone", "industry", "custClass", "custAttr", "custCity",
				"custType" };
		custItem = new BeanItem<Customer>(customer);
		customerForm.setFactory(fieldFactory);
		customerForm.setDateSource(custItem);
		customerForm.setVisible(Arrays.asList(str));
		return customerForm;

	}

	// ����������ϢForm
	private MyForm buildFileForm() {
		fileForm = new MyForm(2, 1);
		String[] str = { "fileCode", "fileName", "fileType", "fileDate",
				"fileUserID", "fileOutDate", "fileManagerID", "fileExamineID",
				"auditState", "electronicFile", "scanningElement",
				"fileLocation" };
		fItem = new BeanItem<File>(file);
		fileForm.setFactory(fieldFactory);
		fileForm.setDateSource(fItem);
		fileForm.setVisible(Arrays.asList(str));
		Button fileButton = new Button("ѡ�񵵰�");
		fileButton.addListener(ClickEvent.class, this, "getFile");
		fileForm.getFooter().setMargin(false, true, true, true);
		fileForm.getFooter().addComponent(fileButton);
		return fileForm;

	}

	public void getFile(ClickEvent event) {
		getWindow().addWindow(new FileSelect("��ְ����ѡ��"));
	}

}