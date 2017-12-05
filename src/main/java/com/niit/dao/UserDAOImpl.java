package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetails;
import com.niit.model.Forum;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


		
	@Transactional
	public boolean updateOnlineStatus(String status, UserDetails user) 
	{
		try
		{
			user.setIsOnine(status);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:" +e);
			return false;
		}	
	}



	@Override
	@Transactional
	public boolean addUserDetails(UserDetails user) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception occured:" +e);
			return false;
		}
	}



	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public UserDetails getUserDetails(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
