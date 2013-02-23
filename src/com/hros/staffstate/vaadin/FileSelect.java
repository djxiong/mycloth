package com.hros.staffstate.vaadin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hros.file.domain.File;
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
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class FileSelect extends Window{
	
	private VerticalLayout verticalLayout;
	private HorizontalLayout horizontalLayout;
	private VerticalLayout vLayout;
	private Button close;
	private MyTable fileTable;
	private TextField fileName;
	private MyDictComboBox  auditState;
	private MyDictComboBox fileType;
	private Button query;
	
	StaffStateService staffStateService;
	public FileSelect(String name){
		
		setCaption(name);
		setModal(true);
		setWidth("650px");
		setHeight("600px");
		addComponent(buildVerticalLayout());
	}
	
	

	@Override
	public void attach() {
		super.attach();
		SpringContextHelper sch=new SpringContextHelper(this.getApplication());
		staffStateService=(StaffStateService) sch.getBean("staffStateServiceImpl");
		
	}



	private VerticalLayout buildVerticalLayout() {
		verticalLayout = new VerticalLayout();

		verticalLayout.addComponent(buildVHorizontalLayout());
		verticalLayout.addComponent(bLayout());
		return verticalLayout;

	}
	
	private HorizontalLayout buildVHorizontalLayout() {
		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(true);
		horizontalLayout.setSpacing(true);
		fileName=new TextField("档案名称");
		auditState=new MyDictComboBox("档案状态","007");
		fileType=new MyDictComboBox("档案类型","008");
		query=new Button("查询");
		horizontalLayout.addComponent(fileName);
		horizontalLayout.addComponent(auditState);
		horizontalLayout.addComponent(fileType);
		horizontalLayout.addComponent(query);
		horizontalLayout.setComponentAlignment(query, Alignment.BOTTOM_RIGHT);
		query.addListener(ClickEvent.class,this,"query");
		return horizontalLayout;

	}
	

	public void query(ClickEvent event){
		fileTable.removeAllItems();
		List<File> list=staffStateService.selectFile(getMap());
		fileTable.setItems(list);
	}

	private Map<String,Object> getMap(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("fileName", fileName.getValue());
		map.put("auditState", auditState.getValue());
		map.put("fileType", fileType.getValue());
		return map;
		
	}
	
	private VerticalLayout bLayout() {
		vLayout = new VerticalLayout();
		close = new Button("关闭");
		vLayout.addComponent(buidlFileTable());
		vLayout.addComponent(close);
		vLayout.setComponentAlignment(close, Alignment.BOTTOM_CENTER);
		close.addListener(ClickEvent.class, this, "close");
		return vLayout;

	}
	
	public void close(ClickEvent event) {
		getParent().removeWindow(getWindow());
	}
	
	private MyTable buidlFileTable(){
		BeanItemContainer<File> fileBean=new BeanItemContainer<File>(File.class);
		Object obj[] = { "fileCode", "fileName", "fileType", "fileDate",
				"fileUserID", "fileOutDate", "auditState", "fileLocation" };
		String str[] = { "档案编号", "档案名称", "档案类型", "编写时间", "编写人", "有效时间", "审核状态",
				"档案位置" };
		fileTable=new MyTable();
		fileTable.setHeight("360px");
		fileTable.setDateSource(fileBean);
		buildTableGeneratedColumn();
		fileTable.setColumns(obj);
		fileTable.setHeader(str);
		fileTable.addListener(ValueChangeEvent.class,this,"getFileTable");
		return fileTable;
		
	}
	
	private void buildTableGeneratedColumn(){
		fileTable.addGeneratedColumn("auditState", new MyGeneratorColumn(Dict.class));
		fileTable.addGeneratedColumn("fileType", new MyGeneratorColumn(Dict.class));
	}
	
	public void getFileTable(ValueChangeEvent event){
		if(fileTable.getValue()==null){return;}
		if(getCaption().equals("入职档案选择")){
			Entry.file=(File) fileTable.getValue();
			Entry.fileForm.setValue(Entry.file);
		}else if(getCaption().equals("离职档案选择")){
			Quit.file=(File) fileTable.getValue();
			Quit.fileForm.setValue(Quit.file);
		}
		
	}
}
