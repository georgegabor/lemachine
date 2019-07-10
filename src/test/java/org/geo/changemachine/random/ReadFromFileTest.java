package org.geo.changemachine.random;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Test;

public class ReadFromFileTest {

	@Test
	public void test() {
		String filename = "currency1.json";
		JSONObject actual = ReadFromFile.getJson(filename);
		
		assertTrue(actual instanceof JSONObject);
		assertFalse(actual.isEmpty());	}

}
