package com.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.UEventBean;
import com.mvc.util.DBConnection;

public class UEventDao
{
	public String updateEvent(UEventBean UEventBean)
	{
	
	String EId=UEventBean.getEId();
	Date EDate=(Date) UEventBean.getEDate();
    System.out.println(EDate);

	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "update AddEvent SET EDate=? where EId=? "; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

		preparedStatement.setString(2, EId);
		preparedStatement.setDate(1, EDate);
		
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
