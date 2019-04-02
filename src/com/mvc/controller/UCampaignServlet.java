package com.mvc.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.UCampaignBean;
import com.mvc.dao.UCampaignDao;

public class UCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UCampaignServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String CName= request.getParameter("CName");
		String CSDatestr= request.getParameter("CSDate");
		String CEDatestr= request.getParameter("CEDate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-dd-MM");
		java.util.Date d=null;
		
		java.sql.Date CSDate=null;
		
		try 
		{
			d=sdf.parse(CSDatestr);			 
			System.out.println("sdf= "+d);
			
			CSDate=new Date(d.getYear(), d.getMonth(), d.getDate());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
java.util.Date d2=null;
		
		java.sql.Date CEDate=null;
		
		try 
		{
			d2=sdf2.parse(CEDatestr);			 
			System.out.println("sdf= "+d2);
			
			CEDate=new Date(d2.getYear(), d2.getMonth(), d2.getDate());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		UCampaignBean UCampaignBean = new UCampaignBean();
	
		
		UCampaignBean.setCName(CName);
		UCampaignBean.setCSDate(CSDate);
		UCampaignBean.setCEDate(CEDate);
		
		UCampaignDao UCampaignDao = new UCampaignDao();
		
		String updateCampaigns= UCampaignDao.updateCampaign(UCampaignBean);
		if(updateCampaigns.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/Campaign.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", updateCampaigns);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
	}
	}

