package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }
    String cipher = "";
    String action = "";
    String str = "";
    String key = "";

    if (args.length == 4){
      for (int i = 0; i < args.length; i++) {

        if (args[i].charAt(0) == '-'){
          if (args[i].equals("-caesar")) {
            if (cipher.isEmpty()) {
              cipher = args[i];
            } else {
              System.err.println("Error: cipher parameter already given");
              return;
            }

          } else if (args[i].equals("-vigenere")) {
            if (cipher.isEmpty()) {
              cipher = args[i];
            } else {
              System.err.println("Error: cipher parameter already given");
              return;
            }

          } else if (args[i].equals("-encode")) {
            if (action.isEmpty()) {
              action = args[i];
            } else {
              System.err.println("Error: action parameter already give");
              return;
            }

          }  else if (args[i].equals("-decode")) {
            if (action.isEmpty()) {
              action = args[i];
            } else {
              System.err.println("Error: action parameter already give");
              return;
            }
          }

        } else {
          if (str.isEmpty()) {
            str = args[i];
          } else {
            key = args [i];
          }
        }

      }
    } else {
      System.err.printf("Error: Expected 4 parameters, received %d\n", args.length);
    }

    if (cipher.equals("-caesar")) {
      if (key.length() != 1){
        System.err.println("Error: caesar cipher takes single character key");
        return;
      } else if (action.equals("-encode")) {
        pen.println(CipherUtils.caesarEncrypt(str, key.charAt(0)));
      } else if (action.equals("-decode")) {
        pen.println(CipherUtils.caesarDecrypt(str, key.charAt(0)));
      }
    } else if (cipher.equals("-vigenere")){
      if (action.equals("-encode")) {
        pen.println(CipherUtils.vigenereEncrypt(str, key));
      } else if (action.equals("-decode")) {
        pen.println(CipherUtils.vigenereDecrypt(str, key));
      }
    }
    // pen.println(CipherUtils.caesarEncrypt(str, key.charAt(0)));
    // pen.printf("%S \n%S \n%S \n%S \n", cipher, action, str, key);
  } // end of main
} // end of class Cipher
