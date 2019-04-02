package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.AdminLoginBean;
import com.mvc.bean.LoginBean;
import com.mvc.dao.AdminLoginDao;
import com.mvc.dao.LoginDao;


public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginServlet() 
    {
        super();   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String Username= request.getParameter("userid");
		String Password= request.getParameter("password");
		
		
		AdminLoginBean AdminLoginBean = new AdminLoginBean();
		
		AdminLoginBean.setUsername(Username);
		AdminLoginBean.setPassword(Password);
		
		
          AdminLoginDao AdminLoginDao = new AdminLoginDao();
		
		String userLogin = AdminLoginDao.authenticateUser(AdminLoginBean);
		if(userLogin.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			request.setAttribute("userid", Username);
			request.getRequestDispatcher("/AdminDashBoard.jsp").forward(request, response);
	  
            HttpSession session=request.getSession(true);
            session.setAttribute("uname",Username);

		}
		else   
		{
			request.setAttribute("errMessage", userLogin);
			request.getRequestDispatcher("/AdminLogin.jsp").include(request, response);
		}
	}

}
