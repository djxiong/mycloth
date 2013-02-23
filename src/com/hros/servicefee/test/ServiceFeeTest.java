package com.hros.servicefee.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.bas.pubLib.PubLib;
import com.hros.servicefee.service.impl.ServiceFeeImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class ServiceFeeTest {
	
	@Resource
	ServiceFeeImpl serviceFeeImpl;
	
	@Test
	public void getInPosDay(){
		Date entryDate = PubLib.strToDate("2012-2-20");
		Date quitDate = PubLib.strToDate("2012-2-25");
		Date accountDate = PubLib.strToDate("2012-3-30");
		int i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("��ְ����ְ��С�ڽ���ʱ��,�Ҳ��ڽ�����====0=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-3-30");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("������ְ�½���=====31=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-4-30");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("������ְ�½���=====30=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-2-28");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("��ְ�½���======9=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-5-30");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("��ְ�½���=====25=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-6-30");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("����ְԱ������ְ�º������½���======0=" + i);
		entryDate = PubLib.strToDate("2012-2-20");
		quitDate = PubLib.strToDate("2012-5-25");
		accountDate = PubLib.strToDate("2012-1-30");
		i = serviceFeeImpl.getInPosDay(entryDate, quitDate, accountDate);
		System.out.println("δ��ְ֮ǰ�·ݽ���======0=" + i);
	}
}