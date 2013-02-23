package com.hros.bas.domain;

public class DictInfo {
	private int dictID=0;
	
	private int fDictID=0;
	
	private String dictCode="";
	
	private String dictName="";
	
	private int seq=0;
	
	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	public int getDictID() {
		return dictID;
	}

	public void setDictID(int dictID) {
		this.dictID = dictID;
	}

	public int getFDictID() {
		return fDictID;
	}

	public void setFDictID(int fDictID) {
		this.fDictID = fDictID;
	}
}
