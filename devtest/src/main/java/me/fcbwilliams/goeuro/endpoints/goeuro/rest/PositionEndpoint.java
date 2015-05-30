package me.fcbwilliams.goeuro.endpoints.goeuro.rest;

import java.nio.charset.Charset;
import java.util.List;

import org.junit.experimental.theories.ParametersSuppliedBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import me.fcbwilliams.goeuro.domain.goeuro.objects.City;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ICity;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

@Component
public class PositionEndpoint implements IRestEndpoint<ICity>{

	RestTemplate restTemplate = new RestTemplate();
	
	private String apiBasePath;
	private String apiVersionPath;

	public PositionEndpoint(String apiBasePath, String apiVersionPath)
	{
		this.apiBasePath = apiBasePath;
		this.apiVersionPath = apiVersionPath;
	}

	public List<? extends ICity> getData(String parameter) {
		ParameterizedTypeReference<List<City>> responseType = new ParameterizedTypeReference<List<City>>(){};
		ResponseEntity<List<City>> cities = restTemplate.exchange(apiBasePath + apiVersionPath + "position/suggest/en/" + parameter, HttpMethod.GET, null, responseType);
		return cities.getBody();
	}
}
