package com.stantonscott.javabasics.exercises;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;

public class IOStreams {

	/**
	 * crate a String array by splitting the given sting up when a comma is present
	 * @param commaSepareatedValues
	 * @return List of strings
	 */
	public List<String> splitCommaSepareatedValues(String commaSepareatedValues) {
		//code goes here
		return null;
	}
	
	/**
	 * create a List from the comma separated values of an InputStream
	 * @param inputStream
	 * @return List<String> of values from stream
	 * @throws IOException
	 */
	public List<String> readInputStream(InputStream inputStream) throws IOException {
		//code goes here	
		return null;
	}
	
	/**
	 * read comma separated values from a file
	 * @param destination of file
	 * @return String array of values from stream
	 * @throws IOException
	 */
	public String[] readFromFile(Path destination) throws IOException {
		//code goes here
		return null;
	}
	
	/**
	 * write the provided values to an output stream separated with a comma
	 *
	 * @param outputStream
	 * @param values
	 * @throws IOException
	 */	
	public void write(OutputStream outputStream, List<String> values) throws IOException {

	}
	
	/**
	 * write strings as comma separated values to a file
	 * @param values to write to file
	 * @param destination of file
	 */
	public void writeToFile(List<String> values, Path destination) {
		//code goes here
		return;
	}
}
