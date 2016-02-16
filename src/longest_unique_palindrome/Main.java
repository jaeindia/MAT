package longest_unique_palindrome;

/**
 * The longest_unique_palindrome.Main program implements an application that
 * prints the longest N palindromes in the given I/P string to the standard
 * output.
 *
 * @author Jayakumar AL M
 * @version 1.0
 * @since 2016-02-16
 */

public class Main {
	public static void main(String[] args) {
		try {
			Palindrome palindromeObj = new Palindrome();

			if (args.length == 1)
				palindromeObj.findLongestPalindrome(args[0].trim(), true);
			else
				palindromeObj.findLongestPalindrome(args[0].trim(), Integer.parseInt(args[1]));
		} catch (Exception e) {
			String usage = "Follow the below pattern to run the program - \n";
			usage += "java longest_unique_palindrome.Main <Input String> <Top N>\n";
			usage += "(Or)\n";
			usage += "java longest_unique_palindrome.Main <Input String>";

			System.out.println(usage);
		}
	}
}
