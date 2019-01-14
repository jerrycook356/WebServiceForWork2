package com.jerrycook.WebserviceForWork2.Model;

public class Transaction {

	private String truckId="";
	private String source="";
	private String destination="";
	private String customer="";
	
	private String grossWeight="";
	private String tareWeight="";
	private String timeStamp="";
	private String startDate = "";
	private String endDate = "";
	
	public Transaction()
	{
		
	}
	
	
	public Transaction (String truckId, String source, String destination, String customer)
	{
		this.truckId = truckId;
		this.source = source;
		this.destination = destination;
		this.customer = customer;
		
	}
	
	public Transaction(String source, String destination, String customer)
	{
		this.truckId = "";
		this.source = source;
		this.destination = destination;
		this.customer = customer;
	}
	
	
	public String getTimeStamp()
	{
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp)
	{
		this.timeStamp = timeStamp;
	}
	public String getGrossWeight()
	{
		return grossWeight;
	}
	public void setGrossWeight(String grossWeight)
	{
		this.grossWeight = grossWeight;
	}
	
	public String getTareWeight()
	{
		return tareWeight;
	}
	
	public void setTareWeight(String tareWeight)
	{
		this.tareWeight = tareWeight;
	}
	
	public String getTruckId() {
		return truckId;
	}
	public void setTruckId(String truckId) {
		this.truckId = truckId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	

}
