package com.cap.dev.Exception;

public class UniversityAdmissionException extends Exception {
	 private static final long serialVersionUID = 1L;
		
		private int code;
		private String message;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public UniversityAdmissionException() {
			super();
		}
		public UniversityAdmissionException(int code, String message) {
			super();
			this.code = code;
			this.message = message;
		}
		

}
