package com.mvc.bean;

import java.util.Date;

public class AEventBean {
	
	private String EName;
	private String EId;
	private Date EDate;
	private String EDescription;
	
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getEId() {
		return EId;
	}
	public void setEId(String eId) {
		EId = eId;
	}
	

	public Date getEDate() {
		return EDate;
	}
	public void setEDate(Date eDate) {
		EDate = eDate;
	}
	public String getEDescription() {
		return EDescription;
	}
	public void setEDescription(String eDescription) {
		EDescription = eDescription;
	}

}
