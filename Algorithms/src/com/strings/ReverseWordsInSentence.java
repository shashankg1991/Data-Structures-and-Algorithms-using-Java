package com.strings;

/*-
 * input: I am writing code.
 * output: code. writing am I
 * 
 * Consider only space a word delimiter.
 * 
 * A generic solution exist where we: 
 * 	Create a new buffer of same size as of string. 
 * 	Start reading string from end of String. 
 * 	Go backwards till space is encountered. 
 * 	Copy the value from position next to space to end of word in buffer created above. 
 * 	Repeat till we reach beginning of string.
 * 
 * 
 * Better approach: 
 * 	Reverse entire string in one go in same string. 
 * 	Then reverse individual words.
 * 
 * @author shashankgupta
 *
 */
public class ReverseWordsInSentence {
	public static String reverseWords(String sentence) {
		char[] sentenceWords = sentence.toCharArray();
		reverseCharacters(sentenceWords, 0, sentenceWords.length - 1);
		int start = 0, end = 0;
		while (end <= sentenceWords.length) {
			// If sentence ends of if a word completes reverse.
			if (end == sentenceWords.length || sentenceWords[end] == ' ') {
				reverseCharacters(sentenceWords, start, end - 1);
				end++;
				start = end;
			} else {
				end++;
			}
		}
		return new String(sentenceWords);
	}

	public static void reverseCharacters(char[] characterArray, int start,
			int end) {
		while (start < end) {
			char temp = characterArray[start];
			characterArray[start] = characterArray[end];
			characterArray[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("Code is being tested."));
	}
}
