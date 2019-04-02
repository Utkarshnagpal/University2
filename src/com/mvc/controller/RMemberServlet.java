package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mvc.bean.RMemberBean;
import com.mvc.dao.RMemberDao;



public class RMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RMemberServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String Userid= request.getParameter("Userid");
String Clubname= request.getParameter("Clubname");
		
		RMemberBean RMemberBean = new RMemberBean();
		
		RMemberBean.setUserid(Userid);
		RMemberBean.setClubname(Clubname);
		
		RMemberDao RMemberDao = new RMemberDao();
		
		String removeMember= RMemberDao.removeMembers(RMemberBean);
		if(removeMember.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Club.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", removeMember);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
		
	}

}
