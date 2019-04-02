package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.DCampaignBean;
import com.mvc.util.DBConnection;

public class DCampaignDao {
	
	public String deleteCampaign(DCampaignBean DCampaignBean)
	{
	
	String CName=DCampaignBean.getCName();


	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "delete from Campaign where CName=?"; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

		preparedStatement.setString(1, CName);
		
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
