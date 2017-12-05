package com.niit.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.config.Dbconfig;
import com.niit.dao.BlogDAO;
import com.niit.model.Blog;

@ComponentScan("com.niit.rest")
public class BlogTest 
{
	 @Autowired
	 private static BlogDAO blogDAO;
	
	 	@SuppressWarnings("resource")
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.register(Dbconfig.class);
			context.scan("com.niit.rest.*");
			context.refresh();
			
			blogDAO=(BlogDAO)context.getBean("blogDAO");
		}
	 	
	 	@Ignore
	 	@Test
	 	public void addBlogTest()
	 	{
			Blog blog=new Blog();
			//blog.setBlogId(1001);
			blog.setBlogName("GeekforGeeks");
			blog.setBlogContent("Java advance concepts");
			blog.setUsername("sony");
			blog.setStatus("A");
			blog.setLikes(6);
			blog.setCreateDate(new java.util.Date());
			
			assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
	 	}
	 	
	 	@Ignore
	 	@Test
	 	public void getBlogTest()
	 	{
	 		Blog blog=(Blog)blogDAO.getBlog(1);
			System.out.println("BlogName:" + blog.getBlogName());
			System.out.println("BlogContent:" +blog.getBlogContent());
			assertNotNull("blog not found", blog);
	 	}
	 	
	 	@Ignore
	 	@Test
	 	public void updateTest()
	 	{
	 			Blog blog=(Blog)blogDAO.getBlog(1);
	 			blog.setBlogName("Advanced java");
	 			blog.setBlogContent("OOPS concepts");
	 			assertTrue("Problem in updating Blog",blogDAO.updateBlog(blog));
	 	}
	 	
	 	@Ignore
	 	@Test
		public void deleteBlogTest()
	 	{
			Blog blog=(Blog)blogDAO.getBlog(1);
			assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
		}
	 	
	 	@Ignore
	 	@Test
		public void approveBlogTest()
	 	{
			Blog blog=(Blog)blogDAO.getBlog(2);
			assertTrue("Problem in approving",blogDAO.approveBlog(blog));
		}
	 	
	 	//@Ignore
	 	@Test
		public void getAllBlogsTest()
	 	{
			List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
			assertNotNull("Blog list not found ",blogList.get(0));
			for(Blog blog:blogList)
			{
				System.out.println("BlogID:"+blog.getBlogId() + "BlogName:"+blog.getBlogName());
			}
		}
	 	
}