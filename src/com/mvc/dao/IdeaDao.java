package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.IdeaBean;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class IdeaDao {
	
	public String Idea(IdeaBean IdeaBean)
	{
	
	String Topic=IdeaBean.getTopic();
	String IdeaDescription=IdeaBean.getIdeaDescription();

	System.out.println(Topic);
	System.out.println(IdeaDescription);
	
	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "insert into Idea(Topic,IdeaDescription) values (?,?)"; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		preparedStatement.setString(1, Topic);
		preparedStatement.setString(2, IdeaDescription);
		int i= preparedStatement.executeUpdate();
		if (i!=0)  //Just to ensure data has been inserted into the database
		return "SUCCESS"; 
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
}
}