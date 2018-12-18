package org.srh.util;

import org.apache.log4j.Logger;

/**
 * Logger Class for the application.   <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public class AppLog {

	public static final String DEFAULT_LOG_MESSAGE = "=====>>>>> EXCEPTION OCCURRED";
	public static final String DEFAULT_PRINT_MESSAGE = "=====>>>>> PRINTING";


	private AppLog() {}


	public static void log(Class<?> c, Object msg) {
		Logger.getLogger(c).error(msg);
	}


	public static void log(Class<?> c, Throwable ex) {
		Logger.getLogger(c).error(DEFAULT_LOG_MESSAGE, ex);
	}


	public static void log(Class<?> c, Object msg, Throwable ex) {
		Logger.getLogger(c).error(msg, ex);
	}


	public static void log(Class<?> c, Throwable ex, Object msg) {
		Logger.getLogger(c).error(msg, ex);
	}


	public static void print(Object msg) {
		Logger.getLogger(System.class).info(msg);
	}


	public static void print(Class<?> c, Object msg) {
		Logger.getLogger(c).info(msg);
	}


	public static void print(Class<?> c, Throwable ex) {
		Logger.getLogger(c).info(DEFAULT_PRINT_MESSAGE, ex);
	}


	public static void print(Class<?> c, Object msg, Throwable ex) {
		Logger.getLogger(c).info(msg, ex);
	}

}
