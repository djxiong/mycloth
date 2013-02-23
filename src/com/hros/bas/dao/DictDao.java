package com.hros.bas.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.bas.domain.DictInfo;

@Repository
public interface DictDao {
	public DictInfo selectDict(int id);
	
	public List<DictInfo> selectAllDictList();
	
	public List<DictInfo> selectDictByCode(String code);
	
	public void addDict(DictInfo dictInfo);
	
	public void updateDict(DictInfo dictInfo);
	
	public void deleteDict(int id);
}
