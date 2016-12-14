package com.niit.collaborationbackend.model;



import java.util.Date;

public class OutputMessage extends Message {

	private Date time;
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username;
	
	public OutputMessage(Message original,Date time)//,String username)
	{
		super(original.getId(),original.getMessage());
		this.time=time;
		//this.username=username;
	}
}
