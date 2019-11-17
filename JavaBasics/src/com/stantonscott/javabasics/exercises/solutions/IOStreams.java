package com.stantonscott.javabasics.exercises.solutions;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOStreams {

	/**
	 * crate a String array by splitting the given sting up when a comma is present
	 * 
	 * @param commaSepareatedValues
	 * @return List of strings
	 */
	public List<String> splitCommaSepareatedValues(String commaSepareatedValues) {
		return Arrays.asList(commaSepareatedValues.split(","));
	}

	/**
	 * create a List from the comma separated values of an InputStream
	 * 
	 * @param inputStream
	 * @return List<String> of values from stream
	 * @throws IOException
	 */
	public List<String> readInputStream(InputStream inputStream) throws IOException {
		int sizeOfStream = inputStream.available();
		byte[] bytes = new byte[sizeOfStream];
		inputStream.read(bytes, 0, sizeOfStream);
		return Arrays.asList(new String(bytes, StandardCharsets.UTF_8).split(","));
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
		try (BufferedReader buffer = Files.newBufferedReader(destination)) {
			return (buffer.lines().collect(Collectors.joining("\n"))).split(",");
		}
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
		try (FileWriter writer = new FileWriter(destination.toString())) {
			for (String value : values) {
				writer.write(value.trim() + ",");
			}
		};
	}
}