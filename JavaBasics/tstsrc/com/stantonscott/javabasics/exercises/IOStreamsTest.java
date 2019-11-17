package com.stantonscott.javabasics.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class IOStreamsTest {

	private IOStreams ioStreams;

	@Before
	public void setupTests() {
		ioStreams = new IOStreams();
	}

	@Test
	public void testSplitCommaSepareatedValues() {
		String commaSepareatedValues = "I,came,here,to,drink,milk,and,kick,ass,and,I've,just,finished,my,milk";
		List<String> strings = ioStreams.splitCommaSepareatedValues(commaSepareatedValues);

		assertTrue(strings.contains("I"));
		assertTrue(strings.contains("milk"));
		assertTrue(strings.contains("kick"));
		assertTrue(strings.contains("I've"));
		assertTrue(strings.contains("finished"));
		assertTrue(strings.size() == 15);
		assertFalse(strings.contains(","));
	}

	@Test
	public void testReadInputStream() throws IOException {
		byte[] stringBytes = "Will,you,watch,your,ruddy,language,my,ears,are,not,a,toilet".getBytes();
		InputStream inputStream = new ByteArrayInputStream(stringBytes);
		List<String> strings = ioStreams.readInputStream(inputStream);

		assertTrue(strings.contains("ruddy"));
		assertTrue(strings.contains("ears"));
		assertTrue(strings.contains("toilet"));
		assertTrue(strings.size() == 12);
		assertFalse(strings.contains(","));
	}
	
	@Test
	public void testReadFromFile() throws IOException {
		Path path = Paths.get("JavaBasics/configfiles/InputOutputExercises/csv1.txt");
		String[] strings = ioStreams.readFromFile(path);
		
		assertEquals(strings[2], "type");
		assertEquals(strings[5], "Google");
		assertEquals(strings[10], "internet");
		assertTrue(strings.length == 11);
	}
	
	@Test
	public void testWriteToFile() throws IOException {
		String string = "The men involved are young angry and almost all of them work with computers";
		String expected = "The,men,involved,are,young,angry,and,almost,all,of,them,work,with,computers,";
		Path destination = Paths.get("JavaBasics/configfiles/InputOutputExercises/empty.txt");
        List<String> values = new ArrayList<>(Arrays.asList(string.split(" ")));

        try (PrintWriter writer = new PrintWriter(destination.toString())) {
        	writer.print("");
        }
        
        ioStreams.writeToFile(values, destination);
        String result;
		try (BufferedReader buffer = Files.newBufferedReader(destination)) {
			result = (buffer.lines().collect(Collectors.joining("\n")));
		}

		assertEquals(expected, result);
	}
}
