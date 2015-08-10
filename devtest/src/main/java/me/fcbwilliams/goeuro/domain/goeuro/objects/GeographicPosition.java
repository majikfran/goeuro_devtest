package me.fcbwilliams.goeuro.domain.goeuro.objects;

import me.fcbwilliams.goeuro.domain.interfaces.objects.IGeographicPosition;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
/**
 * Concrete implementation of Geographic position interface
 * 
 * @author Francis
 */
public class GeographicPosition implements IGeographicPosition {

	private double latitude;
	private double longitude;
	
	@JsonProperty("latitude")
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	@JsonProperty("longitude")
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
	
	@Override
	@JsonProperty("latitude")
	public double getLatitude() {
		return latitude;
	}

	@Override
	@JsonProperty("longitude")
	public double getLongitude() {
		return longitude;
	}

}
