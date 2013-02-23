package com.hros.bas.service;

import java.util.List;
import java.util.Map;

import com.hros.bas.domain.DictInfo;

public interface DictService {
	public List<DictInfo> selectDiceByCode(String code);
	
	public Map<String, DictInfo> getAllDict();
}
