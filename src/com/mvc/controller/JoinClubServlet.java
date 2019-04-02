package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.JoinClubBean;
import com.mvc.dao.JoinClubDao;




public class JoinClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JoinClubServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Clubname= request.getParameter("Clubs");
		 
		
		
		
		JoinClubBean JoinClubBean = new JoinClubBean();
	
		JoinClubBean.setClubname(Clubname);
		

		
		JoinClubDao JoinClubDao = new JoinClubDao();
		
		  HttpSession session=request.getSession();
          String uid=(String)session.getAttribute("uname");
          System.out.println("userid "+uid);
		
		String joinClubs= JoinClubDao.joinClub(JoinClubBean,uid);
		if(joinClubs.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/StudentDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", joinClubs);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
	}

}
