package me.fcbwilliams.goeuro.endpoints.goeuro.rest;

import java.util.List;

import me.fcbwilliams.goeuro.domain.goeuro.objects.Location;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Concrete implementation for Locations
 * 
 * @author Francis
 *
 */
public class PositionEndpoint implements IRestEndpoint<ILocation>{

	RestTemplate restTemplate = new RestTemplate();
	
	private String apiBasePath;
	private String apiVersionPath;

	/**
	 * Constructor
	 * 
	 * @param apiBasePath The base URL of the Rest service
	 * @param apiVersionPath The version of the service
	 */
	public PositionEndpoint(String apiBasePath, String apiVersionPath)
	{
		this.apiBasePath = apiBasePath;
		this.apiVersionPath = apiVersionPath;
	}

	/**
	 * Request data and convert to List of location domain object
	 */
	@Override
	public List<? extends ILocation> getData(String parameter) {
		ParameterizedTypeReference<List<Location>> responseType = new ParameterizedTypeReference<List<Location>>(){};
		ResponseEntity<List<Location>> cities = restTemplate.exchange(apiBasePath + apiVersionPath + "position/suggest/en/" + parameter, HttpMethod.GET, null, responseType);
		return cities.getBody();
	}
}
