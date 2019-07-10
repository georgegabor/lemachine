package org.geo.changemachine.calculate;

import java.util.ArrayList;
import java.util.List;

public class HowManyNotesToPayPrice implements ICalculate {
	
	private static int sumofnotes;
	private static int randomprice;
	private static long runtime;
	private static StringBuilder msg = new StringBuilder(); 	
	private static List<Integer> whichnote = new ArrayList<Integer>();
	private static List<Integer> amountofnote = new ArrayList<Integer>();
	private static List<Integer> intvalues;
	
/************** Methods ******************/	
	
	public void calculateNotes() {
		for (Integer intValue : intvalues) {
			int numofeachnotes = randomprice / intValue;
			randomprice = randomprice % intValue;
			if (numofeachnotes != 0) {
				sumofnotes += numofeachnotes;
				whichnote.add(intValue);
				amountofnote.add(numofeachnotes);
			}
		}
	}
    
	public void createMsg() {
		msg.append("The result is ")
		   .append(sumofnotes)
		   .append(" ---> ");
		
		for (int x = 0; x < whichnote.size(); x++) {
			msg.append(amountofnote.get(x))
			   .append("x ")
			   .append(whichnote.get(x))
			   .append(",");
		}
		
		msg.deleteCharAt(msg.length() - 1);
	}
	
	public void runCalculation() {
		long starttime = System.nanoTime();
		calculateNotes();
		long endtime = System.nanoTime();
		
		runtime = (endtime - starttime)/1000;
	}
	
	public void display() {
		System.out.println("\nCalculating...\n");
	}

	@Override
	public long execute(int price, List<Integer> notesList) {
		randomprice = price;
		intvalues = notesList;
		display();
		runCalculation();
		createMsg();
		System.out.println(msg);
		
		return runtime;
	}

	public int getSumOfNotes() {
		return sumofnotes;
	}
	
	public List<Integer> getAmountOfNote(){
		return amountofnote;
	}
	
	public List<Integer> getWhichNote(){
		return whichnote;
	}
	
	public StringBuilder getMsg() {
		return msg;
	}
}