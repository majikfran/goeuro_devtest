package me.fcbwilliams.goeuro.devtest.UI.CLI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.UI.interfaces.IUserInterface;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * A basic CLI user interface.
 * 
 * @author Francis
 */
public class SimpleDevtestCLIInterface implements IUserInterface {

	@Autowired
	IRestEndpoint<ILocation> endpoint;
	@Autowired
	IFileObjectWriter<ILocation> writer;
	
	private String parameter;
	private String headerPath;
	private String greeting;
	private String farewell;
	
	/**
	 * Constructor
	 * 
	 * @param parameter The parameter for the REST service request
	 * @param headerPath The path to the desired CLI Header
	 * @param greeting A greeting message
	 * @param farewell A farewell message
	 */
	public SimpleDevtestCLIInterface(String parameter, String headerPath, String greeting, String farewell) {
		this.parameter = parameter;
		this.headerPath = headerPath;
		this.greeting = greeting;
		this.farewell = farewell;
	}	
	
	@Override
	public void start() {
		printHeader();
		printGreeting();
		
		//Request data from the endpoint.
		List<? extends ILocation> positions = (List<? extends ILocation>)endpoint.getData(parameter);
		try {
			writer.writeData(positions);
		} catch (IOException e) {
			System.out.print(
				"Unable to write to specified path. The\n" +
				"output path can be specified in the\n" +
				"application.properties file, or specified as\n" +
				"a command line argument with the -o option.\n" +
				"StackTrace:\n" +
				e.getStackTrace()
			);
		}
		
		printFarewell();
	}
	
	/**
	 * Prints the header message from file.
	 */
	private void printHeader()
	{
		try{
			URI headerAbsolutePath = this.getClass().getResource(headerPath).toURI();
			
			List<String> headerLines = Files.readAllLines(Paths.get(headerAbsolutePath), Charset.forName("UTF-8"));
			
			for(String s : headerLines)
			{
				System.out.println(s);
			}
		}
		catch(IOException e)
		{
			System.out.println("Unable to find header file");
		}
		catch(URISyntaxException e)
		{
			System.out.println("header URI Syntax Exception\nUnable to print header");
		}
	}
	
	private void printGreeting()
	{
		System.out.println(greeting);
	}
	
	private void printFarewell()
	{
		System.out.println(farewell);
	}
}
