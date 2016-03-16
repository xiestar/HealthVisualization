package model;

public class Resident {
	
	//对应于居民健康表中字段RestNo
	private String resNo;
	//'年龄' from tb_residents
	private int resAge;
	//'性别' from tb_residents
	private String resSex;
	//'行政区域' from tb_residents
	private String district;
	//'是否患病' from tb_residents
	private int isHypertension;
	private int isHyperglycemia;
	private int isHyperlipidemia;
	private int isObesity;
	
	
	public int getIshypertension() {
		return isHypertension;
	}
	public void setIshypertension(int ishypertension) {
		this.isHypertension = ishypertension;
	}
	public int getIshyperglycemia() {
		return isHyperglycemia;
	}
	public void setIshyperglycemia(int ishyperglycemia) {
		this.isHyperglycemia = ishyperglycemia;
	}
	public int getIshyperlipidemia() {
		return isHyperlipidemia;
	}
	public void setIshyperlipidemia(int ishyperlipidemia) {
		this.isHyperlipidemia = ishyperlipidemia;
	}
	public int getIsobesity() {
		return isObesity;
	}
	public void setIsobesity(int isobesity) {
		this.isObesity = isobesity;
	}
	
	
	public String getResNo() {
		return resNo;
	}
	public void setResNo(String resNo) {
		this.resNo = resNo;
	}
	public int getResAge() {
		return resAge;
	}
	public void setResAge(int resAge) {
		this.resAge = resAge;
	}
	public String getResSex() {
		return resSex;
	}
	public void setResSex(String resSex) {
		this.resSex = resSex;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
