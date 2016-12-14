package com.niit.collaborationbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;
import com.niit.collaborationbackend.util.FileUtil;

@RestController
public class UsersController {
@Autowired
private UserDAO userDAO;
private String path="E:\\reference code\\CollaborationBackEnd\\src\\main\\webapp\\resources\\ProfileImages";

@GetMapping("users")
public ResponseEntity<List<User>> getUsers()
{
	System.out.println(userDAO.getAllUsers());
return new ResponseEntity(userDAO.getAllUsers(),HttpStatus.OK);	
}


@GetMapping("user/{id}")
public ResponseEntity<?> getUser(@PathVariable("id") int id)
{	
User user = userDAO.getUserByUserId(id);


if (user == null)
{
	return new ResponseEntity("No user found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(user);
return new ResponseEntity(user.toString(), HttpStatus.OK);
}



@RequestMapping(value="user/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createUser(@RequestBody  User user)
{
	System.out.println("user"+user);
	FileUtil.upload(path, user.getImage(), user.getUserId()+".jpg");
	user.setFile(user.getUserId()+".jpg");
	System.out.println(user.getImage());
	
userDAO.addUser(user);
System.out.println("user added : " + user);
return new ResponseEntity(userDAO.getAllUsers(), HttpStatus.OK);
}




@RequestMapping(value="user/delete/{userId}",method=RequestMethod.DELETE)
public ResponseEntity<?> deleteUser(@PathVariable int userId)
{
	User user = userDAO.getUserByUserId(userId);
	System.out.println("delete mapping with id :" + userId);
	userDAO.deleteUser(user);
	System.out.println("user deleted : " + user );
	return new ResponseEntity("DELETED", HttpStatus.OK);
}


@RequestMapping(value="user/edit" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> updateUser(@RequestBody User user)
{
	System.out.println("in user edit rest controller with user object :" + user);
	if ( user == null)
	{
		return new ResponseEntity("No user found for this id :" + user.getUserId(),HttpStatus.NOT_FOUND);
	}
	user = userDAO.updateUser(user.getUserId(), user);
return new ResponseEntity(user , HttpStatus.OK);	
}

@RequestMapping(value="user/login", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> login(@RequestBody  User user,HttpSession session)
{
	System.out.println(user);
user=userDAO.Login(user.getU_username(), user.getU_password());
if(user==null)
	user=new User();
else
{ 
	user.setIsOnline("Y");
	// userDAO.updateUser(user.getUserId(), user);
	session.setAttribute("loggedInUser", user);
	session.setAttribute("loggedInUserName", user.getU_username());
	session.setAttribute("loggedInUserID", user.getUserId());
	
}
System.out.println("user added : " + user);
return new ResponseEntity(user, HttpStatus.OK);

}

@RequestMapping(value="user/getuserById", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<User> getuserById(@RequestBody  User user,HttpSession session)
{
	user=userDAO.getUserByUserId(user.getUserId());
	return new ResponseEntity(user, HttpStatus.OK);
	
}

@RequestMapping(value = "/logout", method = RequestMethod.GET)
public ResponseEntity<User> logout(HttpSession session) {
	System.out.println("Starting of the method logout" );
	
	int loggedInUserID= (int) session.getAttribute("loggedInUserID");
	
System.out.println("loggedInUserID : " + loggedInUserID);
	
	User user =userDAO.getUserByUserId(loggedInUserID);
	
	System.out.println("user:"+ user);
	user.setIsOnline("N");

	session.invalidate();
	user=userDAO.updateUser(user.getUserId(), user);
System.out.println("You have logged out sYuccessfully"+user);
	
	return new ResponseEntity<User>(user, HttpStatus.OK);

}



}