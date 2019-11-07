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
public class StringsTest {

    private Strings strings = new Strings();

    @Test
    public void testGetLongestString() {
        String longString = "platitudinous";
        String shortString = "boring";
        String result = strings.getLongestString(longString, shortString);

        assertEquals(longString, result);
    }

    @Test
    public void testString1ContainsString2() {
        String reference = "platitudinous";
        String firstString = "tudi";
        String secondString = "nein";
        boolean correctResult = strings.string1ContainsString2(reference, firstString);
        boolean incorrectResult = strings.string1ContainsString2(reference, secondString);

        assertTrue(correctResult);
        assertFalse(incorrectResult);
    }

    @Test
    public void testGetLettersOnly() {
        String expectedResult = "platitudinous";
        String expectedResultCamelCase = "platitudinousCamelCase";
        String alphaNumeric = "p3lat44itudino123us";
        String alphaNumericCamelCase = "plat33itud1inous2323CamelCase";
        String result = strings.getLettersOnly(alphaNumeric);
        String resultCamelCase = strings.getLettersOnly(alphaNumericCamelCase);

        assertEquals(expectedResult, result);
        assertEquals(expectedResultCamelCase, resultCamelCase);
    }

    @Test
    public void testGetCharacterAtIndex() {
        char correctChar1= strings.getCharacterAtIndex("platitudinous", 3);
        assertEquals('t', correctChar1);

        char correctChar2 = strings.getCharacterAtIndex("platitudinous", 9);
        assertEquals('n', correctChar2);
    }

    @Test
    public void testDoesFirstStringEndWithSecondString() {
        String reference = "platitudinous";
        String firstString = "ous";
        String secondString = "tudi";
        boolean correctResult = strings.doesFirstStringEndWithSecondString(reference, firstString);
        boolean incorrectResult = strings.doesFirstStringEndWithSecondString(reference, secondString);

        assertTrue(correctResult);
        assertFalse(incorrectResult);
    }

    @Test
    public void testGetFirstAlphabeticalString() {
        String firstString = "platitudinous";
        String secondString = "Alphabetical";
        String result = strings.getFirstAlphabeticalString(firstString, secondString);

        assertEquals(secondString,result);
    }

    @Test
    public void replaceInstancesOfReferenceString() {
        String reference = "indeed";
        String string = "the earth is indeed flat";
        String replacementString = "not";
        String result = strings.replaceInstancesOfReferenceString(reference, string, replacementString);

        assertEquals("the earth is not flat",result);
    }
}