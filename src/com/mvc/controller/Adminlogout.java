package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Adminlogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Adminlogout() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("Home.jsp").include(request, response); 
        HttpSession session= request.getSession(false);
        session.invalidate();
                        out.print("You are successfully logged out!");
                        out.close(); 
	}

}





