package com.mvc.dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.mvc.bean.AEventBean;
import com.mvc.util.DBConnection;

public class AEventDao {

	public String addEvent(AEventBean AEventBean)
	{
		String EName=AEventBean.getEName();
		String EId=AEventBean.getEId();
		Date EDate=(Date) AEventBean.getEDate();
		String EDescription=AEventBean.getEDescription();
		
		
		System.out.println(EName);
		System.out.println(EId);
		System.out.println(EDate);
		System.out.println(EDescription);
		
	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into AddEvent(EName,EId,EDate,EDescription) values (?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, EName);
			preparedStatement.setString(2, EId);
			preparedStatement.setDate(3, EDate);
			preparedStatement.setString(4, EDescription);
			
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
