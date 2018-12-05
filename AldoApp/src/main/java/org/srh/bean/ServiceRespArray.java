package org.srh.bean;

import java.util.List;

import org.srh.constants.ErrorCode;

public class ServiceRespArray {

	// Errors
	private ErrorCode errorCode;
	private String errorDescription;
	private Throwable throwable;

	// Success
	private List<?> successData;
	private String successDescription;

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public ServiceRespArray setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
		return this;
	}

	public String getErrorDescription() {
		return errorDescription;
	}
	public ServiceRespArray setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
		return this;
	}

	public Throwable getThrowable() {
		return throwable;
	}
	public ServiceRespArray setThrowable(Throwable throwable) {
		this.throwable = throwable;
		return this;
	}

	public List<?> getSuccessData() {
		return successData;
	}
	public ServiceRespArray setSuccessData(List<?> successData) {
		this.successData = successData;
		return this;
	}

	public String getSuccessDescription() {
		return successDescription;
	}
	public ServiceRespArray setSuccessDescription(String successDescription) {
		this.successDescription = successDescription;
		return this;
	}

}
