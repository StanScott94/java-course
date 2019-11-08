package com.stantonscott.javabasics.exercises;

/**
 * @author stantonscott
 * @version 1.0
 *
 *          <p>
 *          Creation Date: 29.10.19
 *          </p>
 *          <p>
 *          Project Name: JavaBasics
 *          </p>
 */
public class Strings {

	/**
	 * Get the string that is the longest
	 * 
	 * @param string1
	 * @param string2
	 * @return longest of two strings
	 */
	public String getLongestString(final String string1, final String string2) {
		return (string1.length() < string2.length()) ? string2 : string1;
	}

	/**
	 * Check if a string contains another string
	 * 
	 * @param string1 reference string
	 * @param string2 string to check
	 * @return true if string1 contains string2
	 */
	public boolean string1ContainsString2(final String string1, final String string2) {
		return string1.contains(string2) ? true : false;
	}

	/**
	 * Get only letters contained in the string (no numbers)
	 * 
	 * @param string1 string containing letters and numbers
	 * @return string containing only letters
	 */
	public String getLettersOnly(final String string1) {
		return string1.chars().
				filter((asciiCode) -> isLetter(asciiCode)).
				mapToObj((code)->Character.toString((char)code))
				.reduce("", (a,b)->a+b);
	}

	private boolean isLetter(final int asciiCode) {
		return isUppercaseLetter(asciiCode) || isLowercaseLetter(asciiCode) ? true : false;
	}

	private boolean isLowercaseLetter(final int asciiCode) {
		return asciiCode >= 97 && asciiCode <= 122;
	}

	private boolean isUppercaseLetter(final int asciiCode) {
		return asciiCode >= 65 && asciiCode <= 90;
	}

	/**
	 * Get the character from the given string at the index supplied
	 * 
	 * @param string
	 * @param index
	 * @return character at index
	 */
	public char getCharacterAtIndex(final String string, final int index) {
		return string.charAt(index);
	}

	/**
	 * Check if a supplied string ends with the letters of another string
	 * 
	 * @param string1 reference string
	 * @param string2 string to check
	 * @return true if reference string ends with string to check
	 */
	public boolean doesFirstStringEndWithSecondString(final String string1, final String string2) {
		return string1.endsWith(string2);
	}

	/**
	 * Get first string in alphabetical order
	 * 
	 * @param string1
	 * @param string2
	 * @return first alphabetically ordered string
	 */
	public String getFirstAlphabeticalString(final String string1, final String string2) {
		return helper(string1, string2, 0);
	}

	private String helper(final String string1, final String string2, final int index) {
		if (string1.toLowerCase().charAt(index) < string2.toLowerCase().charAt(index)) {
			return string1;
		} else if (string1.toLowerCase().charAt(index) == string2.toLowerCase().charAt(index)) {
			return helper(string1, string2, index + 1);
		} else {
			return string2;
		}
	}

	/**
	 * if the supplied String has instances of the reference replace the instance
	 * with the replacement
	 * 
	 * @param reference         string to check for
	 * @param string            string to check
	 * @param replacementString string to replace reference with
	 * @return string with reference replaced by replacementString
	 */
	public String replaceInstancesOfReferenceString(String reference, String string, String replacementString) {
		return string.replaceAll(reference, replacementString);
	}
}
