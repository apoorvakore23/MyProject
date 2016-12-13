package com.niit.collaborationbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="col_friend")
public class Friend {
	
	//@GeneratedValue(strategy = GenerationType.AUTO)	
	//private int f_id;
	@Id
	private int friendID;
	
	private int userID;
	private String status;
	
	
	/*public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}*/
	public int getFriendID() {
		return friendID;
	}
	public void setFriendID(int friendID) {
		this.friendID = friendID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString() {
		return String.format("{friendID:%s,status:%s,userID:%s}",friendID,status,userID);	
	}
	
	
}
