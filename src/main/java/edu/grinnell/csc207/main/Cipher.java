package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

public class Cipher {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    }
    for (int code = 0; code < args.length; code++){
      if (args[code].equals("-encode")){
        for (int cipher = 0; cipher < args.length; cipher++){
          if (args[cipher].equals("-caesar")){
            if (args[3].length() == 1){
              pen.println(CipherUtils.caesarEncrypt(args[2], args[3].charAt(0)));
              return;
            } else {
              System.err.println("Error: Caesar ciphers require a one-character key");
              return;
            }
          } else if (args[cipher].equals("-vigenere")){
            pen.println(CipherUtils.vigenereEncrypt(args[2], args[3]));
            return;
          }
        }

      } else if (args[code].equals("-decode")){
        for (int cipher = 0; cipher < args.length; cipher++){
          if (args[cipher].equals("-caesar")){
            if (args[3].length() == 1){
              pen.println(CipherUtils.caesarDecrypt(args[2], args[3].charAt(0)));
              return;
            } else if (!(args[cipher].length()==1)){
              System.err.println("Error: Caesar ciphers require a one-character key");
              return;
            }
          } else if (args[cipher].equals("-vigenere")){
            pen.println(CipherUtils.vigenereDecrypt(args[2], args[3]));
            return;
          } // checks if argument is -caesar or vigenere
        }
      } else {
        System.err.println("Error: No valid action specified. Legal values are '-encode' and '-decode'");
        return;
      } // checks if command arguments are valid, if not, error is given
    }
  }
}
