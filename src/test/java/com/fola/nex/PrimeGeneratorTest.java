package com.fola.nex;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fola.nex.service.PrimeGenerator;
import com.fola.nex.service.PrimeGeneratorImpl;

public class PrimeGeneratorTest {

	PrimeGenerator systemUnderTest;

	@BeforeMethod
	public void setup() {
		systemUnderTest = new PrimeGeneratorImpl();
	}

	// int number, List<Integer> expectedResult
	// list of the integer's prime factors.
	// @Test(dataProvider = "getLists")
	@Test
	public void test_get_prime_factors_with_2_different_primes() {
		int number = 51;
		List<Integer> expectedResult = new ArrayList<>();
		expectedResult.add(3);
		expectedResult.add(17);

		List<Integer> actualResult = systemUnderTest.getPrimeFactors(number);

		assertEquals(actualResult.size(), expectedResult.size());
		assertTrue(actualResult.stream().anyMatch(item -> expectedResult.contains(item)));
	}

	@Test
	public void test_get_prime_factors_with_3_same_repeated_primes() {
		int number = 27;
		List<Integer> expectedResult = new ArrayList<>();
		expectedResult.add(3);
		expectedResult.add(3);
		expectedResult.add(3);

		List<Integer> actualResult = systemUnderTest.getPrimeFactors(number);

		assertEquals(actualResult.size(), expectedResult.size());
		assertTrue(actualResult.stream().anyMatch(item -> expectedResult.contains(item)));
	}

	@Test
	public void test_get_prime_factors_with_1_prime() {
		int number = 43;
		List<Integer> expectedResult = new ArrayList<>();
		expectedResult.add(43);

		List<Integer> actualResult = systemUnderTest.getPrimeFactors(number);

		assertEquals(actualResult.size(), expectedResult.size());
		assertTrue(actualResult.stream().anyMatch(item -> expectedResult.contains(item)));
	}
	
	@Test
	public void test_get_prime_factors_with_same_repeated_primes_and_other_prime() {
		int number = 90;
		List<Integer> expectedResult = new ArrayList<>();
		expectedResult.add(2);
		expectedResult.add(3);
		expectedResult.add(3);
		expectedResult.add(5);

		List<Integer> actualResult = systemUnderTest.getPrimeFactors(number);

		assertEquals(actualResult.size(), expectedResult.size());
		assertTrue(actualResult.stream().anyMatch(item -> expectedResult.contains(item)));
	}
	
	@Test
	public void test_get_prime_factors_with_zero() {
		int number = 0;
		List<Integer> expectedResult = new ArrayList<>();

		List<Integer> actualResult = systemUnderTest.getPrimeFactors(number);

		assertEquals(actualResult.size(), expectedResult.size());
	}

	@DataProvider
	private static final Object[][] getLists() {

		// => 51 -> 3 * 17;
		List<Integer> list51 = new ArrayList<>();
		list51.add(new Integer("3"));
		list51.add(new Integer("17"));

		// => 27 -> 3 * 3 * 3
		List<Integer> list27 = new ArrayList<>();
		list27.add(new Integer("3"));
		list27.add(new Integer("3"));
		list27.add(new Integer("3"));

		return new Object[][] { { 51, list51 }, { 27, list27 } };
	}

}
