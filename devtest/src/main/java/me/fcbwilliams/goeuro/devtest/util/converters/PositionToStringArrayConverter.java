package me.fcbwilliams.goeuro.devtest.util.converters;

import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;

import org.springframework.stereotype.Component;

@Component
public class PositionToStringArrayConverter implements IObjectConverter<IPosition, String[]> {

	@Override
	public String[] convert(IPosition object) {
		String[] strings = new String[5];
		
		strings[0] = String.valueOf(object.get_id());
		strings[1] = object.getName();
		strings[2] = object.getType();
		strings[3] = String.valueOf(object.getLongitude());
		strings[4] = String.valueOf(object.getLatitude());
		
		return strings;
	}

}
