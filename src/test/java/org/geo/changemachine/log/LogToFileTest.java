package org.geo.changemachine.log;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

public class LogToFileTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LogToFile logToFile = new LogToFile();
		String username1 = "Papi";
		String username2 = "Mami";
		int price = 111;
		String currency = "HUF";
		long time = 34L;
		logToFile.write(username1, price, currency, time);
		logToFile.write(username2, price, currency, time);
	}

	@Test
	public void test() {
		File file1 = new File("Papi.txt");
		File file2 = new File("Mami.txt");
		
		assertTrue(file1.exists());
		assertTrue(file2.exists());
		
		try {
			assertTrue("The files differ!", FileUtils.contentEquals(file1, file2));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
