package me.fcbwilliams.goeuro.domain.interfaces.objects;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;

public interface IPosition {
	@ModelInfo(name = "_id")
	int get_id();
	@ModelInfo(name = "name")
	String getName();
	@ModelInfo(name = "type")
	String getType();
	@ModelInfo(name = "latitude")
	double getLatitude();
	@ModelInfo(name = "longitude")
	double getLongitude();
}
