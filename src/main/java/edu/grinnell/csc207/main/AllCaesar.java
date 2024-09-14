package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * class AllCaesar to take in command line arguments to decrypt/encrypt strings.
 */
public class AllCaesar {
    /**
   * variable to account for 26 lower case letters being used.
   */
  private static final int EXPECTED_NUM_PARAMS = 26;
  /**
   *
   * @param args
   *  takes command line arguments to either encode or decode using string with caesar cipher.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length > 2 || args.length < 2) {
      System.err.println("Error: Incorrect number of parameters");
      return;
    } else {
      String str = args[1];
      for (int i = 0; i < str.length(); i++) {
        char chr = str.charAt(i);
        int check = (int) chr - (int) 'a';
        if (check > EXPECTED_NUM_PARAMS || check < 0) {
          System.err.println("Error: String contains characters other than lowercase letters.");
          return;
        } // checks if characters are only lower case letters, if not, error is given
      } // iterates through string to check if only lower case letters
    } //checks if correct number of arguments are passed, if not returns an error else checks if string contains only lower case characters
    if (args[0].equals("encode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(args[1], ch));
      } // takes string and encrypts with each letter of the alphabet
    } else if (args[0].equals("decode")) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(args[1], ch));
      } // takes string and decrypts with each letter of the alphabet
    } else {
      System.err.println("Error: Invalid Option " + args[0] + ". Valid options are \"Encode\" and \"Encode\" ");
    } // checks if argument passed is valid option, if not error is given
    pen.close();
  } // main where methods are written to be used
} // end of class
