package com.hros.vaadin.myComponent;

import com.hros.bas.pubLib.PubUtil;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;

@SuppressWarnings("serial")
public class MsgWin implements Window.CloseListener {
	Boolean result;
	
	Window myWin;
	
	final Button btnOk = new Button("ȷ��");
	
	final Button btnCalcel = new Button("ȡ��");
	
	final GridLayout grid = new GridLayout(2, 3);
	
	public Boolean buildMsg(String title, String msg, int msgType){
		myWin = new Window(title);
		myWin.setPositionX(200);
		myWin.setPositionY(100);
		myWin.addListener(this);

		grid.addComponent(new Label(msg), 0,1, 0,2);
		myWin.addComponent(grid);
		grid.setSpacing(true);
		
		String icon = "";
		
		switch (msgType) {
		//��ʾ��Ϣ����
		case 1:
			grid.addComponent(btnOk, 1,1);
			icon = PubUtil.RUNO_ICON_WARNING;
			break;
		//����������ȷ������
		default:
			grid.addComponent(btnOk, 1,1);
			grid.addComponent(btnCalcel, 1,2);
			icon = PubUtil.RUNO_ICON_HELP;
			break;
		}
		
		Embedded eIcon = new Embedded(null, new ThemeResource(icon));
		grid.addComponent(eIcon);
		return result;
	}
	
	public void btnClickEvent(ClickEvent event) {
		if (event.getButton().getCaption().equals("ȷ��")) {
			result = true;
		} else if (event.getButton().getCaption().equals("ȡ��")) {
			result = false;
		}
	}

	@Override
	public void windowClose(CloseEvent e) {
		// TODO Auto-generated method stub
		result = false;
	}
}
