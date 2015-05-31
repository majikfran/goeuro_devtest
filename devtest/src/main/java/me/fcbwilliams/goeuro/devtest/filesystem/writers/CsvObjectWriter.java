package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVWriter;
import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;

public class CsvObjectWriter<T> implements IFileObjectWriter<T>{

	@Autowired
	IObjectConverter<T, String[]> tToStringArrayConverter;
	
	@Override
	public void writeData(T[] objects, String path) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(path, false), ',');
		
		List<String> headers = new ArrayList<String>();
		
		for(Field f : ((T) objects[0]).getClass().getDeclaredFields())
		{
			ModelInfo[] modelInfos = f.getAnnotationsByType(ModelInfo.class);
			if(modelInfos.length != 0)
				headers.add(modelInfos[0].name());
		}
		
		csvWriter.writeNext(headers.toArray(new String[headers.size()]));
		
		for(T o : objects)
		{
			String[] data = tToStringArrayConverter.convert(o);
			csvWriter.writeNext(data);
		}
		
		csvWriter.close();
	}
}
