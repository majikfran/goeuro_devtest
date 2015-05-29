package me.fcbwilliams.goeuro.domain.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
public class City {
	
	private int _id;
	private String name;
	private String type;
	private double latitude;
	private double longitude;
	
	public int get_id()
	{
		return _id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public double getLatitude()
	{
		return latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
}
