package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.ACampaignBean;
import com.mvc.dao.ACampaignDao;

public class ACampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ACampaignServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String CName= request.getParameter("CName");
		String CSDatestr= request.getParameter("CSDate");
		String CEDatestr= request.getParameter("CEDate");
		String CContactPerson= request.getParameter("CContactPerson");
		String EventName= request.getParameter("EventName");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-dd-MM");
		java.util.Date d=null;
		java.util.Date d2=null;
		
		java.sql.Date CSDate=null;
		java.sql.Date CEDate=null;
		
		try 
		{
			d=sdf.parse(CSDatestr);			 
			System.out.println("sdf= "+d);
			
			CSDate=new Date(d.getYear(), d.getMonth(), d.getDate());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			d2=sdf.parse(CEDatestr);			 
			System.out.println("sdf= "+d);
			
			CEDate=new Date(d.getYear(), d.getMonth(), d.getDate());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		
		ACampaignBean ACampaignBean = new ACampaignBean();
	
		ACampaignBean.setCName(CName);
		ACampaignBean.setCSDate(CSDate);
		ACampaignBean.setCEDate(CEDate);
		ACampaignBean.setCContactPerson(CContactPerson);
		ACampaignBean.setEventName(EventName);
		
		ACampaignDao ACampaignDao = new ACampaignDao();
		
		String addCampaigns= ACampaignDao.addCampaign(ACampaignBean);
		if(addCampaigns.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", addCampaigns);
			request.getRequestDispatcher("/AddEvent.jsp").include(request, response);
		}
	}

}
