package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UClubBean;
import com.mvc.dao.UClubDao;




public class UClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UClubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String ClubName= request.getParameter("ClubName");
		String ClubDescription= request.getParameter("ClubDescription");
		
		UClubBean UClubBean = new UClubBean();
	
		
		UClubBean.setClubName(ClubName);
		UClubBean.setClubDescription(ClubDescription);
		
		UClubDao UClubDao = new UClubDao();
		
		String updateClubs= UClubDao.updateClub(UClubBean);
		if(updateClubs.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", updateClubs);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}

}
}
