package com.stantonscott.javabasics.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class Strings {

    /**
     * Get the string that is the longest
     *
     * @param string1
     * @param string2
     * @return longest of two strings
     */
    public String getLongestString(String string1, String string2) {


        if (string1.length() > string2.length()) {
            return string1;
        } else if (string1.length() < string2.length()) {
            return string2;
        } else
            return "Equal length";
    }

    /**
     * Check if a string contains another string
     *
     * @param string1 reference string
     * @param string2 string to check
     * @return true if string1 contains string2
     */
    public boolean string1ContainsString2(String string1, String string2) {
        if (string1.contains(string2)) {
            return true;
        } else
            return false;
    }

    /**
     * Get only letters contained in the string (no numbers)
     *
     * @param string1 string containing letters and numbers
     * @return string containing only letters
     */
    public String getLettersOnly(String string1) {

        return string1.replaceAll("\\d", "");
    }

    /**
     * Get the character from the given string at the index supplied
     *
     * @param string
     * @param index
     * @return character at index
     */
    public char getCharacterAtIndex(String string, int index) {
        char[] chars = string.toCharArray();

        return chars[index];
    }

    /**
     * Check if a supplied string ends with the letters of another string
     *
     * @param string1 reference string
     * @param string2 string to check
     * @return true if reference string ends with string to check
     */
    public boolean doesFirstStringEndWithSecondString(String string1, String string2) {

        if (string1.endsWith(string2)) {
            return true;
        } else return false;
    }

    /**
     * Get first string in alphabetical order
     *
     * @param string1
     * @param string2
     * @return first alphabetically ordered string
     */
    public String getFirstAlphabeticalString(String string1, String string2) {
        List list = new ArrayList();
        list.add(string1);
        list.add(string2);
        Collections.sort(list);
        return (String) list.get(0);
    }

    /**
     * if the supplied String has instances of the reference replace the instance with the replacement
     *
     * @param reference         string to check for
     * @param string            string to check
     * @param replacementString string to replace reference with
     * @return string with reference replaced by replacementString
     */
    public String replaceInstancesOfReferenceString(String reference, String string, String replacementString) {

        if (string.contains(reference))
            return string.replace(reference, replacementString);
        else
            return null;
    }
}
