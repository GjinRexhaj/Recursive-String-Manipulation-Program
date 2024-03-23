/*  String Manipulation Program Menu
 *  @author: Gjin Rexhaj
 *  @since:  3/22/2024
 *  @version: 1.0
 */

import java.util.Scanner;

/** {@code Main} class serves as the driver class. */ 
public class Main {

  /** {@code main} method: acts as a menu which implements RecursionLab class. */ 
  public static void main(String[] args) {

    System.out.println("RECURSIVE STRING MANIPULATION PROGRAM");
    System.out.println("Written by Gjin Rexhaj on 3/22/2024");
    System.out.println("-------------------------------------");

    boolean looping = true;

    String inputString;
    Scanner optionScanner = new Scanner(System.in);
    Scanner inputStringScanner = new Scanner(System.in);

    do {
      System.out.println("[1]: reverseString, [2]: totalWord, [3]: stringClean, [4]: palindromeChecker, [5]: premutationHelper, [6]: terminate program");
      System.out.print("Please select which function you would like to perform by entering one of the above number keys: ");
      int option = optionScanner.nextInt();
      switch (option) {
        case 1: System.out.println("");
                System.out.print("Type a string to get reversed: ");
                inputString = inputStringScanner.nextLine();
                System.out.println("Reversed String: " + Recursion.reverseString(inputString));
                System.out.println("--------------------------------------");
                break;
        case 2: System.out.println("");
                System.out.print("Type a string to find the sum of all it's character ASCII values: ");
                inputString = inputStringScanner.nextLine();
                System.out.println("Sum of ASCII values: " + Recursion.totalWord(inputString));
                System.out.println("--------------------------------------");
                Recursion.setAsciiValue(0);
                break;
        case 3: System.out.println("");
                System.out.print("Type a string to clean all consecutive characters: ");
                inputString = inputStringScanner.nextLine();
                System.out.println("Cleaned up string: " + Recursion.stringClean(inputString));
                System.out.println("--------------------------------------");
                break;
        case 4: System.out.println("");
                System.out.print("Type a string to check if it's a palindrome: ");
                inputString = inputStringScanner.nextLine();
                System.out.println("Is palindrome? " + Recursion.palindromeChecker(inputString));
                System.out.println("--------------------------------------");
                break;
        case 5: System.out.println("");
                System.out.print("Type a string to generate all permutations of it: ");
                inputString = inputStringScanner.nextLine();
                System.out.print("all permutations: ");
                Recursion.permutationHelper(inputString, "");
                System.out.println("");
                System.out.println("--------------------------------------");
                break;
        case 6: System.out.println("Program Terminated...");
                looping = false;
                break;
        default:System.out.println("");
                System.out.println("Integer out of bounds, try again...");
                System.out.println("--------------------------------------");
                break;
      }
    } while (looping == true);
    optionScanner.close();
    inputStringScanner.close();
  }
}
