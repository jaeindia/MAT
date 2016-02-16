package longest_unique_palindrome;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;
import longest_unique_palindrome.PalinMapData;

/**
 * The longest_unique_palindrome.Palindrome class consists of methods that can
 * be used to find and print the longest N palindromes in the given I/P string
 * to the standard output.
 *
 * @author Jayakumar AL M
 * @version 1.0
 * @since 2016-02-16
 */

class Palindrome {
	/*Data Structure to store all the possible palindromes
	 * Eg. descPalinMap NavigableMap structure of the input string - "aab"
	 * 
	 * {
	 *		2=longest_unique_palindrome.PalinMapData {
	 *			textSet = [aa],
	 *			indexSet = [0]
	 *		}, 
	 *		1=longest_unique_palindrome.PalinMapData {
	 *			textSet = [a, b],
	 *			indexSet = [0, 2]
	 *		}
	 *	}
	 *
	 * Where - 
	 * 	keys [2, 1] are the length of the possible palindromes
	 * 	textSet - Unique palindromes corresponding to the key i.e. length of the palindrome.
	 * 	indexSet - Start Index of the respective unique palindromes i.e. From textSet.  	 
	 *
	 * */
	private TreeMap<Integer, PalinMapData> palinMap = new TreeMap<Integer, PalinMapData>();
	private NavigableMap<Integer, PalinMapData> descPalinMap;

	/**
	 * This method is used to print the top N longest unique palindromes.
	 * 
	 * @param descPalinMap
	 *            TreeMap palinMap sorted in the descending order of length of
	 *            the palindromes.
	 * @param topN
	 *            Number of palindromes to be printed
	 * @return Nothing.
	 */
	private void printPalindromeList(NavigableMap<Integer, PalinMapData> descPalinMap, int topN) {
		int printCount = 0;

		for (int key : descPalinMap.keySet()) {
			Iterator<String> textItr = descPalinMap.get(key).getTextSet().iterator();
			Iterator<Integer> indexItr = descPalinMap.get(key).getIndexSet().iterator();

			String printStr = "";
			while (textItr.hasNext() && indexItr.hasNext()) {
				printStr += "Text: " + textItr.next() + ", ";
				printStr += "Index: " + indexItr.next() + ", ";
				printStr += "Length: " + key + "\n";
			}

			System.out.println(printStr + "\n");

			++printCount;
			if (printCount == topN)
				break;
		}
	}

	/**
	 * This method updates the data structure TreeMap - palinMap.
	 * 
	 * @param inputString
	 *            Input String.
	 * @param len
	 *            Length of the Input String.
	 * @param start
	 *            left index from the center.
	 * @param end
	 *            right index from the center.
	 * @return Nothing.
	 */
	private void getPalindromeIndex(String inputString, int len, int start, int end) {
		char[] str = inputString.toLowerCase().toCharArray();
		int lengthOfPalindrome = end - start + 1;
		int index = 0;
		boolean modifiedFlag = false;

		while (start >= 0 && end < len && str[start] == str[end]) {
			modifiedFlag = true;

			start--;
			end++;
		}

		if (modifiedFlag) {
			++start;
			--end;
		}

		lengthOfPalindrome = (modifiedFlag) ? (end - start + 1) : 1;
		index = start;

		PalinMapData obj;

		if (!palinMap.containsKey(lengthOfPalindrome)) {
			obj = new PalinMapData();
			palinMap.put(lengthOfPalindrome, obj);
		}

		obj = palinMap.get(lengthOfPalindrome);

		obj.setTextSet(inputString.substring(index, index + lengthOfPalindrome));
		obj.setIndexSet(index);
	}

	/**
	 * This method is used to fetch all the possible palindromes from the input
	 * string.
	 * 
	 * @param str
	 *            Input String.
	 * @return Nothing.
	 */
	private void getPalindrome(String str) {
		int len = str.length();

		int start = 0;
		int end = 0;

		PalinMapData obj;

		if (!palinMap.containsKey(1)) {
			obj = new PalinMapData();
			palinMap.put(1, obj);
		}

		obj = palinMap.get(1);

		obj.setTextSet(str.charAt(0) + "");
		obj.setIndexSet(0);

		for (int i = 1; i < len; ++i) {
			/*
			 * Find the even length palindromes with center points as i-1 and i.
			 */
			start = i - 1;
			end = i;
			getPalindromeIndex(str, len, start, end);

			/* Find the odd length palindrome with center point as i */
			start = i - 1;
			end = i + 1;
			getPalindromeIndex(str, len, start, end);
		}
		
		obj.setTextSet(str.charAt(len - 1) + "");
		obj.setIndexSet(len - 1);
	}

	/**
	 * Driver method to find and print the top N palindromes.
	 * 
	 * @param str
	 *            Input String.
	 * @param topN
	 *            Number of palindromes to be printed
	 * @return Nothing.
	 */
	void findLongestPalindrome(String str, int topN) {
		getPalindrome(str);
		descPalinMap = palinMap.descendingMap();

		printPalindromeList(descPalinMap, topN);

	}

	/**
	 * Driver method to find and print all the palindromes.
	 * 
	 * @param str
	 *            Input String.
	 * @return Nothing.
	 */
	void findLongestPalindrome(String str, boolean printAll) {
		getPalindrome(str);
		descPalinMap = palinMap.descendingMap();

		int topN = descPalinMap.size();
		printPalindromeList(descPalinMap, topN);
	}
}
