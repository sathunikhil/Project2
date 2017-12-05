package com.niit.dao;

import java.util.List;

import com.niit.model.Forum;
import com.niit.model.UserDetails;

public interface UserDAO 
{
	public boolean addUserDetails(UserDetails user);
	public boolean updateOnlineStatus(String status, UserDetails user);
/*	public UserDetail getUserDetail(String username);*/
	public List<UserDetails> getAllUserDetails();
	public UserDetails getUserDetails(String username);
}