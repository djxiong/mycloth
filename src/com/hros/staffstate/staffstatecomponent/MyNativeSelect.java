package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.vaadin.ui.NativeSelect;

@SuppressWarnings("serial")
public class MyNativeSelect extends NativeSelect{

	public MyNativeSelect(){
		
	}
	public MyNativeSelect(String width,String height,List<?> list){
		setImmediate(false);
		setWidth(width);
		setHeight(height);
		setNullSelectionAllowed(false);
		for(int i=0;i<list.size();i++){
			addItem(list.get(i));
		}
	}
}
