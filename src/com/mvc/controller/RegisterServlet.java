package com.mvc.controller;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;
public class RegisterServlet extends HttpServlet 
{
	public RegisterServlet() 
	{
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String firstName= request.getParameter("fname");
		String lastName= request.getParameter("lname");
		String MobileNum= request.getParameter("mnumber");
		String email= request.getParameter("email");
		String userid= request.getParameter("uid");
		String password= request.getParameter("pass");
		String age= request.getParameter("age");
		String club= request.getParameter("club");
		String gender=request.getParameter("gender");
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(MobileNum);
		System.out.println(email);
		System.out.println(userid);
		System.out.println(password);
		System.out.println(age);
		System.out.println(club);
		System.out.println(gender);
		
		
		RegisterBean registerBean = new RegisterBean();
	
		registerBean.setFirstName(firstName);
		registerBean.setLastName(lastName);
		registerBean.setMobileNum(MobileNum);
		registerBean.setEmail(email);
		registerBean.setUserid(userid);
		registerBean.setPassword(password);
		registerBean.setAge(age);
		registerBean.setClub(club);
		registerBean.setGender(gender);
		
		
		RegisterDao registerDao = new RegisterDao();
		
		String userRegistered = registerDao.registerUser(registerBean);
		if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/StudentLogin.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").include(request, response);
		}
	}
}