package me.fcbwilliams.goeuro.devtest.Spring;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.devtest.filesystem.writers.CsvObjectWriter;
import me.fcbwilliams.goeuro.devtest.util.converters.PositionToStringArrayConverter;
import me.fcbwilliams.goeuro.devtest.util.interfaces.IObjectConverter;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;
import me.fcbwilliams.goeuro.endpoints.goeuro.rest.PositionEndpoint;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
@PropertySource("classpath:application.properties")
public class TestSpringConfiguration {
	
	@Value("${goeuro.apiBasePath}")
	private String apiBasePath;
	
	@Value("${goeuro.apiVersionPath}")
	private String apiVersionPath;
	
	@Value("${goeuro.headers}")
	private String headers;

	private String outputPath = "testFile.csv";
	
	@Bean
	public IRestEndpoint<ILocation> positionEndpoint()
	{
		return new PositionEndpoint(apiBasePath, apiVersionPath);
	}
	
	@Bean 
	public IFileObjectWriter<ILocation> csvObjectWriter()
	{
		String[] outputHeaders = headers.split(",");
		return new CsvObjectWriter<ILocation>(outputHeaders, outputPath);
	}
	
	@Bean 
	public IObjectConverter<ILocation, String[]> tToStringArrayConverter()
	{
		return new PositionToStringArrayConverter();
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter jacksonMessageConverter()
	{
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
		converter.setSupportedMediaTypes(mediaTypes);
		
		return converter;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
