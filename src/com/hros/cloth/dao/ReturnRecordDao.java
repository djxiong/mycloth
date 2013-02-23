package com.hros.cloth.dao;

import java.util.List;
import java.util.Map;

import com.hros.cloth.domain.ReturnRecord;



public interface ReturnRecordDao {

	ReturnRecord getReturnRecordByID(Integer id);
	
	void updateReturnRecord(ReturnRecord returnRecord);
	
	void insertReturnRecord(ReturnRecord returnRecord);
	
	void deleteReturnRecord(Integer id);
	
	List<ReturnRecord> findReturnRecordBetweenDate(Map map);
}
