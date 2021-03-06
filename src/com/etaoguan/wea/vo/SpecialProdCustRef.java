package com.etaoguan.wea.vo;

/**
 * @author cunli
 * 特供产品表
 */
public class SpecialProdCustRef extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String custNum;
	private String prodNum;
	private String ownerNum;
	private String prodName;

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public String getProdNum() {
		return prodNum;
	}

	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}

	public String getOwnerNum() {
		return ownerNum;
	}

	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
}
