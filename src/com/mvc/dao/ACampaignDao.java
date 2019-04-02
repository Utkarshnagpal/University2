package com.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.*;

import com.mvc.bean.ACampaignBean;
import com.mvc.util.DBConnection;

public class ACampaignDao {
	
	public String addCampaign(ACampaignBean ACampaignBean)
	{
		String CName=ACampaignBean.getCName();
		Date CSDate=(Date) ACampaignBean.getCSDate();
		Date CEDate=(Date) ACampaignBean.getCEDate();
		String CContactPerson=ACampaignBean.getCContactPerson();
		String EventName=ACampaignBean.getEventName();
		
		
		System.out.println(CName);
		System.out.println(CSDate);
		System.out.println(CEDate);
		System.out.println(CContactPerson);
		System.out.println(EventName);
		
	
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into Campaign(CName,CSDate,CEDate,CContactPerson,EventName) values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, CName);
			preparedStatement.setDate(2, CSDate);
			preparedStatement.setDate(3, CEDate);
			preparedStatement.setString(4, CContactPerson);
			preparedStatement.setString(5, EventName);
			
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
