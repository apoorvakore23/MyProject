package com.niit.collaborationbackend.dao;
import java.util.List;

import com.niit.collaborationbackend.model.Forum;
public interface ForumDAO {
	
		public void addForum(Forum f);
		public Forum getForumByForumId(int id);
		 public List<Forum> getAllForums();
		 public Forum getForumByForumname (String name);
		 public Forum updateForum(int id , Forum forum);
		 public void deleteForum(Forum forum);
	}
