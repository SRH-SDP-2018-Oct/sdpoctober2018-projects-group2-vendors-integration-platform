package org.srh.constants;

public enum ErrorCode {

	INVALID_INPUT("01","Invalid Input"),
	NOT_FOUND("02","Not Found");

	private String code;
	private String message;

	ErrorCode(String c, String m) {
		code = c;
		message = m;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
