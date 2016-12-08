package com.niit.collaborationbackend.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.FriendDAO;
import com.niit.collaborationbackend.model.Friend;





@RestController
public class FriendController {
	
	@Autowired
	Friend friend;
	FriendDAO friendDAO;	
	
	@RequestMapping(value = "/friend/addFriend", method = RequestMethod.POST)
	public ResponseEntity<?> sendfriendreq (@PathVariable("friend_id") int friend_id ,HttpSession session) {
		System.out.println("friend request sending...");
		int loggedInUserId = (int) session.getAttribute("loggedInUserId");
		friend.setUser_id(loggedInUserId);
		friend.setStatus("N");
		friend.setFriend_id(friend_id);
		friendDAO.save(friend);
		return new ResponseEntity<Friend>(friend , HttpStatus.OK);	
	}
	
	
	
}
