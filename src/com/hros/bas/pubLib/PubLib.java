package com.hros.bas.pubLib;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class PubLib {
	
	//字符串转化为日期
	public static Date strToDate(String s) {
		DateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dd.parse(s);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//当月的第一天
	public static Date getMonthFirst(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		return cal.getTime();
	}
	
	//当月的最后一天
	public static Date getMonthLast(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.DATE, -1);
		return cal.getTime();
	}
	
	//当前时间所在月份的天数
	public static int getMonthDay(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.DATE, -1);
		return cal.get(Calendar.DATE);
	}
	
	//获取两个时间之间间隔月份
	public static int dateDiffMonth(Date entryDate, Date accountDate) {
		Calendar startCal = new GregorianCalendar();
		Calendar endCal = new GregorianCalendar();
		startCal.setTime(entryDate);
		endCal.setTime(accountDate);
		
		int diffY = (endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR)) * 12;
		int diffM = (endCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH));
		int diffD = (endCal.get(Calendar.DAY_OF_MONTH) - startCal.get(Calendar.DAY_OF_MONTH));
		if (diffD > 0) {
			diffD = 1;
		} else if (diffD < 0) {
			diffD = -1;
		} else {
			diffD = 0;
		}
		
		return diffY+diffM+diffD;
	}
	
	
	//获取两个时间之间的间隔天数
	public static int dateDiffDay(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime()) {
			return -1;
		}
		double f = (date2.getTime()-date1.getTime())/(3600*24*1000);
		return (int) Math.floor(f) + 1;
	}
	
	//从对象中获取指定字段的值
	public static Object getObjFieldValue(Object obj, String field){
		try {
			Field f = getObjField(obj.getClass(), field);
			f.setAccessible(true);
			return f.get(obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//设置对象中字段的值
	public static void setObjFieldValue(Object obj, String field, Object value) {
		try {
			Field f = getObjField(obj.getClass(), field);
			f.setAccessible(true);
			f.set(obj, value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//将String转为integer
	public static int StrToInt(String str){
		int i;
		try {  
	        i = Integer.parseInt(str.trim());  
	    } catch (NumberFormatException e) {  
	        i = 0;
	    }
		return i;
	}
	
	//将String转为float
	public static Double StrToFloat(String str){
		Double i;
		try {  
			i = Double.parseDouble(str.trim());  
		} catch (NumberFormatException e) {  
			i = (double) 0;
		}
		return i;
	}
	
	//将obj转化成Str
	public static String ObjToStr(Object obj) {
		if (obj != null) {
			return obj.toString();
		} else {
			return "";
		}
	}
	
	//Str首字母大写
	public static String fCharToUpper(String str){
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}
	
	//反映射Object中的field
	public static Field getObjField(Class cls,String f) {
		try {
			return cls.getDeclaredField(f);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cls!=Object.class){
			return getObjField(cls.getSuperclass(), f);
		} else {
			return null;
		}
	}
	
	//Map中key对应Object字段值转换为Array
	public static Object[] getItemByObj(Map<String, ?> map, Object obj) {
		Object[] cells = new Object[map.size()];
		int i = 0;
		for (Map.Entry<String, ?> entry : map.entrySet()) {
			cells[i] = PubLib.getObjFieldValue(obj, entry.getKey());
			i++;
		}
		return cells;
	}
	
	//通过链表得到组装的数据集
	public static Object[] getItemByObj(Collection<?> containerPropertyIds, Object obj) {
		Object[] cells = new Object[containerPropertyIds.size()];
		Iterator it = containerPropertyIds.iterator();
		for (int i=0; i < containerPropertyIds.size(); i++) {
			cells[i] = PubLib.getObjFieldValue(obj,it.next().toString());
		}
		return cells;
	}
	
	//根据field的类型判断返回不同的CLASS
	public static Class<?> getClsByField(Field f){
		if (String.class.equals(f.getType())) {
			return String.class;
		} else if (int.class.equals(f.getType()) || Integer.class.equals(f.getType())) {
			return Integer.class;
		} else if (double.class.equals(f.getType()) || Double.class.equals(f.getType())) {
			return Double.class;
		} else if (boolean.class.equals(f.getType()) || Boolean.class.equals(f.getType())) {
			return Boolean.class;
		} else if (Date.class.equals(f.getType())) {
			return Date.class;
		} else {
			return Object.class;
		}
	}
}
