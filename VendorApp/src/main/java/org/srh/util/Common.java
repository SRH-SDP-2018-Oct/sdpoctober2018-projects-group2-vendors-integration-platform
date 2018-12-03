package org.srh.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;
import org.srh.annotation.POJO;
import org.srh.bean.ServiceResp;
import org.srh.bean.ServiceRespArray;
import org.srh.constants.ErrorCode;

/**
 * Common Utility Class
 * Date: 30 Nov 2018
 * @author Vivek
 */
public final class Common {

	private static final Logger LOGGER = Logger.getLogger(Common.class);

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


	/**
	 * Checks if the given class has annotated with {@link POJO},
	 * if yes then the setter fields mentioned in annotation are nullified.
	 * @param obj {@link Object}
	 * @return modified {@link Object}
	 */
	public static Object hidePojoData(Object obj) {
		if(obj==null)
			return obj;

		Class<?> cls = obj.getClass();

		Annotation annotation = cls.getAnnotation(POJO.class);
		if(annotation==null)
			return obj;

		POJO pojo = (POJO) annotation;
		String[] hidden = pojo.hidden();
		String[] hiddenParam = pojo.hiddenParam();

		if(hidden.length==0 || hidden.length!=hiddenParam.length)
			return obj;

		if(Common.nullOrEmptyTrim(hidden[0]) || Common.nullOrEmptyTrim(hiddenParam[0]) )
			return obj;
		
		for(int i=hidden.length-1; i>-1; i--) {
			String hiddenField = hidden[i];
			String hiddenClass = hiddenParam[i];
			try {
				Method m = cls.getMethod(hiddenField, Class.forName(hiddenClass));
				m.invoke(obj, new Object[1]);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
				LOGGER.error("Exception occurred during hidden POJO data", ex);
			}
		}
		return obj;
	}


	public static ServiceResp buildServiceRespError(ErrorCode errorCode, String errorDescription) {
		return new ServiceResp().setErrorCode(errorCode).setErrorDescription(errorDescription);
	}


	public static ServiceResp buildServiceRespError(ErrorCode errorCode, String errorDescription,
			Throwable throwable) {
		return new ServiceResp().setErrorCode(errorCode).setErrorDescription(errorDescription)
				.setThrowable(throwable);
	}


	public static ServiceResp buildServiceResp(Object obj) {
		return new ServiceResp().setSuccessData(obj);
	}


	public static ServiceResp buildServiceResp(Object obj, String successDescription) {
		return new ServiceResp().setSuccessData(obj).setSuccessDescription(successDescription);
	}


	public static ServiceRespArray buildServiceRespArrayError(ErrorCode errorCode,
			String errorDescription) {
		return new ServiceRespArray().setErrorCode(errorCode).setErrorDescription(errorDescription);
	}


	public static ServiceRespArray buildServiceRespArrayError(ErrorCode errorCode,
			String errorDescription, Throwable throwable) {
		return new ServiceRespArray().setErrorCode(errorCode).setErrorDescription(errorDescription)
				.setThrowable(throwable);
	}


	public static ServiceRespArray buildServiceRespArray(List<?> list) {
		return new ServiceRespArray().setSuccessData(list);
	}


	public static ServiceRespArray buildServiceRespArray(List<?> list, String successDescription) {
		return new ServiceRespArray().setSuccessData(list).setSuccessDescription(successDescription);
	}

}
