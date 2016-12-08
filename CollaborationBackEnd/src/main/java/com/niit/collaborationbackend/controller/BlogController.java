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
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.model.Blog;

@RestController
public class BlogController {
@Autowired
private BlogDAO blogDAO;


@GetMapping("/blogs")
public ResponseEntity<List<Blog>> getBlogs()
{
	System.out.println(blogDAO.getAllBlogs());
return new ResponseEntity(blogDAO.getAllBlogs(),HttpStatus.OK);	
}


@GetMapping("blog/{b_id}")
public ResponseEntity<?> getBlog(@PathVariable("b_id") int id)
{	
Blog blog = blogDAO.getBlogByBlogId(id);


if (blog == null)
{
	return new ResponseEntity("No blog found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(blog);
return new ResponseEntity(blog.toString(), HttpStatus.OK);
}



@RequestMapping(value="blog/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createBlog(@RequestBody  Blog blog,HttpSession session)
{
	System.out.println(session.getAttribute("loggedInUserId"));
	System.out.println("blog added : " + blog);
blogDAO.addBlog(blog);

return new ResponseEntity("hi", HttpStatus.OK);
}




@RequestMapping(value="blog/delete/{blogId}",method=RequestMethod.DELETE)
public ResponseEntity<?> deleteBlog(@PathVariable int blogId)
{
	Blog blog = blogDAO.getBlogByBlogId(blogId);
	System.out.println("delete mapping with id :" + blogId);
	blogDAO.deleteBlog(blog);
	System.out.println("blog deleted : " + blog );
	return new ResponseEntity("DELETED", HttpStatus.OK);
}


@RequestMapping(value="blog/edit" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> updateBlog(@RequestBody Blog blog)
{
	System.out.println("in blog edit rest controller with blog object :" + blog);
	if ( blog == null)
	{
		return new ResponseEntity("No blog found for this id :" + blog.getBlog_id(),HttpStatus.NOT_FOUND);
	}
	blog = blogDAO.updateBlog(blog.getBlog_id(), blog);
return new ResponseEntity(blog , HttpStatus.OK);	
}
}