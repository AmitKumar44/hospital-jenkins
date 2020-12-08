package com.example.hospitalfrontdesk.exception;


public enum CustomFunctionalError {
	
	NO_BEDS("NO beds available for the searched hospital name","10001");
	
	
	private final String message;
	private final String errorCode;
	
	
	
	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	private CustomFunctionalError(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getFormattedMessage(final String arg) {
		return String.format(message, arg);
	}
	
	public String getFormattedCode(final String arg) {
		return String.format(errorCode, arg);
	}

}
