package com.hros.bas.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.company.domain.Company;
import com.hros.customer.domain.Customer;
import com.hros.customer.domain.CustomerContactPerson;
import com.hros.servicefee.domain.ServiceFee;

@RunWith(SpringJUnit4ClassRunner.class)
public class GetBaseSql {
	
	private String getInsertSql(Object obj) {
		String s = "insert into table (";
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		for (Field f:obj.getClass().getDeclaredFields()) {
			list1.add(f.getName());
			list2.add("#{" + f.getName() + "}"); 
		}
		return s + list1.toString() + ") values (" + list2.toString() + ")";
	}
	
	private String getUpdateSql(Object obj) {
		String s = "update table set ";
		List list1 = new ArrayList();
		for (Field f:obj.getClass().getDeclaredFields()) {
			list1.add(f.getName() + "=#{" + f.getName() + "}" );
		}
		return s + list1.toString();
	}
	
	@Test
	public void getBaseSql() {
		ServiceFee obj = new ServiceFee();
		System.out.println(getInsertSql(obj));
		System.out.println(getUpdateSql(obj));
	}

}
