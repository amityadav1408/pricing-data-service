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
	private String custId;
	private String acctNumber;
	private Boolean isActive;
	private String pricing;
	private String company;
	private String about;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "PricingDataJsonVO [id=" + id + ", custId=" + custId + ", acctNumber=" + acctNumber + ", isActive="
				+ isActive + ", pricing=" + pricing + ", company=" + company + ", about=" + about + "]";
	}

}
