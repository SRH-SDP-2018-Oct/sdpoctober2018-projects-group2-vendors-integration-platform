package org.srh.util;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

/**
 * String Utility Class   <br/>
 * Date: 29 Nov 2017
 * @author Vivek
 */
public class StringUtil {


	/**
	 * Appends the two string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2) {
		return new StringBuilder().append(obj1).append(obj2).toString();
	}
	
	/**
	 * Appends the three string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @param obj3 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2, Object obj3) {
		return new StringBuilder().append(obj1).append(obj2).append(obj3).toString();
	}
	
	/**
	 * Appends the four string objects
	 * @param obj1 {@link Object}
	 * @param obj2 {@link Object}
	 * @param obj3 {@link Object}
	 * @param obj4 {@link Object}
	 * @return strAppended {@link String}
	 */
	public static String append(Object obj1, Object obj2, Object obj3, Object obj4) {
		return new StringBuilder().append(obj1).append(obj2).append(obj3).append(obj4).toString();
	}


	/**
	 * Perform SHA256 Encryption on the input text and return the encrypted text.
	 * @param input {@link String}
	 * @return encryptedInput {@link String}
	 */
	public static String sha256(String input) {
		return Hashing.sha256().hashString(input, StandardCharsets.UTF_8).toString();
	}
}
