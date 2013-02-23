package com.hros.file.domain;

/***********************************************************************
 * Module:  File.java
 * Author:  Administrator
 * Purpose: Defines the Class File
 ***********************************************************************/

import java.util.*;

import com.hros.staffstate.domain.StaffState;

/**
 * 档案。
 * 
 * @pdOid
 */
public class File {
	/**
	 * fileID。
	 * 
	 * @pdOid
	 */
	public int fileID;
	/**
	 * 档案编号。
	 * 
	 * @pdOid
	 */
	public String fileCode="";
	/**
	 * 档案名称。
	 * 
	 * @pdOid
	 */
	public String fileName="";
	/**
	 * 档案类型。
	 * 
	 * @pdOid
	 */
	public String fileType="";
	/**
	 * 编写时间。
	 * 
	 * @pdOid
	 */
	public Date fileDate;
	/**
	 * 编写人。
	 * 
	 * @pdOid
	 */
	public int fileUserID;
	/**
	 * 有效时间。
	 * 
	 * @pdOid
	 */
	public Date fileOutDate;
	/**
	 * 档案管理员。
	 * 
	 * @pdOid
	 */
	public int fileManagerID;
	/**
	 * 审核员。
	 * 
	 * @pdOid
	 */
	public int fileExamineID;
	/**
	 * 状态。
	 * 
	 * @pdOid
	 */
	public String auditState="";
	/**
	 * 电子档。
	 * 
	 * @pdOid
	 */
	public String electronicFile="";
	/**
	 * 扫描件。
	 * 
	 * @pdOid
	 */
	public String scanningElement="";
	/**
	 * 档案位置。
	 * 
	 * @pdOid
	 */
	public String fileLocation="";

	/**
	 * @pdRoleInfo migr=no name=StaffState assc=EntryFileMapping
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public Collection<StaffState> staffState;
	/**
	 * @pdRoleInfo migr=no name=StaffState assc=QuitFileMapping
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public Collection<StaffState> staffState1;
	/**
	 * @pdRoleInfo migr=no name=Agreement assc=FileAgreementMapping
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	public Collection<Agreement> agreement;

	public int getFileID() {
		return fileID;
	}

	public void setFileID(int fileID) {
		this.fileID = fileID;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public int getFileUserID() {
		return fileUserID;
	}

	public void setFileUserID(int fileUserID) {
		this.fileUserID = fileUserID;
	}

	public Date getFileOutDate() {
		if(fileOutDate!=null){
			return new java.sql.Date(fileOutDate.getTime());
		}else {
			return fileOutDate;
		}
	}

	public void setFileOutDate(Date fileOutDate) {
		this.fileOutDate = fileOutDate;
	}

	public int getFileManagerID() {
		return fileManagerID;
	}

	public void setFileManagerID(int fileManagerID) {
		this.fileManagerID = fileManagerID;
	}

	public int getFileExamineID() {
		return fileExamineID;
	}

	public void setFileExamineID(int fileExamineID) {
		this.fileExamineID = fileExamineID;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getElectronicFile() {
		return electronicFile;
	}

	public void setElectronicFile(String electronicFile) {
		this.electronicFile = electronicFile;
	}

	public String getScanningElement() {
		return scanningElement;
	}

	public void setScanningElement(String scanningElement) {
		this.scanningElement = scanningElement;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public Collection<StaffState> getStaffState() {
		return staffState;
	}

	public void setStaffState(Collection<StaffState> staffState) {
		this.staffState = staffState;
	}

	public Collection<StaffState> getStaffState1() {
		return staffState1;
	}

	public void setStaffState1(Collection<StaffState> staffState1) {
		this.staffState1 = staffState1;
	}

	public Collection<Agreement> getAgreement() {
		return agreement;
	}

	public void setAgreement(Collection<Agreement> agreement) {
		this.agreement = agreement;
	}

}