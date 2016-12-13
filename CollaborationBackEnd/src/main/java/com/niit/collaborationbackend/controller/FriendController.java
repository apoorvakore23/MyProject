package com.niit.collaborationbackend.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaborationbackend.dao.FriendDAO;
import com.niit.collaborationbackend.model.Friend;
import com.niit.collaborationbackend.model.User;
@RestController
public class FriendController {

	private static final Logger logger = LoggerFactory.getLogger(FriendController.class);

	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	Friend friend;
	
	@RequestMapping(value = "/myFriends", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriends(HttpSession session) {
		logger.debug("->->->->calling method getMyFriends");
		int loggedInUserID= (int) session.getAttribute("loggedInUserID");

		logger.debug("getting friends of : " +loggedInUserID);
		List<Friend> myFriends = friendDAO.getMyFriends(loggedInUserID);
		
		/*if(myFriends.isEmpty())
		{
			logger.debug("Friends does not exsit for the user : " +loggedInUserID);
			//friend.setErrorCode("404");
			//friend.setErrorMessage("You does not have any friends");
			//myFriends.add(friend);
		}
		logger.debug("Send the friend list ");*/
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}

	@RequestMapping(value = "/addFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") int friendID,HttpSession session) {
		logger.debug("->->->->calling method sendFriendRequest");
		System.out.println("sendfriendrequest");
		int loggedInUserID= (int) session.getAttribute("loggedInUserID");
		friend.setUserID(loggedInUserID);
		friend.setFriendID(friendID);
		friend.setStatus("N"); //N - New, R->Rejected, A->Accepted
		friendDAO.save(friend);
		System.out.println("sendfriendrequest"+friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/unFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> unFriend(@PathVariable("friendID") int friendID,HttpSession session) {
		logger.debug("->->->->calling method unFriend");
		updateRequest(friendID, "U", session);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	

	@RequestMapping(value = "/rejectFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriendFriendRequest(@PathVariable("friendID") int friendID,HttpSession session) {
		logger.debug("->->->->calling method rejectFriendFriendRequest");
		
		updateRequest(friendID, "R", session);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	private void updateRequest(int friendID, String status,HttpSession session)
	{
		int loggedInUserID= (int) session.getAttribute("loggedInUserID");
		friend.setFriendID(loggedInUserID);
		friend.setUserID(friendID);
		friend.setStatus(status); //N - New, R->Rejected, A->Accepted
		friendDAO.update(friend);
		
	}
	
	
	@RequestMapping(value = "/getMyFriendRequests", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests(HttpSession session) {
		logger.debug("->->->->calling method getMyFriendRequests");
		int loggedInUserID= (int) session.getAttribute("loggedInUserID");
		List<Friend>  myFriendRequests =   friendDAO.getNewFriendRequests(loggedInUserID);
		System.out.println(myFriendRequests);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);
		
	}
	
	/*@RequestMapping(value="/accepttFriend" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<?> update(@RequestBody Friend friend,HttpSession session)
	{
		int loggedInUserID= (int) session.getAttribute("loggedInUserID");
		System.out.println("in user edit rest controller with user object :" + friend);
		if ( friend == null)
		{
			return new ResponseEntity("No user found for this id :" + loggedInUserID,HttpStatus.NOT_FOUND);
		}
		friend.setStatus("A");
		
		friend = friendDAO.update(loggedInUserID, friend);
	return new ResponseEntity(friend , HttpStatus.OK);	
	}*/

	
	@RequestMapping(value = "/accepttFriend/{friendID}", method = RequestMethod.PUT)
	public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("friendID") int friendID,HttpSession session) {
		logger.debug("->->->->calling method acceptFriendFriendRequest");
		System.out.println("calling method acceptFriendFriendRequest");
		updateRequest(friendID, "A", session);
		System.out.println("friend"+friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
		

}
