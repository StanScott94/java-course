package com.stantonscott.javabasics.exercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class CollectionsTest {
	
	Collections collections;
	
	@Before
	public void setupTests() {
		collections = new Collections();
	}
	
	@Test
	public void testCreateStringArray() {
		String string1 = "java";
		String string2 = "spring";
		String string3 = "JDBC";
		String string4 = "JPA";
		String[] result = collections.createStringArray(string1, string2, string3, string4);
		
		assertEquals(result[0], string1);
		assertEquals(result[1], string2);
		assertEquals(result[2], string3);
		assertEquals(result[3], string4);
	}
	
	@Test
	public void testCreateIntArray() {
		int int1 = 42;
		int int2 = 13;
		int int3 = 999;
		int int4 = 911;
		int[] result = collections.createIntArray(int1, int2, int3, int4);
		
		assertEquals(result[0], int1);
		assertEquals(result[1], int2);
		assertEquals(result[2], int3);
		assertEquals(result[3], int4);
	}
	
	@Test
	public void testCreateArrayListOfStrings() {
		String string1 = "java";
		String string2 = "spring";
		String string3 = "JDBC";
		String string4 = "JPA";
		List<String> result = collections.createArrayListOfStrings(string1, string2, string3, string4);
	
		assertEquals(result.get(0), string1);
		assertEquals(result.get(1), string2);
		assertEquals(result.get(2), string3);
		assertEquals(result.get(3), string4);
	}
	
	@Test
	public void testCreateMap() {
		String key1 = "java";
		String key2 = "spring";
		String key3 = "JDBC";
		Integer value1 = 42;
		Integer value2 = 13;
		Integer value3 = 999;
		Map<String, Integer> result = collections.createMap(key1, key2, key3, value1, value2, value3);
	
		assertEquals(result.get(key1), value1);
		assertEquals(result.get(key2), value2);
		assertEquals(result.get(key3), value3);
	}
	
	@Test
	public void testFindAndReplace() {
		String key1 = "java";
		String key2 = "spring";
		String key3 = "JDBC";
		Integer newValue = 0;
		Integer value1 = 42;
		Integer value2 = 13;
		Integer value3 = 999;
		
		Map<String, Integer> map = new HashMap<>();
		map.put(key1, value1);
		map.put(key2, value2);
		map.put(key3, value3);
		
		Map<String, Integer> result = collections.findAndReplace(map, key3, newValue);
	
		assertEquals(result.get(key1), value1);
		assertEquals(result.get(key2), value2);
		assertEquals(result.get(key3), newValue);
	}
	
	@Test
	public void testRemoveEntry() {
		String key1 = "java";
		String key2 = "spring";
		String key3 = "JDBC";
		Integer value1 = 42;
		Integer value2 = 13;
		Integer value3 = 999;
		
		Map<String, Integer> map = new HashMap<>();
		map.put(key1, value1);
		map.put(key2, value2);
		map.put(key3, value3);
		
		Map<String, Integer> result = collections.removeEntry(map, key2);
		
		assertFalse(result.containsKey(key2));
	}
	
	@Test
	public void testFindKeyAndRemoveEntry() {
		String key1 = "java";
		String key2 = "spring";
		String key3 = "JDBC";
		String stringToFind ="D";
		Integer value1 = 42;
		Integer value2 = 13;
		Integer value3 = 999;
		
		Map<String, Integer> map = new HashMap<>();
		map.put(key1, value1);
		map.put(key2, value2);
		map.put(key3, value3);
		
		Map<String, Integer> result = collections.findKeyAndRemoveEntry(map, stringToFind);
		
		assertFalse(result.containsKey(key3));
	}
	
	@Test
	public void testFindKeyAndReplaceValue() {
		String key1 = "java";
		String key2 = "spring";
		String key3 = "JDBC";
		String stringToFind ="D";
		Integer newValue = 0;
		Integer value1 = 42;
		Integer value2 = 13;
		Integer value3 = 999;
		
		Map<String, Integer> map = new HashMap<>();
		map.put(key1, value1);
		map.put(key2, value2);
		map.put(key3, value3);
		
		Map<String, Integer> result = collections.findKeyAndReplaceValue(map, stringToFind, newValue);
		
		assertEquals(result.get(key1), value1);
		assertEquals(result.get(key2), value2);
		assertEquals(result.get(key3), newValue);
	}
}
