package edu.grinnell.csc207.util;

public class CipherUtils {
  /**
   * 
   * @param letter
   *  character taken to be turned into integer representation
   * @return int
   *  character is turned into integer representation for math
   */
  private static int letter2int(char letter) {
    int cur = (int) letter;
    int base = (int) 'a';
    return cur - base;
  }
  /**
   * 
   * @param i
   *  integer that is representative of a letter
   * @return char
   *  integer converted to character form
   * 
   */
  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (i + base);
  }
  /**
   * 
   * @param str
   *  string to be encrypted
   * @param letter
   *  letter to act as encryption key
   * @return
   *  string once original is encrypted with key
   */
  public static String caesarEncrypt(String str, char letter) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
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
  /**
   * 
   * @param str
   *  string to be encrypted
   * @param letter
   *  letter to act as encryption key
   * @return
   *  string once original is encrypted with key
   */
  public static String caesarDecrypt(String str, char letter) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      int added = letter2int(charac) - letter2int(letter);
      added = added % 26;
      if (added < 0){
        added = 26 + added;
      }
      char newch = int2letter(added);
      fresh[i] = newch;
    }
    return new String(fresh);
  }
  /**
   * 
   * @param str
   *  
   * @param key
   * @return
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      int leng = key.length();
      char charac2 = key.charAt(i%leng);
      int crypt = letter2int(charac) + letter2int(charac2);
      crypt = crypt % 26;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    }
    return new String(fresh);
  }
  /**
   * 
   * @param str
   *  string that is meant to be decrypted
   * @param letter
   *  letter to act as string decryption key
   * @return
   *  return decrypted string of original
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++){
      char charac = str.charAt(i);
      int leng = key.length();
      char charac2 = key.charAt(i%leng);
      int crypt = letter2int(charac) - letter2int(charac2);
      if (crypt < 0){
        crypt = 26 + crypt;
      }
      crypt = crypt % 26;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    }
    return new String(fresh);
  }
} // methods used in other 
