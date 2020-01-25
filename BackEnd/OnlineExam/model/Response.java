package com.onlineexam.model;

public class Response<T> {

	private String responseMessage;
	private long responseCode;
	private T responseObject;

	public Response() {
		super();
	}

	public Response(String responseMessage, long responseCode, T responseObject) {
		super();
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
		this.responseObject = responseObject;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public long getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(long responseCode) {
		this.responseCode = responseCode;
	}

	public T getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}
}
