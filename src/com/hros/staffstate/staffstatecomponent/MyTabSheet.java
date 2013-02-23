package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MyTabSheet extends TabSheet{

	VerticalLayout vLayout;
	
	public MyTabSheet(){

	}
	
	public MyTabSheet(List<List> list){
		setHeight("100%");
		for(int i=0;i<list.size();i++){
			vLayout=new VerticalLayout();
			vLayout.addComponent((Component) list.get(i).get(0));
			addTab(vLayout, list.get(i).get(1).toString());
		}
	}
	
}
