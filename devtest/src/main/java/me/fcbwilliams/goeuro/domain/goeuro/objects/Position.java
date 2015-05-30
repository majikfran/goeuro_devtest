package me.fcbwilliams.goeuro.domain.goeuro.objects;

import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Position implements IPosition {
	
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