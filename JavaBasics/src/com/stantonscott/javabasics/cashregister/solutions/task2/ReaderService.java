package com.stantonscott.javabasics.cashregister.solutions.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 11.11.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class ReaderService implements Callable<String[]> {

	private String filePath;

	public ReaderService(String filePath) {
		this.filePath = filePath;
	}

	public String[] call() throws IOException {
		return getCommaSeparatedValuesFromConfigFile();
	}

	public String[] getCommaSeparatedValuesFromConfigFile() throws IOException {
		String logTime = new SimpleDateFormat("mm:ss.SSS").format(new Date());
		System.out.println("retrieving values from " + filePath + " " + logTime);
		try (BufferedReader buffer = Files.newBufferedReader(Paths.get(filePath))) {
			return (buffer.lines().collect(Collectors.joining("\n"))).split(",");
		}
	}
}
