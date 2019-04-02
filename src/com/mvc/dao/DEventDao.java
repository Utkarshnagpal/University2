package com.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.DEventBean;
import com.mvc.util.DBConnection;

public class DEventDao {
	
	public String deleteEvent(DEventBean DEventBean)
	{
	
	String EId=DEventBean.getEId();


	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "delete from AddEvent where EId=?"; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

		preparedStatement.setString(1, EId);
		
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
