package me.fcbwilliams.goeuro.domain.goeuro.objects;

import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
/**
 * Concrete implementaion of Location domain object
 * 
 * @author Francis
 */
public class Location implements ILocation {
	
	private int _id;
	private String name;
	private String type;
	@JsonProperty("geo_position")
	private GeographicPosition geographicPosition = new GeographicPosition();
	
	@Override
	@JsonProperty("_id")
	public int get_id()
	{
		return _id;
	}
	
	@JsonProperty("_id")
	public void set_id(int _id)
	{
		this._id = _id;
	}
	
	@Override
	@JsonProperty("name")
	public String getName()
	{
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	@JsonProperty("type")
	public String getType()
	{
		return type;
	}
	
	@JsonProperty("type")
	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public double getLatitude()
	{
		return geographicPosition.getLatitude();
	}
	
	@Override
	public double getLongitude()
	{
		return geographicPosition.getLongitude();
	}

	@Override
	@JsonProperty("geo_position")
	public GeographicPosition getGeographicPosition() {
		return geographicPosition;
	}
	
	@JsonProperty("geo_position")
	public void setGeographicPosition(GeographicPosition geographicPosition)
	{
		this.geographicPosition = geographicPosition;
	}
}
