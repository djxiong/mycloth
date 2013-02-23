package com.hros.reccost.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.reccost.domain.RecCost;

@Repository
public interface RecCostDao {
	public List selectAllRecCost();
	
	public void insertRecCost(RecCost recCost);
	
	public void updateRecCost(RecCost recCost);
	
	public void deleteRecCost(int id);
}
