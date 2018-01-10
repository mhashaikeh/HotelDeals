package com.expedia.util.json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelUrls {
	
	@JsonProperty("hotelInfositeUrl")
	private String hotelInfositeUrl;
	
	@JsonProperty("hotelSearchResultUrl")
	private String hotelSearchResultUrl;

	public String getHotelInfositeUrl() {
		try {
			return URLDecoder.decode(hotelInfositeUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return hotelInfositeUrl;
		}
	}

	public void setHotelInfositeUrl(String hotelInfositeUrl) {
		this.hotelInfositeUrl = hotelInfositeUrl;
	}

	public String getHotelSearchResultUrl() {
		try {
			return URLDecoder.decode(hotelSearchResultUrl, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return hotelSearchResultUrl;
		}
	}

	public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
		this.hotelSearchResultUrl = hotelSearchResultUrl;
	}

	@Override
	public String toString() {
		return "HotelUrls [hotelInfositeUrl=" + hotelInfositeUrl + ", hotelSearchResultUrl=" + hotelSearchResultUrl
				+ "]";
	}
}
