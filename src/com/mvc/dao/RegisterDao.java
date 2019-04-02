package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
public class RegisterDao 
{
	public String registerUser(RegisterBean registerBean)
	{
		String firstName=registerBean.getFirstName();
		String lastName=registerBean.getLastName();
		String MobileNum=registerBean.getMobileNum();
		String email=registerBean.getEmail();
		String userid=registerBean.getUserid();
		String password=registerBean.getPassword();
		String age=registerBean.getAge();
		String club=registerBean.getClub();
		String gender=registerBean.getGender();
		
		
		
		
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(MobileNum);
		System.out.println(email);
		System.out.println(userid);
		System.out.println(password);
		System.out.println(age);
		System.out.println(club);
		System.out.println(gender);
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
			con = DBConnection.createConnection();
			String query = "insert into studentregister(firstName,lastName,MobileNum,email,userid,password,age,club,gender) values (?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, MobileNum);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, userid);
			preparedStatement.setString(6, password);
			preparedStatement.setString(7, age);
			preparedStatement.setString(8, club);
			preparedStatement.setString(9, gender);
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