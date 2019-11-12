package com.stantonscott.javabasics.exercises;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class NumbersTest {
	
	Numbers numbers = new Numbers();

	@Test
	public void addition() {
		int expecting10 = numbers.addition(5, 5, 0);
		int expecting11 = numbers.addition(16, -32, 5);
		int expecting88 = numbers.addition(62, 19, 7);
		
		assertEquals(expecting10, 10);
		assertEquals(expecting11, -11);
		assertEquals(expecting88, 88);
	}
	
	@Test
	public void addOnlyPositiveNumbers() {
		int expecting10 = numbers.addOnlyPositiveNumbers(5, 5, 0);
		int expecting21 = numbers.addOnlyPositiveNumbers(16, -32, 5);
		int expecting62 = numbers.addOnlyPositiveNumbers(62, -19, -7);
		
		assertEquals(expecting10, 10);
		assertEquals(expecting21, 21);
		assertEquals(expecting62, 62);
	}
	
	@Test
	public void subtraction() {
		int expecting0 = numbers.subtraction(5, 5);
		int expecting21 = numbers.subtraction(28, 7);
		int expecting10 = numbers.subtraction(5, -5);
		
		assertEquals(expecting0, 0);
		assertEquals(expecting21, 21);
		assertEquals(expecting10, 10);
		
	}
	
	@Test
	public void multiplication() {
		int expecting25 = numbers.multiplication(5, 5);
		int expecting0 = numbers.multiplication(28, 0);
		int expectingNegative25 = numbers.multiplication(5, -5);
		
		assertEquals(expecting25, 25);
		assertEquals(expecting0, 0);
		assertEquals(expectingNegative25, -25);
	}
	
	@Test
	public void division() {
		int expecting50 = numbers.division(100, 2);
		int expectingNegative20 = numbers.division(100, -5);
		int expecting10 = numbers.division(10, 1);
		
		assertEquals(expecting50, 50);
		assertEquals(expectingNegative20, -20);
		assertEquals(expecting10, 10);
	}
	
	@Test
	public void evenNumbers() {
		boolean expectingTrue = numbers.evenNumbers(8);
		boolean expectingFalse = numbers.evenNumbers(7);
		
		assertTrue(expectingTrue);
		assertFalse(expectingFalse);
	}
}
