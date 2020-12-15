package com.pricing.data.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "element")
@XmlAccessorType(XmlAccessType.NONE)
public class PricingDataXMLVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private String id;

	@XmlElement
	private String custId;

	@XmlElement
	private String acctNumber;
	@XmlElement
	private Boolean isActive;
	@XmlElement
	private String pricing;

	@XmlElement
	private String company;

	@XmlElement
	private String about;

	public PricingDataXMLVO(String id, String custId, String acctNumber, Boolean isActive, String pricing,
			String company, String about) {
		super();
		this.id = id;
		this.custId = custId;
		this.acctNumber = acctNumber;
		this.isActive = isActive;
		this.pricing = pricing;
		this.company = company;
		this.about = about;
	}

	public PricingDataXMLVO() {

	}

	@Override
	public String toString() {
		return "pricingDataXMLVO [id=" + id + ", custId=" + custId + ", acctNumber=" + acctNumber + ", isActive="
				+ isActive + ", pricing=" + pricing + ", company=" + company + ", about=" + about + "]";
	}

}