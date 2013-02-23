package com.hros.servicefee.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hros.bas.domain.DictInfo;
import com.hros.bas.pubLib.PubLib;
import com.hros.bas.service.BaseService;
import com.hros.servicefee.dao.ServiceFeeDao;
import com.hros.servicefee.domain.ServiceFee;
import com.hros.vaadin.myComponent.FieldAttr;

@Repository
@Transactional
public class ServiceFeeImpl implements BaseService {
	
	@Autowired
	private ServiceFeeDao serviceFeeDao;

	@Override
	public Object getBeanItem() {
		return new ServiceFee();
	}

	@Override
	public Object[] getTableVisibleColumns() {
		return "serviceFeeCode,serviceFeeName".split(",");
	}

	@Override
	public String[] getTableHeaders() {
		return "����ѱ���,���������".split(",");
	}

	@Override
	public Object[] getFormVisibleItems() {
		String s = "serviceFeeCode,serviceFeeName,dayFeeType," +
				"dayFee,delayDay,isCalAttenDay";
		return s.split(",");
	}

	@Override
	public Map<String, FieldAttr> getFactoryMap() {
		Map<String, FieldAttr> map = new HashMap<String, FieldAttr>();
		map.put("serviceFeeCode", new FieldAttr("����ѱ���", "", 0));
		map.put("serviceFeeName", new FieldAttr("���������", "", 0));
		map.put("dayFeeType", new FieldAttr("�½��㷽ʽ", 
					"MyDictComboBox,�½��㷽ʽ,007,false", 0));
		map.put("dayFee", new FieldAttr("�½������", "", 0));
//		map.put("monthFeeType", new FieldAttr("�·��÷�ʽ", "", 0));
//		map.put("monthFee", new FieldAttr("�·��ù���", "", 0));
		map.put("delayDay", new FieldAttr("�ӳ��շ�ʱ��(��)", "", 0));
		map.put("isCalAttenDay", new FieldAttr("�Ƿ���������������", "", 0));
		return map;
	}

	@Override
	public List getTreeTableItems() {
		return serviceFeeDao.selectAllServiceFee();
	}

	@Override
	public Object saveNode(Object obj) {
		ServiceFee c = (ServiceFee) obj;
		if (c.getServiceFeeID() != 0) {
			serviceFeeDao.updateServiceFee(c);
		} else {
			serviceFeeDao.insertServiceFee(c);
		}
		return obj;
	}

	@Override
	public boolean deleteNode(Object obj) {
		try {
			int i = (Integer) obj;
			serviceFeeDao.deleteServiceFee(i);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Map getFieldName() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "serviceFeeID");
		return map;
	}
	
	/**
	 * ͨ������ְ��Ϣ���㵥��Ա���ķ����
	 * @param entryDate		��ְʱ��
	 * @param quitDate		��ְʱ��
	 * @param accountDate	����ѽ���ʱ��
	 * @param wage			Ա������
	 * @param wholeMonthAccount		����Ӧ�շ����
	 * @return
	 */
	public double getServiceFeeAccount(ServiceFee serviceFee, Date entryDate, 
			Date quitDate, Date accountDate, double wage, 
			double wholeMonthAccount) {
		//Ա����ְ����
		int inPosDay = getInPosDay(entryDate, quitDate, accountDate);
		//������ְ����С�ڻ�����ְ��������֧�������
		if (inPosDay <= serviceFee.getDelayDay()) {
			return 0;
		}
		//�����ʱ�������
		if (serviceFee.getDayFeeType() == "007001") {
			return getPercentAccount(wage, 
					PubLib.StrToFloat(serviceFee.getDayFee()));
		//���½��н���
		} else if (serviceFee.getDayFeeType() == "007002"){
			String[] s = serviceFee.getDayFee().split(";");
			if (s.length < 2) {
				return PubLib.StrToFloat(serviceFee.getMonthFee());
			}
			return getMonthAccount(inPosDay, s[0].split(","), s[1].split(","), 
					serviceFee.getDelayDay(), 
					PubLib.StrToFloat(serviceFee.getMonthFee()),
					serviceFee.isCalAttenDay());
		}
		return 0;
	}
	
	/**
	 * �����ʰٷֱ���ȡ�����
	 * @return
	 */
	private double getPercentAccount(double wage, double percent) {
		return wage * percent;
	}
	
