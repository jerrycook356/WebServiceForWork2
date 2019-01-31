package com.jerrycook.WebserviceForWork2.DatabaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

	
	public DatabaseHelper()
	{
		
	}
	public Connection getConnection()
	{
		Connection con = null;
		
		//test string for laptop
		//String dbUrl = "jdbc:ucanaccess://C:/Users/jerry/Downloads/weigh.mdb";
		
		//string to connect to database from scale server
		String dbUrl = "jdbc:ucanaccess://C:/Program Files (x86)/WeighMaster/Data/weigh.mdb" ;
				
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			con = DriverManager.getConnection(dbUrl);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}