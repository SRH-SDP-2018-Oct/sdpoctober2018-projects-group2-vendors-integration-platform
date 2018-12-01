package org.srh.util;

import org.apache.log4j.Logger;


/**
 * Integer Utility Class
 * Date: 30 Nov 2018
 * @author Vivek
 */
public final class NumberUtil {

	private static final Logger LOGGER = Logger.getLogger(NumberUtil.class);

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
			LOGGER.error(StringUtil.append("Invalid Integer ", obj), ex);
			return null;
		}
	}


	/**
	 * Returns null if the given object is not Long else Long object is returned.
	 * @param obj {@link Object}
	 * @return longObj {@link Long}
	 */
	public static Long getLong(Object obj) {
		if(Common.nullOrEmptyTrim(obj))
			return null;
		try {
			return Long.valueOf(obj.toString());
		}
		catch(NumberFormatException ex) {
			LOGGER.error(StringUtil.append("Invalid Long ", obj), ex);
			return null;
		}
	}

}
