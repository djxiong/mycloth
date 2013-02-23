package com.hros.staffstate.staffstatecomponent;

import com.vaadin.ui.Label;

@SuppressWarnings("serial")
public class MyLabel extends Label{

	public MyLabel() {
		// TODO Auto-generated constructor stub
	}

	public MyLabel(String width,String height,String value){
		setImmediate(false);
		setWidth(width);
		setHeight(height);
		setValue(value);
	}
}
