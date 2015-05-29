package me.fcbwilliams.goeuro.devtest.Spring;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.domain.interfaces.objects.ICity;
import me.fcbwilliams.goeuro.endpoints.goeuro.rest.PositionEndpoint;
import me.fcbwilliams.goeuro.endpoints.interfaces.IEndpoint;

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
	
	@Bean
	public IEndpoint<ICity> cityRepository()
	{
		return new PositionEndpoint(apiBasePath, apiVersionPath);
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
