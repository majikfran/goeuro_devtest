package me.fcbwilliams.goeuro.repositories.goeuro.rest;

import java.util.List;

import me.fcbwilliams.goeuro.devtest.Spring.TestSpringConfiguration;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;
import me.fcbwilliams.goeuro.endpoints.interfaces.IRestEndpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfiguration.class)
public class PositionEndpointTest {
	
	@Autowired
	IRestEndpoint<IPosition> positionEndpoint;
	
	@Test
	public void getDataTest()
	{
		List<? extends IPosition> locations = positionEndpoint.getData("Berlin");
		Assert.assertEquals(locations.get(0).getName(), "Berlin");
		Assert.assertEquals(locations.get(0).get_id(), 376217);
		Assert.assertEquals(locations.get(0).getType(), "location");
		Assert.assertEquals(locations.get(0).getLatitude(), 0, 52.52437);
		Assert.assertEquals(locations.get(0).getLongitude(), 0, 13.41053);
		
		Assert.assertEquals(locations.get(1).getName(), "Berlingo");
		Assert.assertEquals(locations.get(1).get_id(), 448103);
		Assert.assertEquals(locations.get(1).getType(), "location");
		Assert.assertEquals(locations.get(1).getLatitude(), 0, 45.50298);
		Assert.assertEquals(locations.get(1).getLongitude(), 0, 10.04366);
		
		locations = positionEndpoint.getData("Potsdam");
		Assert.assertEquals(locations.get(0).getName(), "Potsdam");
		Assert.assertEquals(locations.get(0).get_id(), 377078);
		Assert.assertEquals(locations.get(0).getType(), "location");
		Assert.assertEquals(locations.get(0).getLatitude(), 0, 52.39886);
		Assert.assertEquals(locations.get(0).getLongitude(), 0, 13.06566);
		
		Assert.assertEquals(locations.get(1).getName(), "Potsdam");
		Assert.assertEquals(locations.get(1).get_id(), 410978);
		Assert.assertEquals(locations.get(1).getType(), "location");
		Assert.assertEquals(locations.get(1).getLatitude(), 0, 44.66978);
		Assert.assertEquals(locations.get(1).getLongitude(), 0, -74.98131);
	}
}
