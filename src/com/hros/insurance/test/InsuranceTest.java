package com.hros.insurance.test;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hros.insurance.dao.InsuranceHistoryDao;
import com.hros.insurance.domain.InsuranceDetailInfo;
import com.hros.insurance.domain.InsuranceHistoryInfo;
import com.hros.insurance.domain.InsuranceInfo;
import com.hros.insurance.service.InsuranceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
public class InsuranceTest {
	
	@Autowired
	private InsuranceService insuranceService;
	
	@Autowired
	private InsuranceHistoryDao insuranceHistoryDao;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	//@Test
	public void addInsuranceDetail(){
		InsuranceDetailInfo insuranceDetailInfo = new InsuranceDetailInfo();
		//insuranceDetailInfo.setInsurance(insurance);
		insuranceDetailInfo.setInsuranceDetailName("养老保险");
		insuranceDetailInfo.setBase(1786.55F);
		insuranceDetailInfo.setCompanyRate(0.14F);
		insuranceDetailInfo.setPersonalRate(0.08F);
		
		InsuranceInfo insuranceInfo = new InsuranceInfo();
		insuranceInfo.setInsuranceName("杭州市社保（基本城镇五险）");
		insuranceService.addInsurance(insuranceInfo);
		log.info("insuranceInfo id = "+insuranceInfo.getInsuranceID());
		
		insuranceDetailInfo.setInsuranceID(1);
		
		insuranceService.addInsuranceDetail(insuranceDetailInfo);
	}
	
	//@Test
	public void addInsurance(){
		InsuranceInfo insuranceInfo = new InsuranceInfo();
		insuranceInfo.setInsuranceName("cascade");
		
		InsuranceDetailInfo insuranceDetailInfo = new InsuranceDetailInfo();
		//insuranceDetailInfo.setInsurance(insurance);
		insuranceDetailInfo.setInsuranceDetailName("child");
		insuranceDetailInfo.setBase(1786.55F);
		insuranceDetailInfo.setCompanyRate(0.14F);
		insuranceDetailInfo.setPersonalRate(0.08F);
		
		insuranceInfo.addInsuranceDetailInfo(insuranceDetailInfo);
		
		insuranceService.addInsurance(insuranceInfo);
		
	}
	
	//@Test
	public void updateInsurance(){
		
		InsuranceInfo insuranceInfo = insuranceService.getInsuranceByID(12);
		insuranceInfo.setInsuranceName("updated");
		insuranceService.updateInsurance(insuranceInfo);
		log.info("update successfully");
			
	}
	//@Test
	public void updateDetail(){
		InsuranceDetailInfo detail = insuranceService.getInsuranceDetailByID(12);
		detail.setBase(111111f);
		insuranceService.updateInsuranceDetail(detail);
		log.info("update successfully");
	}
	//@Test
    public void getInsuranceByID(){
		InsuranceInfo insuranceInfo = insuranceService.getInsuranceByID(1);
		log.info(insuranceInfo);
	}
	
	//@Test
    public void getInsuranceDetailByID(){
		InsuranceDetailInfo insuranceDetailInfo = insuranceService.getInsuranceDetailByID(1);
		log.info(insuranceDetailInfo);
	}
	//@Test
	public void getDetailForInsurance(){
		List<InsuranceDetailInfo> details = insuranceService.selectDetailsForInsurance(1);
		log.info(details);
	}
	//@Test
	public void addInsuranceHistory(){
		InsuranceDetailInfo insuranceDetailInfo = new InsuranceDetailInfo();
		//insuranceDetailInfo.setInsurance(insurance);
		insuranceDetailInfo.setInsuranceDetailName("养老保险");
		insuranceDetailInfo.setBase(1786.55F);
		insuranceDetailInfo.setCompanyRate(0.14F);
		insuranceDetailInfo.setPersonalRate(0.08F);
		
		InsuranceHistoryInfo historyInfo = new InsuranceHistoryInfo();
		historyInfo.setDetail(insuranceDetailInfo);
		historyInfo.setDestDate(new Date());
		historyInfo.setPayDate(new Date());
		historyInfo.setStaffManageID(55);
		
		insuranceHistoryDao.insertInsuranceHistory(historyInfo);
		
		
	}
	@Test
	 public void getInsuranceHistoryByID(){
		InsuranceHistoryInfo insuranceHistoryInfo = insuranceService.getInsuranceHistoryByID(1);
		log.info(insuranceHistoryInfo);
		}
	//@Test
	public void updateInsuranceHistory(){
		InsuranceDetailInfo insuranceDetailInfo = new InsuranceDetailInfo();
		//insuranceDetailInfo.setInsurance(insurance);
		insuranceDetailInfo.setInsuranceDetailName("养老保险2");
		insuranceDetailInfo.setBase(17816.55F);
		insuranceDetailInfo.setCompanyRate(10.14F);
		insuranceDetailInfo.setPersonalRate(10.08F);
		
		InsuranceHistoryInfo historyInfo =  insuranceHistoryDao.getInsuranceHistoryByID(1);;
		historyInfo.setDetail(insuranceDetailInfo);
		historyInfo.setDestDate(new Date());
		historyInfo.setPayDate(new Date());
		historyInfo.setStaffManageID(577);
		
		insuranceHistoryDao.updateInsuranceHistory(historyInfo);
		
		
	}
}
