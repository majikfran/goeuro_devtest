package me.fcbwilliams.goeuro.domain.goeuro.objects;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IGeographicPosition;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Location implements ILocation {
	
	@ModelInfo(name = "_id")
	private int _id;
	@ModelInfo(name = "name")
	private String name;
	@ModelInfo(name = "type")
	private String type;

	private IGeographicPosition geographicPosition = new GeographicPosition();
	
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
	public IGeographicPosition getGeographicPosition() {
		return geographicPosition;
	}
	
	@JsonProperty("geo_position")
	public void setGeographicPosition(IGeographicPosition geographicPosition)
	{
		this.geographicPosition = geographicPosition;
	}
}
