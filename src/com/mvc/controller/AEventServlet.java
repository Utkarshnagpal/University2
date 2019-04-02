package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.AEventBean;
import com.mvc.dao.AEventDao;


public class AEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AEventServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EName= request.getParameter("EName");
		String EId= request.getParameter("EId");
		String EDatestr= request.getParameter("EDate");
		String EDescription= request.getParameter("EDescription");
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
		
		System.out.println(EName);
		System.out.println(EId);
		System.out.println(EDate);
		System.out.println(EDescription);
		
		AEventBean AEventBean = new AEventBean();
	
		AEventBean.setEName(EName);
		AEventBean.setEId(EId);
		AEventBean.setEDate(EDate);
		AEventBean.setEDescription(EDescription);
		
		AEventDao AEventDao = new AEventDao();
		
		String addEvents= AEventDao.addEvent(AEventBean);
		if(addEvents.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", addEvents);
			request.getRequestDispatcher("/AddEvent.jsp").include(request, response);
		}
		
	}

}
