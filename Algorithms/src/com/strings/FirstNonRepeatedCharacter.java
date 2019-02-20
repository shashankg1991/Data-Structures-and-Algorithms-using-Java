package com.strings;

import java.util.LinkedHashMap;

/**
 * Character in java is 16 bits and was designed to store the values all the
 * unicode characters present at that time. However, the number of characters
 * increased > 2^16. To tackle this, java created a functionality that a
 * character can be denoted by a single character or by 2 characters in
 * combination.
 * 
 * codePointAt method gives the value of character as integer. The character can
 * have 2 parts, lower surrogate and a higher surrogate each of them is a
 * character. Both have individual ranges. Java checks if the first part has
 * value in range of lower surrogate and 2nd part has value in range of higher
 * surrogate then it combines them and gives the integer value when requested bu
 * codePointAt otherwise the value of individual character is returned.
 * 
 * charCount checks on the basis of integer value if this value is denoted by
 * single character or by 2 characters
 * 
 * toChars converts the character int value to proper character for display.
 * 
 * Complexity : O(n)
 * 
 * @author shashankgupta
 */
public class FirstNonRepeatedCharacter {
	public static void printFirstNonRepeatedCharacter(String text) {
		LinkedHashMap<Integer, Object> characterMultipleMap = new LinkedHashMap<Integer, Object>();

		// Create 2 object to denote single or multiple occurrences.
		final Object single = new Object();
		final Object multiple = new Object();

		// Iterate the string
		for (int counter = 0; counter < text.length();) {
			int intValueForCharacter = text.codePointAt(counter);

			// Puts the char as int and count in the map.
			if (null == characterMultipleMap.get(intValueForCharacter)) {
				characterMultipleMap.put(intValueForCharacter, single);
			} else if (single == characterMultipleMap.get(intValueForCharacter)) {
				characterMultipleMap.put(intValueForCharacter, multiple);
			}

			// Check if the counter must be incremented by 1 or 2 positions.
			int characterCount = Character.charCount(intValueForCharacter);
			counter += characterCount;
		}

		// Print the first non-repeated character.
		for (Integer key : characterMultipleMap.keySet()) {
			if (characterMultipleMap.get(key) == single) {
				System.out.println(Character.toChars(key));
				break;
			}
		}
	}

	public static void main(String[] args) {
		printFirstNonRepeatedCharacter("hhello");
		printFirstNonRepeatedCharacter("👦hello");
	}

}
