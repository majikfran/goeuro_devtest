package me.fcbwilliams.goeuro.repositories.goeuro.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import me.fcbwilliams.goeuro.domain.goeuro.objects.City;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ICity;
import me.fcbwilliams.goeuro.repositories.interfaces.IRepository;

public class CityRepository implements IRepository<ICity>{

	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${goeuro.apiBasePath}")
	private String apiBasePath;
	
	@Value("${goeuro.apiVersionPath}")
	private String apiVersionPath;
	
	public ICity getById(int id) {
		throw new UnsupportedOperationException();
	}

	public ICity getByName(String name) {
		ICity city = restTemplate.getForObject(apiBasePath + apiVersionPath + "position/suggestion/en", City.class);
		return city;
	}
	
	public void create(ICity entity) {
		throw new UnsupportedOperationException();
	}

	public void delete(ICity entity) {
		throw new UnsupportedOperationException();
	}

	public void update(ICity entity) {
		throw new UnsupportedOperationException();
	}
}
