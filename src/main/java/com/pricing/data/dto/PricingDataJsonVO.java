package com.pricing.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingDataJsonVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1549808968151256015L;
	private String id;
	private Integer globCustId;
	private String acctNumber;
	private String prdctCd;
	private String prdctDesc;
	private String prdctGrp;
	private String prdctCtgry;
	private String pricingCcy;
	private String pricingType;
	private Double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getGlobCustId() {
		return globCustId;
	}
	public void setGlobCustId(Integer globCustId) {
		this.globCustId = globCustId;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public String getPrdctCd() {
		return prdctCd;
	}
	public void setPrdctCd(String prdctCd) {
		this.prdctCd = prdctCd;
	}
	public String getPrdctDesc() {
		return prdctDesc;
	}
	public void setPrdctDesc(String prdctDesc) {
		this.prdctDesc = prdctDesc;
	}
	public String getPrdctGrp() {
		return prdctGrp;
	}
	public void setPrdctGrp(String prdctGrp) {
		this.prdctGrp = prdctGrp;
	}
	public String getPrdctCtgry() {
		return prdctCtgry;
	}
	public void setPrdctCtgry(String prdctCtgry) {
		this.prdctCtgry = prdctCtgry;
	}
	public String getPricingCcy() {
		return pricingCcy;
	}
	public void setPricingCcy(String pricingCcy) {
		this.pricingCcy = pricingCcy;
	}
	public String getPricingType() {
		return pricingType;
	}
	public void setPricingType(String pricingType) {
		this.pricingType = pricingType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	

}
