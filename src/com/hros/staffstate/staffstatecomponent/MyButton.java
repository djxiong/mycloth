package com.hros.staffstate.staffstatecomponent;

import com.vaadin.ui.Button;

@SuppressWarnings("serial")
public class MyButton extends Button{

	public MyButton(){
		
	}
	
	public MyButton(String caption,String width,String height){
		setCaption(caption);
		setImmediate(true);
		setWidth(width);
		setHeight(height);
	}
}
