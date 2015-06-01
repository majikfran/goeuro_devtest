package me.fcbwilliams.goeuro.domain.interfaces.objects;


public interface ILocation {
	int get_id();
	String getName();
	String getType();
	double getLatitude();
	double getLongitude();
	IGeographicPosition getGeographicPosition();
}
