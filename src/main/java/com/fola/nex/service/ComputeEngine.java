package com.fola.nex.service;

import java.io.IOException;
import java.util.List;

import com.fola.nex.io.NexFileReader;

public interface ComputeEngine {

	static void compute(String filepath) throws IOException {
		List<String> lines = new NexFileReader().readLinesFromFile(filepath);
		PrimeGenerator primeGenerator = new PrimeGeneratorImpl();
		lines.forEach(arg -> {
			try {
				Integer val = Integer.valueOf(arg);
				if (val < 0) {
					System.out.print("(-): ");
				}
				List<Integer> results = primeGenerator.getPrimeFactors(Math.abs(val));
				System.out.println(results.toString());
			} catch (NumberFormatException e) {
				System.out.println("Invalid number: " + arg);
			}
		});
	}

}
