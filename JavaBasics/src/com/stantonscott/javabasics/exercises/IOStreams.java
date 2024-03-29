package com.stantonscott.javabasics.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

/**
 * @author stantonscott
 * @version 1.0
 * 
 * <p>Creation Date: 01.11.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class IOStreams {

	/**
	 * crate a String array by splitting the given sting up when a comma is present
	 * 
	 * @param commaSepareatedValues
	 * @return List of strings
	 */
	public List<String> splitCommaSepareatedValues(String commaSepareatedValues) {
		// code goes here
		return null;
	}

	/**
	 * create a List from the comma separated values of an InputStream
	 * 
	 * @param inputStream
	 * @return List<String> of values from stream
	 * @throws IOException
	 */
	public List<String> readInputStream(InputStream inputStream) throws IOException {
		// code goes here
		return null;
	}

	/**
	 * read comma separated values from a file
	 * 
	 * @param destination
	 *            of file
	 * @return String array of values from stream
	 * @throws IOException
	 */
	public String[] readFromFile(Path destination) throws IOException {
		// code goes here
		return null;
	}

	/**
	 * write strings as comma separated values to a file
	 * 
	 * @param values
	 *            to write to file
	 * @param destination
	 *            of file
	 */
	public void writeToFile(List<String> values, Path destination) throws IOException {
		// code goes here
	}
}
