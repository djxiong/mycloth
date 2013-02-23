package com.hros.bas.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.dao.DictDao;
import com.hros.bas.domain.DictInfo;
import com.hros.bas.service.BaseService;
import com.hros.bas.service.DictService;
import com.hros.company.domain.Company;
import com.hros.vaadin.myComponent.FieldAttr;

@Repository
@Transactional
public class DictServiceImpl implements BaseService, DictService {
	
	@Autowired
	private DictDao dictDao;

	@Override
	public Object getBeanItem() {
		return new DictInfo();
	}

	@Override
	public Object[] getTableVisibleColumns() {
		return "dictCode,dictName,seq".split(",");
	}

	@Override
	public String[] getTableHeaders() {
		return "±àÂë,Ãû³Æ,ÅÅÐò".split(",");
	}

	@Override
	public Object[] getFormVisibleItems() {
		return "dictCode,dictName,seq".split(",");
	}

	@Override
	public Map<String, FieldAttr> getFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("dictCode", new FieldAttr("±àÂë", "", 0));
		map.put("dictName", new FieldAttr("Ãû³Æ", "", 0));
		map.put("seq", new FieldAttr("ÅÅÐò", "", 0));
		return map;
	}

	@Override
	public List getTreeTableItems() {
		return dictDao.selectAllDictList();
	}

	@Override
	public Object saveNode(Object obj) {
		try {
			DictInfo c = (DictInfo) obj;
			if (c.getDictID() != 0) {
				dictDao.updateDict(c);
			} else {
				dictDao.addDict(c);
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
			dictDao.deleteDict(i);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map getFieldName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "dictID");
		map.put("fId", "fDictID");
		return map;
	}

	@Override
	public List<DictInfo> selectDiceByCode(String code) {
		return dictDao.selectDictByCode(code);
	}

	@Override
	public Map<String, DictInfo> getAllDict() {
		List<DictInfo> list = dictDao.selectAllDictList();
		Map<String, DictInfo> map = new LinkedHashMap<String, DictInfo>();
		for (DictInfo dict: list) {
			map.put(dict.getDictCode(), dict);
		}
		return map;
	}
}
