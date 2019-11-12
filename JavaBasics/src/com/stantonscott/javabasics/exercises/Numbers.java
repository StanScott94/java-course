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
     *
     * @param firstInt
     * @param SecondInt
     * @param thirdInt
     * @return sum of all parameters
     */
    public int addition(int firstInt, int SecondInt, int thirdInt) {

        int[] ints = new int[3];
        ints[0] = firstInt;
        ints[1] = SecondInt;
        ints[2] = thirdInt;

        int zero = 0;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                zero += ints[i];
            } else zero -= ints[i];
        }


        return zero;
    }

    /**
     * Get the sum of all positive parameters
     *
     * @param firstInt
     * @param SecondInt
     * @param thirdInt
     * @return sum of all positive parameters
     */
    public int addOnlyPositiveNumbers(int firstInt, int SecondInt, int thirdInt) {
        int[] ints = new int[3];
        ints[0] = firstInt;
        ints[1] = SecondInt;
        ints[2] = thirdInt;
        int zero = 0;

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                zero += ints[i];
            }
        }

        return zero;
    }

    /**
     * Get the sum after subtraction
     *
     * @param numberToSubtractFrom
     * @param numberToSubtract
     * @return sum after subtraction
     */
    public int subtraction(int numberToSubtractFrom, int numberToSubtract) {
        //code goes here
        return numberToSubtractFrom - numberToSubtract;
    }

    /**
     * Get the sum after multiplication
     *
     * @param firstInt
     * @param SecondInt
     * @return sum after multiplication
     */
    public int multiplication(int firstInt, int SecondInt) {
        //code goes here
        return firstInt * SecondInt;
    }

    /**
     * Get the sum after division
     *
     * @param numberToDivide
     * @param numberToDivideBy
     * @return sum after division
     */
    public int division(int numberToDivide, int numberToDivideBy) {
        //code goes here
        return numberToDivide / numberToDivideBy;
    }

    /**
     * Check if number is even
     *
     * @param firstInt
     * @return even number
     */
    public boolean evenNumbers(int firstInt) {
        if (firstInt % 2 == 0)
            return true;
        else return false;
    }
}
