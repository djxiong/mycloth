package com.hros.cloth.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hros.cloth.domain.Cloth;


@Repository
public interface ClothDao {

	Cloth getClothByID(Integer id);
	
	void updateCloth(Cloth cloth);
	
	void insertCloth(Cloth cloth);
	
	void deleteCloth(Integer id);
	
	List<Cloth> getAllClothes();
	
	Cloth getClothByBarCode(String barCode);
	
	List<Cloth> findClothsByBarCode(String barCode);
	
	List<Cloth> findClothsByName(String name);
	
	/**
	 * 库存,即剩余数量大于1
	 * @param name
	 * @return
	 */
	List<Cloth> getRemainCloths();
}
