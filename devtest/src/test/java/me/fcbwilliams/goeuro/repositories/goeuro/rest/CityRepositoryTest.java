package me.fcbwilliams.goeuro.repositories.goeuro.rest;

import java.util.List;

import me.fcbwilliams.goeuro.devtest.Spring.TestSpringConfiguration;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ICity;
import me.fcbwilliams.goeuro.repositories.interfaces.IEndpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfiguration.class)
public class CityRepositoryTest {
	
	@Autowired
	IEndpoint<ICity> cityRepository;
	
	@Test
	public void getByNameTest()
	{
		List<? extends ICity> cities = cityRepository.getSuggestions("Berlin");
		Assert.assertEquals(cities.get(0).getName(), "Berlin");
	}
}
