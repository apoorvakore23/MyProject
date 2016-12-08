package com.niit.collaborationbackend.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaborationbackend.model.Blog;
@Repository("blogDAO")
public interface BlogDAO {
	
		public void addBlog(Blog b);
		public Blog getBlogByBlogId(int id);
		 public List<Blog> getAllBlogs();
		 public Blog getBlogByBlogname (String Title);
		 public void deleteBlog(Blog blog);
		 public Blog updateBlog(int id , Blog blog);
		 
	}
