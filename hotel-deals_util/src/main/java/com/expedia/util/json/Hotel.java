package com.expedia.util.json;

import java.io.IOException;

import com.expedia.util.JsonParserManager;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {

	@JsonProperty("offerDateRange")
	private OfferDateRange offerDateRange;
	
	@JsonProperty("destination")
	private Destination destination;
	
	@JsonProperty("hotelInfo")
	private HotelInfo hotelInfo;
	
	@JsonProperty("hotelUrgencyInfo")
	private HotelUrgencyInfo hotelUrgencyInfo;
	
	@JsonProperty("hotelPricingInfo")
	private HotelPricingInfo hotelPricingInfo;
	
	@JsonProperty("hotelUrls")
	private HotelUrls hotelUrls;

	public OfferDateRange getOfferDateRange() {
		return offerDateRange;
	}

	public void setOfferDateRange(OfferDateRange offerDateRange) {
		this.offerDateRange = offerDateRange;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public HotelInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(HotelInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}

	public HotelUrgencyInfo getHotelUrgencyInfo() {
		return hotelUrgencyInfo;
	}

	public void setHotelUrgencyInfo(HotelUrgencyInfo hotelUrgencyInfo) {
		this.hotelUrgencyInfo = hotelUrgencyInfo;
	}

	public HotelPricingInfo getHotelPricingInfo() {
		return hotelPricingInfo;
	}

	public void setHotelPricingInfo(HotelPricingInfo hotelPricingInfo) {
		this.hotelPricingInfo = hotelPricingInfo;
	}

	public HotelUrls getHotelUrls() {
		return hotelUrls;
	}

	public void setHotelUrls(HotelUrls hotelUrls) {
		this.hotelUrls = hotelUrls;
	}
	
	@Override
	public String toString() {
		return "Hotel [offerDateRange=" + offerDateRange + ", destination=" + destination + ", hotelInfo=" + hotelInfo
				+ ", hotelUrgencyInfo=" + hotelUrgencyInfo + ", hotelPricingInfo=" + hotelPricingInfo + ", hotelUrls="
				+ hotelUrls + "]";
	}
}
