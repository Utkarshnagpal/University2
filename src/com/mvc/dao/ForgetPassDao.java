package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.ForgetPassBean;
import com.mvc.util.DBConnection;

public class ForgetPassDao {

	public String forgetPass(ForgetPassBean ForgetPassBean)
	{
		String userid=ForgetPassBean.getUserid();
		String password=ForgetPassBean.getPassword();
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "update studentregister set password=? where userid=? ";
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			
			preparedStatement.setString(2, userid);
			preparedStatement.setString(1, password);
			
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


