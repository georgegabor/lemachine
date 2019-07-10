/**
 * @author geo
 */

package org.geo.changemachine.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;

public class PickRandomCurrency implements IRandomCurrency{
	private String randomcurrency;
	private static JSONObject jsonobject;
	private String filename = "currency1.json";
	private static List<?> stringlist;
	private static List<Integer> intlistofnotes = new ArrayList<Integer>();
	private static List<String> stringlistofnotes = new ArrayList<String>();
	
	public PickRandomCurrency() {}
	
	public PickRandomCurrency(String filename) {
		this.filename = filename;
	}

/************** Methods ******************/
	
	public int getRandomInt(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
	public void getJson(String fname) {
		jsonobject = ReadFromFile.getJson(fname);
	}
		
	public void getList() {
		stringlist = (List<?>) jsonobject.keySet().stream().collect(Collectors.toList());
	}
	
	public void pickRandomCurrency() {
		int min = 0;
		int max = stringlist.size() - 1;
		int randomindex = getRandomInt(min, max);
		
		randomcurrency = (String) stringlist.get(randomindex);
	}

	public void getNotes() {
		stringlistofnotes = (List<String>) jsonobject.get(randomcurrency);
	}

	public void convertNotesToInt() { 
		intlistofnotes = stringlistofnotes.stream()
				.map((string) -> Integer.parseInt(string)).collect(Collectors.toList());
	}

	public void display() {
		System.out.println("\nGenerating random currency...");
		System.out.println("Generated random currency is: " + randomcurrency);
		System.out.println("...and the notes are...\n" + intlistofnotes);
	}

	public void execute() {
		getJson(filename);
		getList();
		pickRandomCurrency();
		getNotes();
		convertNotesToInt();
		display();
	}
	
	@Override
	public String getCurrency() {
		execute();
		return randomcurrency;
	}

	@Override
	public List<Integer> getCurrencyNotes() {
		return intlistofnotes;
	}
}