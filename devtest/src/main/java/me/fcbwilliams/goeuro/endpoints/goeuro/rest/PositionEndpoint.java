package me.fcbwilliams.goeuro.endpoints.goeuro.rest;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import me.fcbwilliams.goeuro.domain.goeuro.objects.Position;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

@Component
public class PositionEndpoint implements IRestEndpoint<IPosition>{

	RestTemplate restTemplate = new RestTemplate();
	
	private String apiBasePath;
	private String apiVersionPath;

	public PositionEndpoint(String apiBasePath, String apiVersionPath)
	{
		this.apiBasePath = apiBasePath;
		this.apiVersionPath = apiVersionPath;
	}

	@Override
	public List<? extends IPosition> getData(String parameter) {
		ParameterizedTypeReference<List<Position>> responseType = new ParameterizedTypeReference<List<Position>>(){};
		ResponseEntity<List<Position>> cities = restTemplate.exchange(apiBasePath + apiVersionPath + "position/suggest/en/" + parameter, HttpMethod.GET, null, responseType);
		return cities.getBody();
	}
}
