package org.geo.changemachine.random;

import java.util.Random;

public class PickRandomInt implements IRandomInt{
	private int min = 0;
	private int max = 100000;
	private int generatedrandomprice;
	
	public PickRandomInt() {}
	
	public PickRandomInt(int rangeMin,int rangeMax) {
		this.min = rangeMin;
		this.max = rangeMax;
	}
	
	/************** Methods ******************/

	@Override
	public int getRandomInt() {
		generatedrandomprice = getRandomInt(min, max);
		display();
		return generatedrandomprice;
	}
	
	public int getRandomInt(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}
	
	public void display() {
		System.out.println("\nGenerating random price...");
		System.out.println("Price is: " + generatedrandomprice);
	}
	
	/************** Getters & Setters ******************/

	public int getRangeMin() {
		return min;
	}
	
	public void setRangeMin(int rangeMin) {
		this.min = rangeMin;
	}
	
	public int getRangeMax() {
		return max;
	}
	
	public void setRangeMax(int rangeMax) {
		this.max = rangeMax;
	}
	
}
