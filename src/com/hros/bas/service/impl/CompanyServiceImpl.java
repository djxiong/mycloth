package com.hros.bas.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.service.BaseService;
import com.hros.company.dao.CompanyDao;
import com.hros.company.domain.Company;
import com.hros.vaadin.myComponent.FieldAttr;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.FormFieldFactory;

@Repository
@Transactional
public class CompanyServiceImpl implements BaseService {
	
	@Autowired
	private CompanyDao companyDao;

	@Override
	public Object getBeanItem() {
		return new Company();
	}

	@Override
	public Object[] getTableVisibleColumns() {
		return "compCode,compName,compLegalPerson,seq".split(",");
	}

	@Override
	public String[] getTableHeaders() {
		// TODO Auto-generated method stub
		return "编码,名称,负责人,排序".split(",");
	}

	@Override
	public Object[] getFormVisibleItems() {
		// TODO Auto-generated method stub
		return "compName,compCode,compLegalPerson,seq".split(",");
	}

	@Override
	public Map<String, FieldAttr> getFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("compName", new FieldAttr("名称", "", 0));
		map.put("compCode", new FieldAttr("编码", "", 0));
		map.put("compLegalPerson", new FieldAttr("负责人", "", 0));
		map.put("seq", new FieldAttr("排序", "", 0));
		return map;
	}

	@Override
	public List getTreeTableItems() {
		// TODO Auto-generated method stub
		return companyDao.selectAllComp();
	}

	@Override
	public Object saveNode(Object obj) {
		try {
			Company c = (Company) obj;
			if (c.getCompID() != 0) {
				companyDao.updateComp(c);
			} else {
				companyDao.insertComp(c);
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteNode(Object obj) {
		try {
			int i = (Integer) obj;
			companyDao.deleteCompById(i);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map getFieldName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "compID");
		map.put("fId", "fcompID");
		return map;
	}

}
