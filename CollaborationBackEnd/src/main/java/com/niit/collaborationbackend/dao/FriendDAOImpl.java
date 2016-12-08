package com.niit.collaborationbackend.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaborationbackend.model.Friend;



@Repository
public class FriendDAOImpl implements FriendDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void save(Friend friend) {
		sessionFactory.getCurrentSession().save(friend);
	}

	@Transactional
	public void update(Friend friend) {
		sessionFactory.getCurrentSession().update(friend);
	}
	
	@Transactional
	public void delete(Friend friend) {
		sessionFactory.getCurrentSession().delete(friend);
		
	}
	@Transactional
	public Friend get(int user_id, int friend_id) {
		String hql = "from Friend where user_id=" + "'" + user_id + "'and "+" friend_id ='" + friend_id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list = query.list();
		if (list == null) {
			return null;
		} else {
			return list.get(0);
		}
	}
	@Transactional
	public List<Friend> listFriend(int user_id) {
		String hql = "from Friend where user_id = " + "'" + user_id + "'and status = '" +" A'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Friend> listFriendreq(int user_id) {
		// TODO Auto-generated method stub
		String hql="from Friend whrere user_id=" + "'" +user_id +"'and status='"+"N'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	

	
}
