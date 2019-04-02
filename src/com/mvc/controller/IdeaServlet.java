package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.IdeaBean;
import com.mvc.dao.IdeaDao;




public class IdeaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IdeaServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Topic= request.getParameter("Topic");
		String IdeaDescription= request.getParameter("IdeaDescription");
		
		System.out.println(Topic);
		System.out.println(IdeaDescription);
		
		
		IdeaBean IdeaBean = new IdeaBean();
	
		IdeaBean.setTopic(Topic);
		IdeaBean.setIdeaDescription(IdeaDescription);
		
		
		IdeaDao IdeaDao = new IdeaDao();
		
		String idea = IdeaDao.Idea(IdeaBean);
		if(idea.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.getRequestDispatcher("/StudentDashBoard.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", idea);
			request.getRequestDispatcher("/Register.jsp").include(request, response);
		}
		
	}

}
