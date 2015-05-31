package me.fcbwilliams.goeuro.domain.interfaces.objects;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;

public interface IPosition {
	int get_id();
	String getName();
	String getType();
	double getLatitude();
	double getLongitude();
}
