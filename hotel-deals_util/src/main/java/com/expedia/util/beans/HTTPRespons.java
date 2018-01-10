package com.expedia.util.beans;

public class HTTPRespons {
	int responseCode = -1;
	String result = "";

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "HTTPResponse [responseCode=" + responseCode + ", result=" + result + "]";
	}
}
