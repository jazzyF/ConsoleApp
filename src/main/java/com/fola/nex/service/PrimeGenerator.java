package com.fola.nex.service;

import java.util.List;

public interface PrimeGenerator {

	/**
	 * Only numbers greater than or equal to zero are valid input
	 * 
	 * @param number
	 * @return List of prime factors which when multiplied together gives the number.
	 */
	List<Integer> getPrimeFactors(int number);
	
}
