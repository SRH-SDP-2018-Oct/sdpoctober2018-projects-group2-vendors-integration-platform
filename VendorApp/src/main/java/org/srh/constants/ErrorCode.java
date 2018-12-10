package org.srh.constants;

/**
 * Error Code enumeration.   <br/>
 * Date: 01 Dec 2018
 * @author Vivek
 */
public enum ErrorCode {

	ERROR( Codes.ERROR, "Error"),
	INVALID_INPUT( Codes.INVALID_INPUT, "Invalid Input"),
	NOT_FOUND( Codes.NOT_FOUND, "Not Found"),
	INVALID_CREDENTIALS( Codes.INVALID_CREDENTIALS, "Invalid Credentials"),
	USER_EXISTS(Codes.USER_EXISTS, "User already exists");

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
