package com.fola.nex.io;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;

@Test
public class NexFileReaderTest {
	String filePath = "tasks.txt";
	NexFileReader systemUnderTest;

	@BeforeMethod
	public void beforeMethod() {
		systemUnderTest = new NexFileReader();
	}

	public void readLinesFromFile_should_succeed_when_for_valid_file() throws IOException {
		String line1 = "Write a console application in Java:";
		String line7 = "* If you think of any other questions, make an assumption and document it in your code.";
		
		List<String> actual = systemUnderTest.readLinesFromFile(filePath);

		assertNotNull(actual);
		assertEquals(actual.size(), 7);
		assertEquals(actual.get(0), line1);
		assertEquals(actual.get(6), line7);
	}
	
	@Test(expectedExceptions = IOException.class)
	public void readLinesFromFile_should_throw_io_exception() throws IOException {
		
		systemUnderTest.readLinesFromFile("c:/tmp/invalid/path/no file .exe");

	}
	
}
