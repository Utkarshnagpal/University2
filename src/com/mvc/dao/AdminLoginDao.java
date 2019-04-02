package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.AdminLoginBean;
import com.mvc.util.DBConnection;

public class AdminLoginDao {
	
	public String authenticateUser(AdminLoginBean AdminLoginBean)
	{
		String userName = AdminLoginBean.getUsername(); 
		String password = AdminLoginBean.getPassword();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String userNameDB = "";
		String passwordDB = "";
		try
		{
			con = DBConnection.createConnection(); 
			statement = con.createStatement(); 
			resultSet = statement.executeQuery("select userid,password from admin"); 
			while(resultSet.next()) 
			{
				userNameDB = resultSet.getString("userid"); 
				passwordDB = resultSet.getString("password");
				if(userName.equals(userNameDB) && password.equals(passwordDB))
				{
					return "SUCCESS"; 
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "Invalid user credentials"; 

}
}
