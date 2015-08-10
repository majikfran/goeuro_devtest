package me.fcbwilliams.goeuro.domain.interfaces.objects;

import me.fcbwilliams.goeuro.domain.goeuro.objects.GeographicPosition;

/**
 * Interface for Location domain objects.
 * 
 * @author Francis
 */
public interface ILocation {
	int get_id();
	String getName();
	String getType();
	double getLatitude();
	double getLongitude();
	GeographicPosition getGeographicPosition();
}
