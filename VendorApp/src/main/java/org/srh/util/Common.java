package org.srh.util;

/**
 * Common Utility Class
 * Date: 30 Nov 2018
 * @author Vivek
 */
public final class Common {

	private Common() { }

	/**
	 * Returns true if the given object is null or blank
	 * @param obj {@link Object}
	 * @return result {@link Boolean}
	 */
	public static boolean nullOrEmpty(Object obj) {
		return obj!=null && "".equals(obj.toString());
	}

	/**
	 * Returns true if the given object is null or blank (after trim)
	 * @param obj {@link Object}
	 * @return result {@link Boolean}
	 */
	public static boolean nullOrEmptyTrim(Object obj) {
		return obj!=null && "".equals(obj.toString().trim());
	}
}
