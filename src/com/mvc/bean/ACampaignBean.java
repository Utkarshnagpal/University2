package com.mvc.bean;

import java.util.Date;

public class ACampaignBean {
	
	private String CName;
	private Date CSDate;
	private Date CEDate;
	private String CContactPerson;
	private String EventName;
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public Date getCSDate() {
		return CSDate;
	}
	public void setCSDate(Date cSDate) {
		CSDate = cSDate;
	}
	public Date getCEDate() {
		return CEDate;
	}
	public void setCEDate(Date cEDate) {
		CEDate = cEDate;
	}
	public String getCContactPerson() {
		return CContactPerson;
	}
	public void setCContactPerson(String cContactPerson) {
		CContactPerson = cContactPerson;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	

}
