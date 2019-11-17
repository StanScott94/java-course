package com.stantonscott.javabasics.exercises;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class Numbers {

    /**
     * Get the sum of all parameters
     * @param firstInt
     * @param SecondInt
     * @param thirdInt
     * @return sum of all parameters
     */
	public int addition(int firstInt, int SecondInt, int thirdInt) {
		return firstInt + SecondInt + thirdInt;
	}
	
    /**
     * Get the sum of all positive parameters
     * @param firstInt
     * @param SecondInt
     * @param thirdInt
     * @return sum of all positive parameters
     */
	public int addOnlyPositiveNumbers(int firstInt, int SecondInt, int thirdInt) {
		int sum = 0;
		sum = firstInt >= 0 ? sum + firstInt : sum;
		sum = SecondInt >= 0 ? sum + SecondInt : sum;
		sum = thirdInt >= 0 ? sum + thirdInt : sum;
		return sum;
	}
	
    /**
     * Get the sum after subtraction
     * @param numberToSubtractFrom
     * @param numberToSubtract
     * @return sum after subtraction
     */
	public int subtraction(int numberToSubtractFrom, int numberToSubtract) {
		return numberToSubtractFrom - numberToSubtract;
	}
	
    /**
     * Get the sum after multiplication
     * @param firstInt
     * @param SecondInt
     * @return sum after multiplication
     */
	public int multiplication(int firstInt, int SecondInt) {
		return firstInt * SecondInt;
	}
	
    /**
     * Get the sum after division
     * @param numberToDivide
     * @param numberToDivideBy
     * @return sum after division
     */
	public int division(int numberToDivide, int numberToDivideBy) {
		return numberToDivide / numberToDivideBy;
	}
	
    /**
     * Check if number is even
     * @param firstInt
     * @return even number
     */
	public boolean evenNumbers(int firstInt) {
		return firstInt % 2 == 0;
	}
}