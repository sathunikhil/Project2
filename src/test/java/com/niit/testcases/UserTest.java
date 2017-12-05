package com.niit.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.dao.UserDAO;
import com.niit.config.Dbconfig;
import com.niit.model.Forum;
//import com.niit.model.Job;
import com.niit.model.UserDetails;


@ComponentScan("com.niit")
public class UserTest 
{
	@Autowired
	private static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(Dbconfig.class);
		context.scan("com.niit.rest.*");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	/*

*
*/
	@Test
	public void addUserTest()
	{
		UserDetails user=new UserDetails();
		user.setUserdId(14);
		user.setFirstName("nikhil");
		user.setLastName("sathu");
		user.setEmailId("nikhil@gmail.com");
		user.setPassword("12345");
		user.setRole("User");
		user.setStatus("P");
		user.setIsOnine("O");
		assertTrue("Problem in Inserting user", userDAO.addUserDetails(user));

	}

	@Ignore
	@Test
	public void getAllUserTest()
	{
		List<UserDetails> userList=(List<UserDetails>)userDAO.getAllUserDetails();
		assertNotNull("Job list not found ",userList.get(0));
		for(UserDetails user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
	}
	
}