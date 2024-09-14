package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * class cipher takes in command line arguments to cipher appropriately.
 * @author Luis Lopez
 * course: Fa CSC-207-01
 * date: 9/10/24
 * acknowledgements: Mentor Maria
 */
public class Cipher {
  /**
   * expected amount of command line arguments.
   */
  private static final int EXPECTED_NUM_PARAMS = 4;
      /**
   * variable to account for 26 lower case letters being used.
   */
  private static final int EXPECTED_NUME_PARAMS = 26;
  /**
   *
   * @param args
   *  command line arguments to tell determine appropriate ciphering.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String cipher = "";
    String action = "";
    String str = "";
    String key = "";

    if (args.length == EXPECTED_NUM_PARAMS) {
      for (int i = 0; i < args.length; i++) {
        if (args[i].isEmpty()) {
          if (!str.isEmpty()) {
            System.err.println("Error: Empty kers are not permitted");
            return;
          } // if str is not empty, but empty string is found, error for empty key
          return;
        } // checks if command argument is empty, if so return error for empty key or nothing for empty string
        if (args[i].charAt(0) == '-') {
          if (args[i].equals("-caesar")) {
            if (cipher.isEmpty()) {
              cipher = args[i];
            } else {
              System.err.println("Error: strings must be only lowercase letters");
              return;
            } // checks if cipher variable is filled, if not set, if yes give error
          } else if (args[i].equals("-vigenere")) {
            if (cipher.isEmpty()) {
              cipher = args[i];
            } else {
              System.err.println("Error: strings must be only lowercase letters");
              return;
            } // checks if cipher variable is filled, if not set, if yes give error
          } else if (args[i].equals("-encode")) {
            if (action.isEmpty()) {
              action = args[i];
            } else {
              System.err.println("Error: strings must be only lowercase letters");
              return;
            } // checks if action variable is filled, if not set, if yes give error
          }  else if (args[i].equals("-decode")) {
            if (action.isEmpty()) {
              action = args[i];
            } else {
              System.err.println("Error: strings must be only lowercase letters");
              return;
            } // checks if action variable is filled, if not set, if yes give error
          } else {
            System.err.println("Error: No valid action specified. Legal values are '-encode' and '-decode'");
            return;
          } // checks if command line argument starts with '-' to find proper variable to set
        } else {
          if (str.isEmpty()) {
            str = args[i];
          } else {
            key = args[i];
          } // checks if str variable is filled, if not fill with string, if yes then fill key
        } // checks argument to see if action, cipher, string, or key to then be set
      } // for loop to set command line arguments to appropriate variables
    } else {
      System.err.printf("Error: Expected 4 parameters, received %d\n", args.length);
    } // end of main

    for (int i = 0; i < str.length(); i++) {
      char chr = str.charAt(i);
      int check = (int) chr - (int) 'a';
      if (check > EXPECTED_NUME_PARAMS || check < 0) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      } // checks if letter is lower case, if not error is given
    } // iterates through key to check if all lower case letters
    for (int i = 0; i < key.length(); i++) {
      char chr = key.charAt(i);
      int check = (int) chr - (int) 'a';
      if (check > EXPECTED_NUME_PARAMS || check < 0) {
        System.err.println("Error: String contains characters other than lowercase letters.");
        return;
      } // checks if letter is lower case, if not error is given
    } // iterates through key to check if all lower case letters
    if (cipher.equals("-caesar")) {
      if (key.length() != 1) {
        System.err.println("Error: caesar cipher takes single character key");
        return;
      } else if (action.equals("-encode")) {
        pen.println(CipherUtils.caesarEncrypt(str, key.charAt(0)));
      } else if (action.equals("-decode")) {
        pen.println(CipherUtils.caesarDecrypt(str, key.charAt(0)));
      } // checks if action is decode or encode to perform encyption
    } else if (cipher.equals("-vigenere")) {
      if (action.equals("-encode")) {
        pen.println(CipherUtils.vigenereEncrypt(str, key));
      } else if (action.equals("-decode")) {
        pen.println(CipherUtils.vigenereDecrypt(str, key));
      } // checks if action is decode or encode to perform encyption
    } // checks variables 'cipher' and to figure out proper method calls for encryption
  } // end of main
} // end of class Cipher
