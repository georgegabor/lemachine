package org.geo.changemachine.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class LogToFile implements ILogToFile{
	public void write(String username, int price, String currency, long time) {
		display();
		FileWriter fw;
		File file;
		String content = price + ", " + currency + ", ";
		content += NumberFormat.getNumberInstance(Locale.US).format(time) + " ms";
		
		try {
			file = new File(username + ".txt");
			fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void display() {
		System.out.println("\nWriting data to file...\nBye !");
	}
}
