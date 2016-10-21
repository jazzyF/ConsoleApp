package com.fola.nex;

import java.io.IOException;

import com.fola.nex.service.ComputeEngine;

public class App {
	public static void main(String[] args) {

		String filepath = "fileOfInts.txt";
		if (args.length > 0) {
			filepath = args[0];
		} else {
			System.out.println("Invalid usage: Please specify name of files to be scanned");
			System.exit(0);
		}
		
		try {
			ComputeEngine.compute(filepath);
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
