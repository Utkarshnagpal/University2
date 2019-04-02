package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.DClubBean;
import com.mvc.dao.DClubDao;




public class DClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DClubServlet() {
        super();
        
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String ClubName= request.getParameter("ClubName");
			
			DClubBean DClubBean = new DClubBean();
			
			DClubBean.setClubName(ClubName);
			
			
			DClubDao DClubDao = new DClubDao();
			
			String deleteClubs= DClubDao.deleteClub(DClubBean);
			if(deleteClubs.equals("SUCCESS"))   //On success, you can display a message to user on Home page
			{
				request.getRequestDispatcher("/Club.jsp").forward(request, response);
			}
			else   
			{
				request.setAttribute("errMessage", deleteClubs);
				request.getRequestDispatcher("/Home.jsp").include(request, response);
			}
		
	}

}
