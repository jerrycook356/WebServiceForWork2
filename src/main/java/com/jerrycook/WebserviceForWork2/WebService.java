package com.jerrycook.WebserviceForWork2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.jerrycook.WebserviceForWork2.DatabaseHelper.DatabaseHelper;
import com.jerrycook.WebserviceForWork2.Model.Transaction;

@Path("WebService")

public class WebService {
	DatabaseHelper db = new DatabaseHelper();

	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll()
	
	{
		ArrayList<Transaction> trans = new ArrayList<>();
        
		Connection con = db.getConnection();

		try {
			String sql = "SELECT * FROM [MATERIAL TRANSACTION] ";
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Transaction transaction = new Transaction();
				transaction.setTruckId(rs.getString(2));
				transaction.setSource(rs.getString(4));
				transaction.setDestination(rs.getString(5));
				transaction.setCustomer(rs.getString(8));

				trans.add(transaction);

			}
			ps.close();
			con.close();
			rs.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String returnString = gson.toJson(trans);
		return returnString;
	}
	
	@GET
	@Path("getSources")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSources()
	{
		
		
		ArrayList<String> sources = new ArrayList<String>();
		Connection con = db.getConnection();
		try
		{
			String sql = "SELECT * FROM [Source]";
			PreparedStatement ps = con.prepareStatement(sql);
				
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				sources.add(rs.getString(1));
			}
			ps.close();
			con.close();
			rs.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String returnString = gson.toJson(sources);
		return returnString;
		
	}
	
	@GET
	@Path("getDestinations")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDestinations()
	{
		ArrayList<String>destinations = new ArrayList<String>();
		Connection con = db.getConnection();
		try {
			String sql = "SELECT * FROM [Destination]";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				destinations.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String returnString = gson.toJson(destinations);
		return returnString;
	}
	
	@GET
	@Path("getCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCustomers()
	{
		ArrayList<String>customers = new ArrayList<String>();
		
		Connection con = db.getConnection();
	    try
		{
	    	String sql = "SELECT * FROM [Customer]";
	    	PreparedStatement ps = con.prepareStatement(sql);
	    	ResultSet rs = ps.executeQuery();
	    	while(rs.next())
	    	{
	    		customers.add(rs.getString(1));
	    	}
	    	rs.close();
	    	ps.close();
	    	con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String returnString = gson.toJson(customers);
		return returnString;
	}
	
	@GET
	@Path("getBySelection")
	
	@Produces(MediaType.APPLICATION_JSON)
	public String getBySelection(@QueryParam("startDate")String startDate,
			@QueryParam("endDate")String endDate,@QueryParam("source")String source,
			@QueryParam("destination")String destination,@QueryParam("customer")String customer)
	{
		
		Connection con = db.getConnection();
		ArrayList<Transaction>selectedResults = new ArrayList<Transaction>();
		try
		{
			String sql = "SELECT * FROM [MATERIAL TRANSACTION] WHERE [GROSS TIMESTAMP] BETWEEN ? AND ?"+
			" AND [SOURCE] = ? AND [DESTINATION] = ? AND [CUSTOMER] = ?";
			
			 // date time must be in this format 2018-11-27 00:00:00.000000
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, startDate);
			ps.setString(2,endDate);			
			ps.setString(3, source);		
			ps.setString(4, destination);
			ps.setString(5, customer);
			
						
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Transaction transaction = new Transaction();
				transaction.setTruckId(rs.getString(2));
				transaction.setSource(rs.getString(4));
				transaction.setDestination(rs.getString(5));
				transaction.setCustomer(rs.getString(8));
				transaction.setGrossWeight(rs.getString(13));
				transaction.setTareWeight(rs.getString(17));
				transaction.setTimeStamp(rs.getString(15));
				transaction.setStartDate("");
				transaction.setEndDate("");
				
				selectedResults.add(transaction);
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String returnString = gson.toJson(selectedResults);
		
		return returnString;
		
	}
}
