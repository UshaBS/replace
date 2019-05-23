package com.cap.dev.Exception;

public class UniversityExceptions {
	private int errorCode;
	private String errorMessage;
	
	public UniversityExceptions() {
		super();
	}

	public UniversityExceptions(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
