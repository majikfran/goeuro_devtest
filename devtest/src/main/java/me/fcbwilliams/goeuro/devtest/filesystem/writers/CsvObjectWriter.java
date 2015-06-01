package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVWriter;

public class CsvObjectWriter<T> implements IFileObjectWriter<T>{

	@Autowired
	IObjectConverter<T, String[]> tToStringArrayConverter;
	
	private String[] headers;
	private String outputPath;
	
	public CsvObjectWriter(String[] headers, String outputPath) {
		this.headers = headers;
		this.outputPath = outputPath;
	}
	
	@Override
	public void writeData(List<? extends T> objects) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(outputPath, false), CSVWriter.DEFAULT_SEPARATOR);
		
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
	public void writeHeaders() throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(outputPath, false), CSVWriter.DEFAULT_SEPARATOR);
				
		csvWriter.writeNext(headers, false);
		
		csvWriter.close();
	}
}
