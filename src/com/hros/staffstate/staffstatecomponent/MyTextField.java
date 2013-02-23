package com.hros.staffstate.staffstatecomponent;

import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class MyTextField extends TextField{
	
	public MyTextField(){
		
	}
	
	public MyTextField(String caption, String width,String height){
		setCaption(caption);
		setImmediate(false);
		setWidth(width);
		setHeight(height);
		setSecret(false);
	}

}
