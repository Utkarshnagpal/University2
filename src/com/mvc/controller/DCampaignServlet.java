package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.DCampaignBean;
import com.mvc.bean.DEventBean;
import com.mvc.dao.DCampaignDao;
import com.mvc.dao.DEventDao;

public class DCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DCampaignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String CName= request.getParameter("CName");
		
		DCampaignBean DCampaignBean = new DCampaignBean();
		
		DCampaignBean.setCName(CName);
		
		
		DCampaignDao DCampaignDao = new DCampaignDao();
		
		String deleteCampaigns= DCampaignDao.deleteCampaign(DCampaignBean);
		if(deleteCampaigns.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", deleteCampaigns);
			request.getRequestDispatcher("/Home.jsp").include(request, response);
		}
		
	}
	
	}


