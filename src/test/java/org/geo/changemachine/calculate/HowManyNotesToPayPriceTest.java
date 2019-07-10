package org.geo.changemachine.calculate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class HowManyNotesToPayPriceTest {

	@Test
	public void test() {
		HowManyNotesToPayPrice calculateAmount = new HowManyNotesToPayPrice();
		int expectedsumofnotes = 4;
		int randomprice = 125;

		StringBuilder expectedMsg = new StringBuilder();
		expectedMsg.append("result is 4 ---> 2x 50,1x 20,1x 5");
		
		List<Integer> expectedWhichNote = new ArrayList<Integer>();
		expectedWhichNote.add(50);
		expectedWhichNote.add(20);
		expectedWhichNote.add(5);
		
		List<Integer> expectedAmountOfNote = new ArrayList<Integer>();
		expectedAmountOfNote.add(2);
		expectedAmountOfNote.add(1);
		expectedAmountOfNote.add(1);
		
		List<Integer> intValues = new ArrayList<Integer>();
		intValues.add(50);
		intValues.add(20);
		intValues.add(10);
		intValues.add(5);
		
		calculateAmount.execute(randomprice, intValues);
		Assert.assertEquals(expectedsumofnotes, calculateAmount.getSumOfNotes());
		Assert.assertEquals(expectedAmountOfNote, calculateAmount.getAmountOfNote());
		Assert.assertEquals(expectedWhichNote, calculateAmount.getWhichNote());

		calculateAmount.createMsg();
		Assert.assertEquals(expectedMsg, calculateAmount.getMsg());	}

}
