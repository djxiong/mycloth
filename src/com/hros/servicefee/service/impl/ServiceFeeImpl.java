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
		return "服务费编码,服务费名称".split(",");
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
		map.put("serviceFeeCode", new FieldAttr("服务费编码", "", 0));
		map.put("serviceFeeName", new FieldAttr("服务费名称", "", 0));
		map.put("dayFeeType", new FieldAttr("月结算方式", 
					"MyDictComboBox,月结算方式,007,false", 0));
		map.put("dayFee", new FieldAttr("月结算规则", "", 0));
//		map.put("monthFeeType", new FieldAttr("月费用方式", "", 0));
//		map.put("monthFee", new FieldAttr("月费用规则", "", 0));
		map.put("delayDay", new FieldAttr("延迟收费时间(天)", "", 0));
		map.put("isCalAttenDay", new FieldAttr("是否计算出勤天数比例", "", 0));
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
	 * 通过入离职信息计算单个员工的服务费
	 * @param entryDate		入职时间
	 * @param quitDate		离职时间
	 * @param accountDate	服务费结算时间
	 * @param wage			员工工资
	 * @param wholeMonthAccount		整月应收服务费
	 * @return
	 */
	public double getServiceFeeAccount(ServiceFee serviceFee, Date entryDate, 
			Date quitDate, Date accountDate, double wage, 
			double wholeMonthAccount) {
		//员工在职天数
		int inPosDay = getInPosDay(entryDate, quitDate, accountDate);
		//当月在职天数小于基础在职天数，不支付服务费
		if (inPosDay <= serviceFee.getDelayDay()) {
			return 0;
		}
		//按工资比例结算
		if (serviceFee.getDayFeeType() == "007001") {
			return getPercentAccount(wage, 
					PubLib.StrToFloat(serviceFee.getDayFee()));
		//按月进行结算
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
	 * 按工资百分比收取服务费
	 * @return
	 */
	private double getPercentAccount(double wage, double percent) {
		return wage * percent;
	}
	
	/**
	 * 按月付费结算方式
	 * @param inPosDay				当月在职天数
	 * @param defDay				收费界定天数
	 * @param defAccount			收费界定费用或比例
	 * @param defAttenDay			应出勤天数
	 * @param wholeMonthAccount		整月应收服务费
	 * @param isCalAttenDay			计算出勤天数比例
	 * @return						当月服务费
	 */
	private double getMonthAccount(int inPosDay, String[] defDay, 
			String[] defAccount, int defAttenDay, double wholeMonthAccount,
			boolean isCalAttenDay) {
		
		//计算是否在职天数是否小于界定天数
		for (int i = 0; i < defDay.length; i++) {
			if (inPosDay < PubLib.StrToFloat(defDay[i])) {
				if (PubLib.StrToFloat(defAccount[i]) < 1) {
					return PubLib.StrToFloat(defAccount[i]) * wholeMonthAccount;
				} else {
					return PubLib.StrToFloat(defAccount[i]);
				}
			}
		}
		
		//在职天数小于应出勤天数
		if (isCalAttenDay && inPosDay < defAttenDay) {
			return wholeMonthAccount * inPosDay / defAttenDay;
		}
		
		return wholeMonthAccount;
	}
	
	/**
	 * 获取员工在职天数
	 * @param entryDate		入职时间
	 * @param quitDate		离职时间
	 * @param accountDate	结算时间
	 * @return				在职天数
	 */
	public int getInPosDay(Date entryDate, Date quitDate, Date accountDate) {
		//结算月份不在入离职范围内
		if (PubLib.getMonthFirst(entryDate).getTime() > PubLib.getMonthLast(accountDate).getTime()
				|| PubLib.getMonthLast(quitDate).getTime() < PubLib.getMonthFirst(accountDate).getTime()) {
			return 0;
		//员工在职, 结算月份没有入离职发生
		} else if (PubLib.getMonthLast(entryDate).getTime()< PubLib.getMonthFirst(accountDate).getTime()
			&& PubLib.getMonthFirst(quitDate).getTime() > PubLib.getMonthLast(accountDate).getTime()) {
			return PubLib.getMonthDay(accountDate); 
		//入职和离职在同一个月
		} else if (PubLib.getMonthFirst(entryDate).getTime() == PubLib.getMonthFirst(quitDate).getTime()) {
			return PubLib.dateDiffDay(entryDate, quitDate);
		//入职月份结算
		} else if (PubLib.getMonthFirst(entryDate).getTime() == PubLib.getMonthFirst(accountDate).getTime()) {
			return PubLib.dateDiffDay(entryDate, accountDate);
		//离职月份结算
		} else if (PubLib.getMonthFirst(quitDate).getTime() == PubLib.getMonthFirst(accountDate).getTime()) {
			return quitDate.getDate();
		} else {
			return PubLib.getMonthDay(accountDate);
		}
		
	}
	
	/**
	 * 月度阶梯收费  暂没有使用
	 * @param serviceFee
	 * @param entryDate		入职时间
	 * @param quitDate		离职时间
	 * @param accountDate	结算时间
	 * @return				当月总费用
	 */
	private double getWholeMonthAccount(ServiceFee serviceFee, Date entryDate, 
			Date quitDate, Date accountDate) {
		String[] account = serviceFee.getMonthFee().split(";");
		if (account.length == 1) {
			return PubLib.StrToFloat(account[0]);
		} else if (account.length == 3) {
			Map<Integer, Double> costMap = costMap(account);
			Date endDate = quitDate.getTime()<accountDate.getTime()?quitDate:accountDate;
			//通过计算得出工作月份
			int workMonth = PubLib.dateDiffMonth(entryDate, endDate);
			//如果工作月份在MAP中，返回该月服务费，如果不在，取默认值
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
	 * 分解月份阶梯收费标准，得到对应的MAP
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
