package com.fola.nex.service;

import java.util.ArrayList;
import java.util.List;

public class PrimeGeneratorImpl implements PrimeGenerator {

	@Override
	public List<Integer> getPrimeFactors(int number) {
		List<Integer> result = new ArrayList<>();
		for (int i = 2; i <= number; i++) {
			while (number % i == 0) {
				result.add(i);
				number /= i;
			}
		}
		return result;
	}

}
