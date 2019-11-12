package com.stantonscott.javabasics.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author stantonscott
 * @version 1.0
 *
 * <p>Creation Date: 29.10.19</p>
 * <p>Project Name: JavaBasics</p>
 */
public class Collections {

    /**
     * Get a string array
     *
     * @param string1
     * @param string2
     * @param string3
     * @param string4
     * @return array of strings
     */
    public String[] createStringArray(String string1, String string2, String string3, String string4) {

        String[] strings = {string1, string2, string3, string4};

        return strings;
    }

    /**
     * Get an int array
     *
     * @param int1
     * @param int2
     * @param int3
     * @param int4
     * @return array of ints
     */
    public int[] createIntArray(int int1, int int2, int int3, int int4) {
        int[] ints = {int1, int2, int3, int4};
        return ints;
    }

    /**
     * Get a list of strings
     *
     * @param string1
     * @param string2
     * @param string3
     * @param string4
     * @return list of strings
     */
    public List<String> createArrayListOfStrings(String string1, String string2, String string3, String string4) {
        List<String> strings = new ArrayList<>();
        strings.add(string1);
        strings.add(string2);
        strings.add(string3);
        strings.add(string4);
        return strings;
    }

    /**
     * Get a map with string keys and int values
     *
     * @param key1
     * @param key2
     * @param key3
     * @param value1
     * @param value2
     * @param value3
     * @return array of ints
     */
    public Map<String, Integer> createMap(String key1, String key2, String key3, int value1, int value2, int value3) {
        Map<String, Integer> map = new HashMap<>();

        map.put(key1, value1);
        map.put(key2, value2);
        map.put(key3, value3);


        return map;
    }

    /**
     * Replace the value of a key value map
     *
     * @param map
     * @param keyToFind
     * @param newValue
     * @return map with value replaced for key
     */
    public Map<String, Integer> findAndReplace(Map<String, Integer> map, String keyToFind, int newValue) {
        map.replace(keyToFind,newValue);
        return map;
    }

    /**
     * remove the value from a map
     *
     * @param map
     * @param keyToFind
     * @return map with value removed
     */
    public Map<String, Integer> removeEntry(Map<String, Integer> map, String keyToFind) {

    	map.remove(keyToFind);

        return map;
    }

    /**
     * Remove entries that have the given char in the key
     *
     * @param map
     * @return map with entries removed where key contains char
     */
    public Map<String, Integer> findKeyAndRemoveEntry(Map<String, Integer> map, String stringToFind) {

    	map.remove(stringToFind);
        return map;
    }

    /**
     * Replace any value of any entry with a newValue if its key contains the given char
     *
     * @param map
     * @return map with values replaced where key contains char
     */
    public Map<String, Integer> findKeyAndReplaceValue(Map<String, Integer> map, String stringToFind, Integer newValue) {

    	for (Map.Entry<String, Integer> pair: map.entrySet())
		{
			if (pair.getKey().contains(stringToFind))
			{
				map.replace(pair.getKey(), newValue);
			}
		}

        return map;
    }
}
