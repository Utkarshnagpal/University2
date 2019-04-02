package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.DEventBean;
import com.mvc.bean.UEventBean;
import com.mvc.dao.DEventDao;


public class DEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DEventServlet() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EId= request.getParameter("EId");
		
		DEventBean DEventBean = new DEventBean();
		
		DEventBean.setEId(EId);
		
		
		DEventDao DEventDao = new DEventDao();
		
		String deleteEvents= DEventDao.deleteEvent(DEventBean);
		if(deleteEvents.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Campaign.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", deleteEvents);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
	}

}
