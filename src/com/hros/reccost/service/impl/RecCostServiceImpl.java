package com.hros.reccost.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.service.BaseService;
import com.hros.reccost.dao.RecCostDao;
import com.hros.reccost.domain.RecCost;
import com.hros.vaadin.myComponent.FieldAttr;

@Repository
@Transactional
public class RecCostServiceImpl implements BaseService {
	
	@Autowired
	private RecCostDao recCostDao;

	@Override
	public Object getBeanItem() {
		return new RecCost();
	}

	@Override
	public Object[] getTableVisibleColumns() {
		return "recName,costAccount,isDisposable".split(",");
	}

	@Override
	public String[] getTableHeaders() {
		return "名称,费用,是否一次性支付".split(",");
	}

	@Override
	public Object[] getFormVisibleItems() {
		return "recName,costAccount,isDisposable".split(",");
	}

	@Override
	public Map<String, FieldAttr> getFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("recName", new FieldAttr("名称", "", 0));
		map.put("costAccount", new FieldAttr("费用", "", 0));
		map.put("isDisposable", new FieldAttr("是否一次性支付", "", 0));
		return map;
	}

	@Override
	public List getTreeTableItems() {
		return recCostDao.selectAllRecCost();
	}

	@Override
	public Object saveNode(Object obj) {
		RecCost rec = (RecCost)obj;
		if (rec.getRecId() != 0) {
			recCostDao.updateRecCost(rec);
		} else {
			recCostDao.insertRecCost(rec);
		}
		return obj;
	}

	@Override
	public boolean deleteNode(Object obj) {
		int i = (Integer) obj;;
		try{
			recCostDao.deleteRecCost(i);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map getFieldName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "recId");
		map.put("fId", "recFid");
		return map;
	}

}
