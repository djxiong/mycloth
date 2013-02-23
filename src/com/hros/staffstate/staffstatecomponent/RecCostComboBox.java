package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.hros.staffstate.service.StaffStateService;
import com.hros.user.domain.UserInfo;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class RecCostComboBox extends ComboBox {

	StaffStateService staffStateService;
	List<UserInfo> list;
	int userID = 0;
	final String USER_CAPTION = "name";

	public RecCostComboBox(String caption) {
		this.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		this.setImmediate(true);
		this.setNullSelectionAllowed(false);
		this.setCaption(caption);
	}

	@Override
	public void attach() {
		super.attach();
		SpringContextHelper sct = new SpringContextHelper(this.getApplication());
		staffStateService = (StaffStateService) sct
				.getBean("staffStateServiceImpl");
		list = staffStateService.selectUser();
		getUser();
		if (getValue() != null) {
			select(getValue());
		} else {
			select(userID);
		}

	}

	private void getUser() {
		addContainerProperty(USER_CAPTION, String.class, "");
		setItemCaptionPropertyId(USER_CAPTION);
		for (UserInfo user : list) {
			if (userID != 0) {
				userID = user.getUserID();
			}
			if (this.getItemIds().contains(user.getUserID())) {
				continue;
			}
			addItem(user.getUserID()).getItemProperty(USER_CAPTION).setValue(
					user.getUserName());
		}
	}

}
