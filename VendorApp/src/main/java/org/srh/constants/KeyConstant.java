package org.srh.constants;

public enum KeyConstant {

	DATA("data"), ERROR("error"),
	ERROR_CODE("error_code"), ERROR_MESSAGE("error_message"), ERROR_DESC("error_description");

	private String val;

	KeyConstant(String v) {
		val = v;
	}

	public String val() {
		return val;
	}
}
