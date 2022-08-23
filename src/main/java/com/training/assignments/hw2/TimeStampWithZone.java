package com.training.assignments.hw2;

public class TimeStampWithZone {
	public String timeStamp = "";
	public String timeZone = "";
	public Integer idNumber;
	
	public TimeStampWithZone(String timeStamp, String timeZone, Integer idNumber) {
		this.timeStamp = timeStamp;
		this.timeZone = timeZone;
		this.idNumber = idNumber;
	};
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public String getTimeZone() {
		return timeZone;
	}
	
	public Integer getIdNumber() {
		return idNumber;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}
	
	public String toString() {
		StringBuilder toStringValue = new StringBuilder().append(timeStamp).append(" ").append(timeZone).append(" ").append(idNumber);
		
		return toStringValue.toString();
	}
	

}
