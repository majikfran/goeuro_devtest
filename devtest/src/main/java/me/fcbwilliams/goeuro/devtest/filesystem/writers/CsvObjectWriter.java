package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.annotations.ModelInfo;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVWriter;

public class CsvObjectWriter<T> implements IFileObjectWriter<T>{

	@Autowired
	IObjectConverter<T, String[]> tToStringArrayConverter;
	
	@Override
	public void writeData(List<? extends T> objects, String path) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(path, false), CSVWriter.DEFAULT_SEPARATOR);
		
		List<String[]> toWrite = new ArrayList<String[]>();
		List<String> headers = new ArrayList<String>();
		
		for(Field f : ((T) objects.get(0)).getClass().getDeclaredFields())
		{
			ModelInfo[] modelInfos = f.getAnnotationsByType(ModelInfo.class);
			if(modelInfos.length != 0)
				headers.add(modelInfos[0].name());
		}
		
		toWrite.add(headers.toArray(new String[headers.size()]));
	
		for(T o : objects)
		{
			String[] data = tToStringArrayConverter.convert(o);
			toWrite.add(data);
		}
		
		csvWriter.writeAll(toWrite, false);
		
		csvWriter.close();
	}
}
