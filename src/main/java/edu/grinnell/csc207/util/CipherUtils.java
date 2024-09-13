package edu.grinnell.csc207.util;
/**
 * class CipherUtils holds methods to be used by class AllCaesar and Cipher.
 */
public class CipherUtils {
  /**
   * variable to account for 26 lower case letters being used.
   */
  private static final int EXPECTED_NUM_PARAMS = 26;
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
  } // end of letter2int
  /**
   *
   * @param i
   *  integer that is representative of a letter
   * @return char
   *  integer converted to character form
   */
  private static char int2letter(int i) {
    int base = (int) 'a';
    return (char) (i + base);
  } // end of int2letter
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
    for (int i = 0; i < str.length(); i++) {
      char charac = str.charAt(i);
      int num = letter2int(charac);
      int key = letter2int(letter);
      int added = num + key;
      added = added % EXPECTED_NUM_PARAMS;
      char newch = int2letter(added);
      fresh[i] = newch;
    } // iterates through string to encrypt
    return new String(fresh);
  } // end of caesarEncrypt
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
    for (int i = 0; i < str.length(); i++) {
      char charac = str.charAt(i);
      int added = letter2int(charac) - letter2int(letter);
      added = added % EXPECTED_NUM_PARAMS;
      if (added < 0) {
        added = EXPECTED_NUM_PARAMS + added;
      } // checks if character is negative, if so rebases is
      char newch = int2letter(added);
      fresh[i] = newch;
    } // iterates through string to decrypt with key
    return new String(fresh);
  } // end of caesarDecrypt
  /**
   *
   * @param str
   *  string that is meant to be encrypted
   * @param key
   *  string used to encrypt str
   * @return String
   *  returns encrypted string
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char charac = str.charAt(i);
      int leng = key.length();
      char charac2 = key.charAt(i % leng);
      int crypt = letter2int(charac) + letter2int(charac2);
      crypt = crypt % EXPECTED_NUM_PARAMS;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    } // iterates through string to encrypts with key
    return new String(fresh);
  } // end of vigenereEncrypt
  /**
   *
   * @param str
   *  string that is meant to be decrypted
   * @param key
   *  string to act as key for str
   * @return
   *  return decrypted string of original
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] fresh = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char charac = str.charAt(i);
      int leng = key.length();
      char charac2 = key.charAt(i % leng);
      int crypt = letter2int(charac) - letter2int(charac2);
      if (crypt < 0) {
        crypt = EXPECTED_NUM_PARAMS + crypt;
      } // checks if current character is negative, if so rebases it
      crypt = crypt % EXPECTED_NUM_PARAMS;
      char incrypt = int2letter(crypt);
      fresh[i] = incrypt;
    } // iterates through given string to decrypt wotj key
    return new String(fresh);
  } // end of vigenereDecrypt
} // methods used in other classes
