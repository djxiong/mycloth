package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.hros.reccost.domain.RecCost;
import com.hros.staffstate.service.StaffStateService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class RecComboBox extends ComboBox {

	StaffStateService staffStateService;
	List<RecCost> recList;
	int recCostId = 0;
	final String RECCOST_CAPTION = "name";

	public RecComboBox(String caption) {
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
		recList = staffStateService.selectRecCost();
		getRecCost();
		if (getValue() != null) {
			select(getValue());
		} else {
			select(recCostId);
		}
	}

	private void getRecCost() {
		addContainerProperty(RECCOST_CAPTION, String.class, "");
		setItemCaptionPropertyId(RECCOST_CAPTION);
		for (RecCost recost : recList) {
			if (recCostId == 0) {
				recCostId = recost.getRecId();
			}
			if (this.getItemIds().contains(recost.getRecId())) {
				continue;
			}
			addItem(recost.getRecId()).getItemProperty(RECCOST_CAPTION)
					.setValue(recost.getRecName());
		}
	}

}
