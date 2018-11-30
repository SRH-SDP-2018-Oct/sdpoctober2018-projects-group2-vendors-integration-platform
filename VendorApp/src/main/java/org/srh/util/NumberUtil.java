package org.srh.util;

/**
 * Integer Utility Class
 * Date: 30 Nov 2018
 * @author Vivek
 */
public final class NumberUtil {

	private NumberUtil() { }

	/**
	 * Returns null if the given object is not Integer else Integer object is returned.
	 * @param obj {@link Object}
	 * @return integerObj {@link Integer}
	 */
	public static Integer getInteger(Object obj) {
		if(Common.nullOrEmptyTrim(obj))
			return null;
		try {
			return Integer.valueOf(obj.toString());
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
