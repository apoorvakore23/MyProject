package com.niit.collaborationbackend.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Friend;



@Repository(value="friendDAO")
public interface FriendDAO {

	void save(Friend friend);
	
	void update(Friend friend);
	
	void delete(Friend friend);
	
	Friend get(int user_id, int friend_id);
	
	List<Friend> listFriend(int user_id);
	 List<Friend> listFriendreq(int user_id);
	
	//List<Friend> getFriendRequest(int user_id);
}
