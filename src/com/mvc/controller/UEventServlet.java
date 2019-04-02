package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UEventBean;
import com.mvc.dao.UEventDao;

public class UEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UEventServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String EId= request.getParameter("EId");
		String EDatestr= request.getParameter("EDate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		java.util.Date d=null;
		
		java.sql.Date EDate=null;
		
		try 
		{
			d=sdf.parse(EDatestr);			 
			System.out.println("sdf= "+d);
			
			EDate=new Date(d.getYear(), d.getMonth(), d.getDate());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		UEventBean UEventBean = new UEventBean();
	
		
		UEventBean.setEId(EId);
		UEventBean.setEDate(EDate);
		
		UEventDao UEventDao = new UEventDao();
		
		String updateEvents= UEventDao.updateEvent(UEventBean);
		if(updateEvents.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", updateEvents);
			request.getRequestDispatcher("/AdminProfile.jsp").include(request, response);
		}
		
	}

}
