package org.srh.bean;

import org.srh.constants.ErrorCode;

public class ServiceResp {

	// Errors
	private ErrorCode errorCode;
	private String errorDescription;
	private Throwable throwable;

	// Success
	private Object successData;
	private String successDescription;

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public ServiceResp setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
	public ServiceResp setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
		return this;
	}

	public Throwable getThrowable() {
		return throwable;
	}
	public ServiceResp setThrowable(Throwable throwable) {
		this.throwable = throwable;
		return this;
	}

	public Object getSuccessData() {
		return successData;
	}
	public ServiceResp setSuccessData(Object successData) {
		this.successData = successData;
		return this;
	}

	public String getSuccessDescription() {
		return successDescription;
	}
	public ServiceResp setSuccessDescription(String successDescription) {
		this.successDescription = successDescription;
		return this;
	}

}
