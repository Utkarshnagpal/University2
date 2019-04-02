package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.SuggestionBean;
import com.mvc.dao.SuggestionDao;


public class SuggestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SuggestionServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String About= request.getParameter("About");
		String SDescription= request.getParameter("SDescription");
		
		System.out.println(About);
		System.out.println(SDescription);
		
		
		SuggestionBean SuggestionBean = new SuggestionBean();
	
		SuggestionBean.setAbout(About);
		SuggestionBean.setSDescription(SDescription);
		
		
		SuggestionDao SuggestionDao = new SuggestionDao();
		
		String suggest = SuggestionDao.Suggestion(SuggestionBean);
		if(suggest.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/StudentDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", suggest);
			request.getRequestDispatcher("/Register.jsp").include(request, response);
		}
		
	}
		
	}
