package com.niit.collaborationbackend.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Friend;



@Repository(value="friendDAO")
public interface FriendDAO {

	
	boolean save(Friend friend);
	boolean update(Friend friend);
	void delete(int userID, int friendID);
	List<Friend> getMyFriends(int userID) ;
	List<Friend> getNewFriendRequests(int userID);
	//Friend update(int id , Friend friend);
	Friend get(int userID, int friendID);
	void setOnline(int userID);
	void setOffLine(int userID);
	
	
}
