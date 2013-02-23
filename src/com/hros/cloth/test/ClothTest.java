package com.hros.cloth.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.cloth.dao.ClothDao;
import com.hros.cloth.dao.Customer2Dao;
import com.hros.cloth.dao.OrderHistoryDao;
import com.hros.cloth.domain.Cloth;
import com.hros.cloth.domain.Customer2;
import com.hros.cloth.domain.OrderHistory;
import com.hros.cloth.service.ClothService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class ClothTest {
	
	@Autowired
	private ClothDao clothDao;
	
	@Autowired
	private OrderHistoryDao orderHistoryDao;
	
	@Autowired
	private Customer2Dao customer2Dao;
	
	@Autowired
	private ClothService clothService;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Test
	public void addCloth(){
		Cloth cloth = new Cloth();
		cloth.setName("测试");
		cloth.setBarCode("sdf");
		cloth.setColor(1111);
		cloth.setCount(25);
		cloth.setOriginalPrice(111.23f);
		cloth.setPrice(1123.3f);
		cloth.setSalesOff(222.3f);
		cloth.setSalesOffType("sdfsd");
		cloth.setSize("s");
		cloth.setStockDate(new Date());
		clothDao.insertCloth(cloth);
	}
	
	@Test
	public void addCustomer(){
		Customer2 customer = new Customer2();
		customer.setName("士大夫");
		customer.setPhone("sdfsdf");
		customer2Dao.insertCustomer(customer);
		
	}
	@Test
	public void delCloth(){
		clothDao.deleteCloth(3);
	}
	
	@Test
	public void findClothsByBarCode(){
		List<Cloth> result = clothDao.findClothsByBarCode("b");
		log.debug("findClothsByBarCode---------------------------------"+result);
	}
	@Test
	public void findClothsByName(){
		List<Cloth> result = clothDao.findClothsByName("新建");
		log.debug("findClothsByName---------------------------------"+result);
	}
	@Test
	public void addOrderHistory(){
		OrderHistory history = new OrderHistory();
		history.setClothID(1);
		history.setCustomerID(1);
		history.setConsumeDate(new Date());
		history.setConsumption(100f);
		orderHistoryDao.insertOrderHistory(history);
	}
	
	@Test
	public void findOrderHistoryBetweenDate(){
		Map map = new HashMap();
		map.put("startDate", "2012-12-11");
		map.put("endDate", "2012-12-15");
		List<OrderHistory> results = orderHistoryDao.findOrderHistoryBetweenDate(map);
		log.debug("--------------------------------"+results);
	}
	
	@Test
	public void getTotalConsumption(){
		float total = clothService.getTotalConsumption(17, 0f);
		log.debug("total--------------------------------"+total);
	}
}
