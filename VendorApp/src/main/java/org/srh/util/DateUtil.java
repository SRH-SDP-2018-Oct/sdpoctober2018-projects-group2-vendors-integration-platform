package org.srh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final String STR_MMDDYYYY_HHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final SimpleDateFormat SDF_MMDDYYYY_HHMMSS = new SimpleDateFormat(STR_MMDDYYYY_HHMMSS);

	public static String getMMDDYYYY_HHMMSS() {
		Date now = new Date();
		return SDF_MMDDYYYY_HHMMSS.format(now);
	}

}
