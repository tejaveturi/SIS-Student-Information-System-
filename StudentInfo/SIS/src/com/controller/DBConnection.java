package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
static Connection con=null;
public static Connection getConnection()
{
	
	ResourceBundle rb=ResourceBundle.getBundle("com.controller.DB");
	String classname=rb.getString("classname");
	String url=rb.getString("url");
	String uname=rb.getString("username");
	String pwd=rb.getString("password");
	
	try {
		Class.forName(classname);
		con=DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connection created");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}
