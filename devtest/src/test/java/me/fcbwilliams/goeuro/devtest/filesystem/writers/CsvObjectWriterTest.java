package me.fcbwilliams.goeuro.devtest.filesystem.writers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import me.fcbwilliams.goeuro.devtest.Spring.TestSpringConfiguration;
import me.fcbwilliams.goeuro.devtest.filesystem.interfaces.IFileObjectWriter;
import me.fcbwilliams.goeuro.domain.goeuro.objects.Position;
import me.fcbwilliams.goeuro.domain.interfaces.objects.IPosition;

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
	IFileObjectWriter<IPosition> csvObjectWriter;
	
	@Test
	public void writeDataTest()
	{
		String path = "testFile.csv";
		List<IPosition> objects = new ArrayList<IPosition>();
		
		Position p1 = new Position();
		p1.set_id(1);
		p1.setName("test1");
		p1.setType("location");
		p1.setLatitude(1.1);
		p1.setLongitude(1.2);
		
		Position p2 = new Position();
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
