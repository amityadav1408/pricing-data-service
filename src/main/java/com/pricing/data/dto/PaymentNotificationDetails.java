package com.pricing.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentNotificationDetails implements Serializable {
	
	private static final long serialVersionUID = -1549808968151256017L;
	private String srcSysId;
	private String custRelId;
	private String subscriptionId;
	private String eventCat;
	private String eventId;
	private String event;
	
	public String getSrcSysId() {
		return srcSysId;
	}
	public void setSrcSysId(String srcSysId) {
		this.srcSysId = srcSysId;
	}
	public String getCustRelId() {
		return custRelId;
	}
	public void setCustRelId(String custRelId) {
		this.custRelId = custRelId;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getEventCat() {
		return eventCat;
	}
	public void setEventCat(String eventCat) {
		this.eventCat = eventCat;
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	

}
