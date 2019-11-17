package com.stantonscott.javabasics.exercises;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IOStreamsTest {
	
	private IOStreams ioStreams;

	@Before
	public void prepareTest() {
		ioStreams = new IOStreams();
	}

	@Test
	public void testSplitCommaSepareatedValues() {
		String commaSepareatedValues =  "I,came,here,to,drink,milk,and,kick,ass,and,I've,just,finished,my,milk";
		List<String> strings = ioStreams.splitCommaSepareatedValues(commaSepareatedValues);
		
		assertTrue(strings.contains("I"));
		assertTrue(strings.contains("milk"));
		assertTrue(strings.contains("kick"));
		assertTrue(strings.contains("I've"));
		assertTrue(strings.contains("finished"));
		assertTrue(strings.size() == 14);
		assertFalse(strings.contains(","));
	}
	
	@Test
	public void testReadInputStream() throws IOException {
		byte[] data = "Will,you,watch,your,ruddy,language,my,ears,are,not,a,toilet".getBytes();
		InputStream inputStream = new ByteArrayInputStream(data);
		List<String> strings = ioStreams.readInputStream(inputStream);
		
		assertTrue(strings.contains("ruddy"));
		assertTrue(strings.contains("ears"));
		assertTrue(strings.contains("toilet"));
		assertTrue(strings.size() == 11);
		assertFalse(strings.contains(","));
	}
	
	/**
	 * read comma separated values from a file
	 * @param destination of file
	 * @return String array of values from stream
	 * @throws IOException
	 */
	public String[] testReadFromFile(Path destination) throws IOException {
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
	public void testWrite(OutputStream outputStream, List<String> values) throws IOException {

	}
	
	/**
	 * write strings as comma separated values to a file
	 * @param values to write to file
	 * @param destination of file
	 */
	public void testWriteToFile(List<String> values, Path destination) {
		//code goes here
		return;
	}
}
