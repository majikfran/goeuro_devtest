package me.fcbwilliams.goeuro.devtest.UI.CLI;

import java.io.IOException;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.UI.interfaces.IUserInterface;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleDevtestCLIInterface implements IUserInterface {

	@Autowired
	IRestEndpoint<ILocation> endpoint;
	@Autowired
	IFileObjectWriter<ILocation> writer;
	
	private String parameter;
	private String outputPath;
	
	public SimpleDevtestCLIInterface(String parameter, String outputPath) {
		this.parameter = parameter;
		this.outputPath = outputPath;
	}	
	
	@Override
	public void start() {
		printHeader();
		printGreeting();
		
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
	
	private void printHeader()
	{
		
	}
	
	private void printGreeting()
	{
		
	}
	
	private void printFarewell()
	{
		
	}
}
