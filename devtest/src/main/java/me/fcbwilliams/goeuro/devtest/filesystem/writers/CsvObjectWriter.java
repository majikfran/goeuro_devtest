package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVWriter;

/**
 * A concrete implementation of IFileObjectWriter specifically
 * for writing objects to CSV files.
 * 
 * @author Francis
 *
 * @param <T> The type of object to write.
 */
public class CsvObjectWriter<T> implements IFileObjectWriter<T>{

	@Autowired
	IObjectConverter<T, String[]> tToStringArrayConverter;
	
	private String[] headers;
	private String outputPath;
	
	/**
	 * Constructor
	 * 
	 * @param headers The header strings for the CSV file. Would have liked
	 * to retrieved these directly from the object, but this required reflection.
	 * @param outputPath The directory path to the target CSV file.
	 */
	public CsvObjectWriter(String[] headers, String outputPath) {
		this.headers = headers;
		this.outputPath = outputPath;
	}
	
	@Override
	/**
	 * Writes the objects to a CSV where a property is represented
	 * as a column.
	 */
	public void writeData(List<? extends T> objects) throws IOException {
		CSVWriter csvWriter = new CSVWriter(new FileWriter(outputPath, false), CSVWriter.DEFAULT_SEPARATOR);
		
		//Write the column headers first
		csvWriter.writeNext(headers, false);
		
		//Convert the object collection into a string array collection
		List<String[]> toWrite = new ArrayList<String[]>();
		for(T o : objects)
		{
			String[] data = tToStringArrayConverter.convert(o);
			toWrite.add(data);
		}
		
		//Write the data
		csvWriter.writeAll(toWrite, false);
		
		csvWriter.close();
	}
}
