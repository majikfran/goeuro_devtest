package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.Spring.TestSpringConfiguration;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.domain.goeuro.objects.Location;
import me.fcbwilliams.goeuro.domain.interfaces.objects.ILocation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfiguration.class)
public class CsvObjectWriterTest {

	@Autowired
	IFileObjectWriter<ILocation> csvObjectWriter;
	
	@Test
	public void writeDataTest()
	{
		String path = "testFile.csv";
		List<ILocation> objects = new ArrayList<ILocation>();
		
		Location p1 = new Location();
		p1.set_id(1);
		p1.setName("test1");
		p1.setType("location");
		p1.setLatitude(1.1);
		p1.setLongitude(1.2);
		
		Location p2 = new Location();
		p2.set_id(2);
		p2.setName("test2");
		p2.setType("airport");
		p2.setLatitude(2.1);
		p2.setLongitude(2.2);
		
		objects.add(p1);
		objects.add(p2);
		
		try {
			csvObjectWriter.writeData(objects, path);
			List<String> lines = Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
			Assert.assertEquals("_id,name,type,latitude,longitude",lines.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
