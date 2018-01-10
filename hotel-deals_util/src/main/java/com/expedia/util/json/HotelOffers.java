package com.expedia.util.json;

import java.io.IOException;

import com.expedia.util.JsonParserManager;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelOffers {
	
	@JsonProperty("offerInfo")
	private OfferInfo offerInfo;
	
	@JsonProperty("userInfo")
	private UserInfo userInfo;
	
	@JsonProperty("offers")
	private Offers offers;

	public OfferInfo getOfferInfo() {
		return offerInfo;
	}

	public void setOfferInfo(OfferInfo offerInfo) {
		this.offerInfo = offerInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Offers getOffers() {
		return offers;
	}

	public void setOffers(Offers offers) {
		this.offers = offers;
	}
	
	public String getHotelAsJSON(Hotel hotel) {
		JsonParserManager<Hotel> manager = new JsonParserManager<Hotel>(Hotel.class);
		
		String json = null;
		try {
			json = manager.parseObjectToJSON(hotel);
		} catch (IOException e) {
			json = "";
		}
		
		return json;
	}

	@Override
	public String toString() {
		return "HotelOffers [offerInfo=" + offerInfo + ", userInfo=" + userInfo + ", offers=" + offers + "]";
	}
}
