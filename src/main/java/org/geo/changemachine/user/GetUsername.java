package org.geo.changemachine.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetUsername implements IUsername{
	private String username;
	private String prompt = "May i have your name please ?\n";
	
	public GetUsername() {
		username = null;
	}
	
	public GetUsername(String name) {
		this.username = name;
	}
	
/************** Methods ******************/
	
	public void getUsernameFromUser(String prompt) {
		System.out.print(prompt);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			username = br.readLine();
			if (username.isEmpty()) {
				System.out.println("Username cannot be empty !!!");
				getUsernameFromUser(prompt);
			}
		} catch (IOException e) {
			System.out.println("Error trying to read your name!");
			System.exit(1);
		}
		setUsername(username);
	}
	
	public void execute() {
		if(username == null) {
			getUsernameFromUser(prompt);
		}
		System.out.println("\nHello " + username);
	}

/************** Getters & Setters ******************/
	
	public String getUsername() {
		execute();
		return username;
	}
	
	public void setUsername(String name) {
		this.username = name;
	}
	
	public String getPrompt() {
		return prompt;
	}
	
	public void setPrompt(String p) {
		this.prompt = p;
	}
	
}
