package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    int cur = (int) letter;
    int base = 97;
    return cur - base;
  }

  private static char int2letter(int i) {
    return (char) (i + 97);
  }

  public static String caesarEncrypt(String str, char letter) {
    char[] fresh = new char[str.length()];
    for(int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      int num = letter2int(charac);
      int key = letter2int(letter);
      int added = num + key;
      added = added % 26;
      char newch = int2letter(added);
      fresh[i] = newch;
    }
    return new String(fresh);
  }

  public static String caesarDecrypt(String str, char letter) {
    char[] fresh = new char[str.length()];
    for(int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);int added = letter2int(charac) - letter2int(letter);;
      if(added < 0){
        added = added * -1;
      }
      added = added % 26;
      char newch = int2letter(added);
      fresh[i] = newch;
    }
    return new String(fresh);
  }

  public static String vigenereEncrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for(int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      char charac2 = key.charAt(i);
      int crypt = letter2int(charac) + letter2int(charac2);
      crypt = crypt % 26;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    }
    return new String(fresh);
  }

  public static String vigenereDecrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for(int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      char charac2 = key.charAt(i);
      int crypt = letter2int(charac) - letter2int(charac2);
      if(crypt < 0){
        crypt = crypt * -1;
      }
      crypt = crypt % 26;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    }
    return new String(fresh);
  }
}
