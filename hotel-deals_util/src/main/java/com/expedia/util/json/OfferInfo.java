package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferInfo {
	
	@JsonProperty("siteID")
	private int siteID;
	
	@JsonProperty("language")
	private String language;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("userSelectedCurrency")
	private String userSelectedCurrency;

	public int getSiteID() {
		return siteID;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getUserSelectedCurrency() {
		return userSelectedCurrency;
	}

	public void setUserSelectedCurrency(String userSelectedCurrency) {
		this.userSelectedCurrency = userSelectedCurrency;
	}

	@Override
	public String toString() {
		return "OfferInfo [siteID=" + siteID + ", language=" + language + ", currency=" + currency
				+ ", userSelectedCurrency=" + userSelectedCurrency + "]";
	}
}
