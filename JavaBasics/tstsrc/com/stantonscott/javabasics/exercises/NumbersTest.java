package com.stantonscott.javabasics.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class NumbersTest {

	private Numbers numbers;

	@Before
	public void setupTests() {
		numbers = new Numbers();
	}

	@Test
	public void addition() {
		int expecting10 = numbers.addition(5, 5, 0);
		int expectingNegative11 = numbers.addition(16, -32, 5);
		int expecting88 = numbers.addition(62, 19, 7);

		assertEquals(10, expecting10);
		assertEquals(-11, expectingNegative11);
		assertEquals(88, expecting88);
	}

	@Test
	public void addOnlyPositiveNumbers() {
		int expecting10 = numbers.addOnlyPositiveNumbers(5, 5, 0);
		int expecting21 = numbers.addOnlyPositiveNumbers(16, -32, 5);
		int expecting62 = numbers.addOnlyPositiveNumbers(62, -19, -7);

		assertEquals(10, expecting10);
		assertEquals(21, expecting21);
		assertEquals(62, expecting62);
	}

	@Test
	public void subtraction() {
		int expecting0 = numbers.subtraction(5, 5);
		int expecting21 = numbers.subtraction(28, 7);
		int expecting10 = numbers.subtraction(5, -5);

		assertEquals(0, expecting0);
		assertEquals(21, expecting21);
		assertEquals(10, expecting10);

	}

	@Test
	public void multiplication() {
		int expecting25 = numbers.multiplication(5, 5);
		int expecting0 = numbers.multiplication(28, 0);
		int expectingNegative25 = numbers.multiplication(5, -5);

		assertEquals(25, expecting25);
		assertEquals(0, expecting0);
		assertEquals(-25, expectingNegative25);
	}

	@Test
	public void division() {
		int expecting50 = numbers.division(100, 2);
		int expectingNegative20 = numbers.division(100, -5);
		int expecting10 = numbers.division(10, 1);

		assertEquals(50, expecting50);
		assertEquals(-20, expectingNegative20);
		assertEquals(10, expecting10);
	}

	@Test
	public void evenNumbers() {
		boolean expectingTrue = numbers.evenNumbers(8);
		boolean expectingFalse = numbers.evenNumbers(7);

		assertTrue(expectingTrue);
		assertFalse(expectingFalse);
	}
}
