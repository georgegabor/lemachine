package org.geo.changemachine;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoundCurrencyTest {

	@Test
	public void test() {
		int returnedNumber1 = RoundCurrency.roundingHUF(3);
		int returnedNumber2 = RoundCurrency.roundingHUF(4);
		int returnedNumber3 = RoundCurrency.roundingHUF(8);
		int returnedNumber4 = RoundCurrency.roundingHUF(9);
		
		assertTrue(returnedNumber1 == 5);
		assertTrue(returnedNumber2 == 5);
		assertTrue(returnedNumber3 == 10);
		assertTrue(returnedNumber4 == 10);	
	}

}
