package com.hros.staffstate.staffstatecomponent;

import java.util.List;

import com.hros.insurance.domain.InsuranceInfo;
import com.hros.staffstate.service.StaffStateService;
import com.hros.vaadin.SpringContextHelper;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class InsuranceComboBox extends ComboBox {

	StaffStateService staffStateService;
	List<InsuranceInfo> insurance;
	int insuranceID = 0;
	final String INSURANCE_CATION = "name";

	public InsuranceComboBox(String caption) {
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
		insurance = staffStateService.selectInsurance();
		getInsurance();
		if (getValue() != null) {
			select(getValue());
		} else {
			select(insuranceID);
		}
	}

	private void getInsurance() {
		addContainerProperty(INSURANCE_CATION, String.class, "");
		setItemCaptionPropertyId(INSURANCE_CATION);
		for (InsuranceInfo insuranceInfo : insurance) {			
			if (insuranceID == 0) {
				insuranceID = insuranceInfo.getInsuranceID();
			}
			if (this.getItemIds().contains(insuranceInfo.getInsuranceID())) {
				continue;
			}
			addItem(insuranceInfo.getInsuranceID()).getItemProperty(
					INSURANCE_CATION)
					.setValue(insuranceInfo.getInsuranceName());
		}
	}

}
