/**
 * @author geo
 */

package org.geo.changemachine.random;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadFromFile {
	
	public static JSONObject getJson(String filename) {
		JSONParser parser = new JSONParser();
		JSONObject jsonobject = null;
		try {
			Object obj = parser.parse(new FileReader(filename));
			jsonobject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException | ParseException e) {
			System.out.println(e);
		}
		return jsonobject;
	}
}
