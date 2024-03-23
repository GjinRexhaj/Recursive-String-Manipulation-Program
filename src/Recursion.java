/*  Recursive String Manipulation Methods
 *  @author: Gjin Rexhaj
 *  @date:  3/22/2024
 *  @version: 1.0
 */


/** {@code Recursion} class: houses all methods except main method. */ 
public class Recursion {

  // important static instance variables are delcared at the class level
  private static String newString = "";
  private static char character;
  private static int asciiValue;
  private static int incrementor = 0;
  private static String cleanedString = "";

  /** {@code reverseString} method reverses the contents of a string recursively. */
  public static String reverseString(String input) {
    // Base case - terminates method when the newString length is equal to or exceeds input string
    if (newString.length() >= input.length()){
    return newString;	
    }

    // Recursive case - extracts each character, adds it to newString, then function calls itself
    character = input.charAt(newString.length());
    newString = character + newString;
    // call to self
    return reverseString(input);
  }

  public static void setAsciiValue(int newAsciiValue) {
    asciiValue = newAsciiValue;
  }

  /** {@code totalWord} method finds the sum of the integer values present in a word recursively. */
  public static int totalWord(String input) {
    // Base case, method terminates if incrementor equal to or exceeds input length
    if (incrementor >= input.length()){
    incrementor = 0;
    return asciiValue;
    }

    // Recursive case - extracts each character, takes the ascii value
    // and adds it to asciiValue int variable, then method calls itself
    character = input.charAt(incrementor);
    asciiValue += (int)character;
    incrementor++;
    return totalWord(input);
  } 

  

  /** {@code stringClean} method truncates identical adjacent characters recursively. */
  public static String stringClean(String input) {
    // Base case, method terminates if incrementor equal to or exceeds input length
    if (incrementor >= input.length()) {
      incrementor = 0;
      return cleanedString;	
    }

    // Recursive case
    // extra bit of code to prevent charAt out of bounds error
   input += " ";
    character = input.charAt(incrementor);
    // if next character is the same, remove it (logically equivalent)
    if (character != input.charAt(incrementor + 1)) { // problem line out of bounds length 6
      cleanedString += character;	
    }
    // retroactively fixes stack overflow error introduced by line 52: input += " ";
    input = input.substring(0, input.length() - 1);
    incrementor++;
    // recursive call to self
    return stringClean(input);
  }



  /** {@code palindromeChecker} method returns true if a palindrome is passed through recursively. */
  public static boolean palindromeChecker(String input) {
    // Base case: String containing one or no character(s) passes the test
    if (input.length() <= 1) {
      return true;
    }

    // Recursive case
    // check if first and last characters aren't the same, return false
    if (input.charAt(0) != input.charAt(input.length() - 1)) {
      return false;
    }
    // construct the remaining string with characters taken away, then run function again to check until base case

    String remainingString = input.substring(1, input.length() - 1);
    // call to self
    return palindromeChecker(remainingString);
  }



  /** {@code permutationHelper} method returns all possible permutations of a String recursively. */
  public static void permutationHelper(String input, String permutationString) {
    // Base case - method terminates if string is empty
    if (input.length() == 0) {
      System.out.print(permutationString + " ");
      return;
    }

    // Recursive case - use for loop to create all possible permutation characters with
    // a recursive call to permutationHelper() in the for loop
    for (int i = 0; i < input.length(); i++) {
      char permutationCharacter = input.charAt(i);
      String remainingString = input.substring(0, i) + input.substring(i + 1);
      permutationHelper(remainingString, permutationString + permutationCharacter);
    } 
  }
}