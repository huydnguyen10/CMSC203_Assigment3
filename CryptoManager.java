import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */

/**
 * Class: CMSC203 
 * Instructor: Prof. Monshi
 * Description: Create a program that use two encrypt method are Caesar and Bellaso 
 * then encrypt and decrypt a paragraph.
 * Due: 10/21/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duc Huy Nguyen
*/

public class CryptoManager {

	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_RANGE and UPPER_RANGE characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean isStringInBounds(String plainText) {
		// throw new RuntimeException("method not implemented");
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) < LOWER_RANGE || plainText.charAt(i) > UPPER_RANGE)
				return false;
		}
		return true;

	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		// throw new RuntimeException("method not implemented");
		if (isStringInBounds(plainText)) {
			String tmp = "";
			int value;
			for (int i = 0; i < plainText.length(); i++) {
				value = (int) plainText.charAt(i) + key;
				while (value > UPPER_RANGE)
					value = value - RANGE;
				tmp += (char) value;
			}
			return tmp;
		} else {
			return "The selected string is not in bounds, Try again.";
		}
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		if (isStringInBounds(plainText)) {
			String tmp = "";
			int value;
			int a = 0;
			for (int i = 0; i < plainText.length(); i++) {
				value = (int) plainText.charAt(i) + (int) bellasoStr.charAt(a);
				a = (a + 1) % bellasoStr.length();
				while (value > UPPER_RANGE)
					value = value - RANGE;
				tmp += (char) value;
			}
			return tmp;
		} else {
			return "The slected string is not in bounds, Try again.";
		}
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		// throw new RuntimeException("method not implemented");
		String tmp = "";
		int value;
		for (int i = 0; i < encryptedText.length(); i++) {
			value = (int) encryptedText.charAt(i) - key;
			while (value < LOWER_RANGE)
				value = value + RANGE;
			tmp += (char) value;
		}
		return tmp;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		String tmp = "";
		int value;
		int a = 0;
		for (int i = 0; i < encryptedText.length(); i++) {
			value = (int) encryptedText.charAt(i) - (int) bellasoStr.charAt(a);
			a = (a + 1) % bellasoStr.length();
			while (value < LOWER_RANGE)
				value = value + RANGE;
			tmp += (char) value;
		}
		return tmp;
	}
}
