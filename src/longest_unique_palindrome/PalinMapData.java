package longest_unique_palindrome;

import java.util.LinkedHashSet;

/**
 * The longest_unique_palindrome.PalinMapData class define the data structure to
 * store the Texts and Indices of the identified palindromes in the input
 * string.
 *
 * @author Jayakumar AL M
 * @version 1.0
 * @since 2016-02-16
 */

class PalinMapData {
	private LinkedHashSet<String> textSet = new LinkedHashSet<String>();
	private LinkedHashSet<Integer> indexSet = new LinkedHashSet<Integer>();

	LinkedHashSet<String> getTextSet() {
		return textSet;
	}

	void setTextSet(String text) {
		textSet.add(text.toLowerCase());
	}

	LinkedHashSet<Integer> getIndexSet() {
		return indexSet;
	}

	void setIndexSet(int index) {
		if (textSet.size() != indexSet.size())
			indexSet.add(index);
	}
}
