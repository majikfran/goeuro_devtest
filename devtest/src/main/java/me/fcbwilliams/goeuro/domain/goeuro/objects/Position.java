package me.fcbwilliams.goeuro.domain.goeuro.objects;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Position implements IPosition {
	
	@ModelInfo(name = "_id")
	private int _id;
	@ModelInfo(name = "name")
	private String name;
	@ModelInfo(name = "type")
	private String type;
	@ModelInfo(name = "latitude")
	private double latitude;
	@ModelInfo(name = "longitude")
	private double longitude;
	
	public int get_id()
	{
		return _id;
	}
	
	public void set_id(int _id)
	{
		this._id = _id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}

	public double getLatitude()
	{
		return latitude;
	}
	
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	public double getLongitude()
	{
		return longitude;
	}
	
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
}
