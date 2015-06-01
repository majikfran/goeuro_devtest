package me.fcbwilliams.goeuro.domain.goeuro.objects;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IGeographicPosition;

@JsonIgnoreProperties
public class GeographicPosition implements IGeographicPosition {

	@ModelInfo(name = "latitude")
	private double latitude;
	@ModelInfo(name = "longitude")
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
