package org.geo.changemachine;

import java.util.List;

import org.geo.changemachine.calculate.ICalculate;
import org.geo.changemachine.log.ILogToFile;
import org.geo.changemachine.random.IRandomCurrency;
import org.geo.changemachine.random.IRandomInt;
import org.geo.changemachine.user.IUsername;

public class ChangeMachine {
	private IUsername getUsername;
	private IRandomInt randomInt;
	private IRandomCurrency randomCurrency;
	private ICalculate doCalculation;
	private ILogToFile logToFile;
	
	private String username;
	private int randomprice;
	private String currency;
	private List<Integer> noteslist;
	private long time;
	
	public ChangeMachine() {}
	
	public ChangeMachine(IUsername uname, IRandomInt ri, IRandomCurrency rc, ICalculate cal, ILogToFile ltf) {
		this.getUsername = uname;
		this.randomInt = ri;
		this.randomCurrency = rc;
		this.doCalculation = cal;
		this.logToFile = ltf;
	}
	
	/************* Methods ***********/
	
	public void getUsernameFromUser() {
		username = getUsername.getUsername();
	}
	
	public void getRandomPrice() {
		randomprice = randomInt.getRandomInt(); 
	}
	
	public void getCurrency() {
		currency = randomCurrency.getCurrency();
	}
	
	public void getCurrencyNotes() {
		noteslist = randomCurrency.getCurrencyNotes();
	}
	
	public void checkRounding() {
		randomprice = RoundCurrency.checkIfRoundingIsNeeded(currency, randomprice);
	}
	
	public void calculate() {
		time = doCalculation.execute(randomprice, noteslist);
	}
		
 	public void log() {	
 		logToFile.write(username, randomprice, currency, time);
	}
	
	public void run() {
		getUsernameFromUser();
		getRandomPrice();
		getCurrency();
		getCurrencyNotes();
		checkRounding();
		calculate();
		log();
	}
}
