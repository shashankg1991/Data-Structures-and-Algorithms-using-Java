package com.strings;

import java.util.HashMap;

/**
 * If we check all the characters against every unwanted character then the
 * complexity will be O(m*n) which is O(n^2) in case both strings are same.
 * 
 * If we check the character against all unwanted characters using hashmap and
 * delete every character by shifting the characters then also complexity will
 * be high.
 * 
 * If we take new buffer and copy only the required characters, then space
 * complexity will be high.
 * 
 * The given method uses same character array to read and write as write will
 * always be either same as read or behind read.
 * 
 * We are assuming all characters fit in single char variable, otherwise main
 * concept could be missed (Refer:FirstNonRepeaterCharacter algo for the
 * character > 16 bits)
 * 
 * @author shashank2484
 *
 */
public class RemoveCharactersFromString {
	public static String removeUnwantedCharactersFromString(String input,
			String unwantedCharachters) {
		char[] inputStringAsArray = input.toCharArray();
		Object present = new Object();

		// Created a hashmap of unwanted chars to make lookup O(1)
		HashMap<Character, Object> unwantedCharactersHashMap = new HashMap<>();
		for (char unwantedChar : unwantedCharachters.toCharArray()) {
			unwantedCharactersHashMap.put(unwantedChar, present);
		}

		// Override values on original string as new string will always be
		// shorter or of same size as the original string.
		int read = 0, write = 0;
		for (; read < inputStringAsArray.length; read++) {
			if (null == unwantedCharactersHashMap.get(inputStringAsArray[read])) {
				inputStringAsArray[write] = inputStringAsArray[read];
				write++;
			}
		}

		// Create a string from original string of length that has been
		// overwritten
		return new String(inputStringAsArray, 0, write);
	}

	public static void main(String[] args) {
		String modifiedString = removeUnwantedCharactersFromString(
				"hello world", "eol");
		System.out.println(modifiedString);
	}
}
