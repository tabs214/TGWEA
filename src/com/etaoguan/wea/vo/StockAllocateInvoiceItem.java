package com.etaoguan.wea.vo;

public class StockAllocateInvoiceItem {
	private String stkAllocNum;
	private String prodNum;
	private String prodName;
	private String differName;
	private String unit;
	private int cases;
	private int availCases;
	private int pieces;

	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public int getCases() {
		return cases;
	}
	public void setCases(int cases) {
		this.cases = cases;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStkAllocNum() {
		return stkAllocNum;
	}
	public void setStkAllocNum(String stkAllocNum) {
		this.stkAllocNum = stkAllocNum;
	}
	public int getAvailCases() {
		return availCases;
	}
	public void setAvailCases(int availCases) {
		this.availCases = availCases;
	}
	public String getDifferName() {
		return differName;
	}
	public void setDifferName(String differName) {
		this.differName = differName;
	}
	

}
