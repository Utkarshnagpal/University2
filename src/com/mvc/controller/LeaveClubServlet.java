package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LeaveClubBean;
import com.mvc.dao.LeaveClubDao;




public class LeaveClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LeaveClubServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Clubname= request.getParameter("Clubs");
		
		
		
		LeaveClubBean LeaveClubBean = new LeaveClubBean();
	
		LeaveClubBean.setClubname(Clubname);

		
		LeaveClubDao LeaveClubDao = new LeaveClubDao();
		
		  HttpSession session=request.getSession();
		  String uid=(String)session.getAttribute("uname");
		  System.out.println("userid "+uid);
		
		String leaveClubs= LeaveClubDao.leaveClub(LeaveClubBean,uid);
		if(leaveClubs.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/StudentDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", leaveClubs);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
		
	}

}
