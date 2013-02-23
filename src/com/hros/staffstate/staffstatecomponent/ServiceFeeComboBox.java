package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.hros.servicefee.domain.ServiceFee;
import com.hros.staffstate.service.StaffStateService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class ServiceFeeComboBox extends ComboBox {

	StaffStateService staffStateService;
	List<ServiceFee> serviceFee;
	int serviceFeeID = 0;
	final String SERVICEFEE_CATION = "name";

	public ServiceFeeComboBox(String caption) {
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
		serviceFee = staffStateService.selectServiceFee();
		getServiceFee();
		if (getValue() != null) {
			select(getValue());
		} else {
			select(serviceFeeID);
		}
	}

	private void getServiceFee() {
		addContainerProperty(SERVICEFEE_CATION, String.class, "");
		setItemCaptionPropertyId(SERVICEFEE_CATION);
		for (ServiceFee sFee : serviceFee) {
			if (serviceFeeID == 0) {
				serviceFeeID = sFee.getServiceFeeID();
			}
			if (this.getItemIds().contains(sFee.getServiceFeeID())) {
				continue;
			}
			addItem(sFee.getServiceFeeID()).getItemProperty(SERVICEFEE_CATION)
					.setValue(sFee.getServiceFeeName());
		}
	}

}
