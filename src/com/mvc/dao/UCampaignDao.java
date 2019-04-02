package com.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.UCampaignBean;
import com.mvc.util.DBConnection;

public class UCampaignDao {
	
	public String updateCampaign(UCampaignBean UCampaignBean)
	{
	
	String CName=UCampaignBean.getCName();
	Date CSDate=(Date) UCampaignBean.getCSDate();
	Date CEDate=(Date) UCampaignBean.getCEDate();
    System.out.println(CSDate);
    System.out.println(CEDate);

	Connection con = null;
	PreparedStatement preparedStatement = null;
	try
	{
		con = DBConnection.createConnection();
		String query = "update Campaign SET CSDate=? , CEDate=? where CName=? "; //Insert user details into the table 'USERS'
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

		preparedStatement.setString(3, CName);
		preparedStatement.setDate(1, CSDate);
		preparedStatement.setDate(2, CEDate);
		
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


