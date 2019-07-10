package org.geo.changemachine;

import org.geo.changemachine.calculate.HowManyNotesToPayPrice;
import org.geo.changemachine.log.LogToFile;
import org.geo.changemachine.random.PickRandomCurrency;
import org.geo.changemachine.random.PickRandomInt;
import org.geo.changemachine.user.GetUsername;

public class App 
{
    public static void main( String[] args ){
    	
    	// Default is asking for username
    	GetUsername getUsername = new GetUsername("Rézfánfütyülőrézangyalát"); 
    	// Default min=0, max=100000;
    	PickRandomInt pickRandomInt = new PickRandomInt(0, 1000); 		
    	// Default is currency1.json
    	PickRandomCurrency pickRandomCurrency = new PickRandomCurrency("currency2.json"); 
    	HowManyNotesToPayPrice calculate = new HowManyNotesToPayPrice();
    	LogToFile logToFile = new LogToFile();
    	
    	ChangeMachine changeMachine2 = new ChangeMachine(getUsername, pickRandomInt, pickRandomCurrency, 
    													calculate, logToFile);
    	
    	changeMachine2.run();
    }
}
