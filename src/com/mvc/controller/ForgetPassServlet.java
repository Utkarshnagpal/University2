package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.ForgetPassBean;
import com.mvc.dao.ForgetPassDao;




public class ForgetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ForgetPassServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid= request.getParameter("userid");
		String password= request.getParameter("password");
		
		
		
		ForgetPassBean ForgetPassBean = new ForgetPassBean();
	
		ForgetPassBean.setUserid(userid);
		ForgetPassBean.setPassword(password);
		
		
		ForgetPassDao ForgetPassDao = new ForgetPassDao();
		
		String forgetPassword = ForgetPassDao.forgetPass(ForgetPassBean);
		if(forgetPassword.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		{
			
			System.out.print("<br><br><br><br><br><br><br>");
			System.out.print("Password updated successfully!!<br><br><br>");
			request.getRequestDispatcher("/StudentLogin.jsp").forward(request, response);

		}
		else   
		{
			System.out.println("Invalid!");
			request.setAttribute("errMessage", forgetPassword);
			request.getRequestDispatcher("/Register.jsp").include(request, response);
		}
		
	
	}

}
