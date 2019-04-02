package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.LoginBean;
import com.mvc.dao.LoginDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username= request.getParameter("userid");
		String Password= request.getParameter("pwd");
		
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setUsername(Username);
		loginBean.setPassword(Password);
		
		
          LoginDao loginDao = new LoginDao();
		
		String userLogin = loginDao.authenticateUser(loginBean);
		if(userLogin.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.setAttribute("userid", Username);
			request.getRequestDispatcher("/StudentDashBoard.jsp").forward(request, response);
			  
            HttpSession session=request.getSession(true);
            session.setAttribute("uname",Username);
           
		}
		else   
		{
			request.setAttribute("errMessage", userLogin);
			request.getRequestDispatcher("/StudentLogin.jsp").include(request, response);
		}
		
		
		
		
		
	}

}
