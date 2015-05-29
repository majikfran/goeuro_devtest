package me.fcbwilliams.goeuro.devtest.Spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import me.fcbwilliams.goeuro.domain.interfaces.objects.*;
import me.fcbwilliams.goeuro.endpoints.goeuro.rest.PositionEndpoint;
import me.fcbwilliams.goeuro.endpoints.interfaces.IEndpoint;


@Configuration
@ComponentScan("me.fcbwilliams.goeuro")
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

	@Value("${goeuro.apiBasePath}")
	private String apiBasePath;
	
	@Value("${goeuro.apiVersionPath}")
	private String apiVersionPath;
	
	@Bean
	public IEndpoint<ICity> cityRepository()
	{
		return new PositionEndpoint(apiBasePath, apiVersionPath);
	}
}
