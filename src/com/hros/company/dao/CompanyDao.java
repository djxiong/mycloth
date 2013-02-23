package com.hros.company.dao;

import java.util.List;

import com.hros.company.domain.Company;

public interface CompanyDao {
	public List<Company> selectAllComp();
	public Company selectCompById(int compID);
	public void insertComp(Company comp);
	public void updateComp(Company comp);
	public void deleteCompById(int compID);
}
