package com.niit.collaborationbackend.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.ForumDAO;
import com.niit.collaborationbackend.model.Forum;

@RestController
public class ForumController {
@Autowired
private ForumDAO forumDAO;


@GetMapping("forums")
public ResponseEntity<List<Forum>> getForums()
{
	System.out.println(forumDAO.getAllForums());
return new ResponseEntity(forumDAO.getAllForums(),HttpStatus.OK);	
}


@GetMapping("forum/{f_id}")
public ResponseEntity<?> getForum(@PathVariable("f_id") int id)
{	
Forum forum = forumDAO.getForumByForumId(id);


if (forum == null)
{
	return new ResponseEntity("No forum found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(forum);
return new ResponseEntity(forum.toString(), HttpStatus.OK);
}



@RequestMapping(value="forum/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createForum(@RequestBody  Forum forum)
{
forumDAO.addForum(forum);
System.out.println("forum added : " + forum);
return new ResponseEntity("hi", HttpStatus.OK);
}




@RequestMapping(value="forum/delete/{f_id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deleteForum(@PathVariable int f_id)
{
	Forum forum = forumDAO.getForumByForumId(f_id);
	System.out.println("delete mapping with id :" + f_id);
	forumDAO.deleteForum(forum);
	System.out.println("forum deleted : " + forum );
	return new ResponseEntity("DELETED", HttpStatus.OK);
}


@RequestMapping(value="forum/edit" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> updateForum(@RequestBody Forum forum)
{
	System.out.println("in forum edit rest controller with forum object :" + forum);
	if ( forum == null)
	{
		return new ResponseEntity("No forum found for this id :" + forum.getF_id(),HttpStatus.NOT_FOUND);
	}
	forum = forumDAO.updateForum(forum.getF_id(), forum);
return new ResponseEntity(forum , HttpStatus.OK);	
}
}