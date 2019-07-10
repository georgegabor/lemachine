/**
 * @author geo
 */

package org.geo.changemachine;

public class RoundCurrency {
	public static int checkIfRoundingIsNeeded(String currency, int price) {
		if(currency.equals("HUF") && (price % 5 != 0)) {
			price = roundingHUF(price);
		}
		return price;
	}
	
	public static int roundingHUF(int number) {
		int remainder = number % 10;

		switch (remainder) {
			case 3:
			case 8:
				number += 2;
				break;
			case 4:
			case 9:
				number += 1;
				break;
		}
		return number;
	}
}
