package org.srh.constants;

/**
 * Constant Keys throughout the application.   <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public enum KeyConstant {

	DATA("data"), STATUS("status"), SUCCESS("success"), DESC("description"), ERROR("error"),
	ERROR_CODE("error_code"), ERROR_MESSAGE("error_message"), ERROR_DESC("error_description");

	private String val;

	KeyConstant(String v) {
		val = v;
	}

	public String val() {
		return val;
	}
}