	/**
	 * ���¸��ѽ��㷽ʽ
	 * @param inPosDay				������ְ����
	 * @param defDay				�շѽ綨����
	 * @param defAccount			�շѽ綨���û����
	 * @param defAttenDay			Ӧ��������
	 * @param wholeMonthAccount		����Ӧ�շ����
	 * @param isCalAttenDay			���������������
	 * @return						���·����
	 */
	private double getMonthAccount(int inPosDay, String[] defDay, 
			String[] defAccount, int defAttenDay, double wholeMonthAccount,
			boolean isCalAttenDay) {
		
		//�����Ƿ���ְ�����Ƿ�С�ڽ綨����
		for (int i = 0; i < defDay.length; i++) {
			if (inPosDay < PubLib.StrToFloat(defDay[i])) {
				if (PubLib.StrToFloat(defAccount[i]) < 1) {
					return PubLib.StrToFloat(defAccount[i]) * wholeMonthAccount;
				} else {
					return PubLib.StrToFloat(defAccount[i]);
				}
			}
		}
		
		//��ְ����С��Ӧ��������
		if (isCalAttenDay && inPosDay < defAttenDay) {
			return wholeMonthAccount * inPosDay / defAttenDay;
		}
		
		return wholeMonthAccount;
	}
	
	/**
	 * ��ȡԱ����ְ����
	 * @param entryDate		��ְʱ��
	 * @param quitDate		��ְʱ��
	 * @param accountDate	����ʱ��
	 * @return				��ְ����
	 */
	public int getInPosDay(Date entryDate, Date quitDate, Date accountDate) {
		//�����·ݲ�������ְ��Χ��
		if (PubLib.getMonthFirst(entryDate).getTime() > PubLib.getMonthLast(accountDate).getTime()
				|| PubLib.getMonthLast(quitDate).getTime() < PubLib.getMonthFirst(accountDate).getTime()) {
			return 0;
		//Ա����ְ, �����·�û������ְ����
		} else if (PubLib.getMonthLast(entryDate).getTime()< PubLib.getMonthFirst(accountDate).getTime()
			&& PubLib.getMonthFirst(quitDate).getTime() > PubLib.getMonthLast(accountDate).getTime()) {
			return PubLib.getMonthDay(accountDate); 
		//��ְ����ְ��ͬһ����
		} else if (PubLib.getMonthFirst(entryDate).getTime() == PubLib.getMonthFirst(quitDate).getTime()) {
			return PubLib.dateDiffDay(entryDate, quitDate);
		//��ְ�·ݽ���
		} else if (PubLib.getMonthFirst(entryDate).getTime() == PubLib.getMonthFirst(accountDate).getTime()) {
			return PubLib.dateDiffDay(entryDate, accountDate);
		//��ְ�·ݽ���
		} else if (PubLib.getMonthFirst(quitDate).getTime() == PubLib.getMonthFirst(accountDate).getTime()) {
			return quitDate.getDate();
		} else {
			return PubLib.getMonthDay(accountDate);
		}
		
	}
	
	/**
	 * �¶Ƚ����շ�  ��û��ʹ��
	 * @param serviceFee
	 * @param entryDate		��ְʱ��
	 * @param quitDate		��ְʱ��
	 * @param accountDate	����ʱ��
	 * @return				�����ܷ���
	 */
	private double getWholeMonthAccount(ServiceFee serviceFee, Date entryDate, 
			Date quitDate, Date accountDate) {
		String[] account = serviceFee.getMonthFee().split(";");
		if (account.length == 1) {
			return PubLib.StrToFloat(account[0]);
		} else if (account.length == 3) {
			Map<Integer, Double> costMap = costMap(account);
			Date endDate = quitDate.getTime()<accountDate.getTime()?quitDate:accountDate;
			//ͨ������ó������·�
			int workMonth = PubLib.dateDiffMonth(entryDate, endDate);
			//��������·���MAP�У����ظ��·���ѣ�������ڣ�ȡĬ��ֵ
			if (costMap.containsKey(workMonth)) {
				return costMap.get(workMonth);
			} else {
				return PubLib.StrToFloat(account[3]);
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * �ֽ��·ݽ����շѱ�׼���õ���Ӧ��MAP
	 * @param account
	 * @return
	 */
	private Map<Integer, Double> costMap(String[] account) {
		if (account.length < 3) {
			return null;
		}
		
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		String[] monthArr = account[0].split(",");
		String[] costArr = account[1].split(",");
		
		for (int i = 0; i<monthArr.length; i++) {
			map.put(PubLib.StrToInt(monthArr[i]), PubLib.StrToFloat(costArr[i]));
		}
		
		return map;
	}

}
