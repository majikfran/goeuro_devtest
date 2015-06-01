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
	private String outputPath;
	
	public CsvObjectWriter(String outputPath) {
		this.outputPath = outputPath;
	}
	
	@Override
	public void writeData(List<? extends T> objects, String path) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(path, false), CSVWriter.DEFAULT_SEPARATOR);
		
		List<String[]> toWrite = new ArrayList<String[]>();
	
		for(T o : objects)
		{
			String[] data = tToStringArrayConverter.convert(o);
			toWrite.add(data);
		}
		
		csvWriter.writeAll(toWrite, false);
		
		csvWriter.close();
	}

	@Override
	public void writeHeader(String[] headers) {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(path, false), CSVWriter.DEFAULT_SEPARATOR);
				
		csvWriter.writeNext(headers, false);
		
		csvWriter.close();
	}
}
