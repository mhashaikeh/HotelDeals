package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelInfo {

	@JsonProperty("hotelId")
	private Long hotelId;
	
	@JsonProperty("hotelName")
	private String hotelName;
	
	@JsonProperty("localizedHotelName")
	private String localizedHotelName;
	
	@JsonProperty("hotelDestination")
	private String hotelDestination;
	
	@JsonProperty("hotelDestinationRegionID")
	private Long hotelDestinationRegionID;
	
	@JsonProperty("hotelLongDestination")
	private String hotelLongDestination;
	
	@JsonProperty("hotelStreetAddress")
	private String hotelStreetAddress;
	
	@JsonProperty("hotelCity")
	private String hotelCity;
	
	@JsonProperty("hotelProvince")
	private String hotelProvince;
	
	@JsonProperty("hotelCountryCode")
	private String hotelCountryCode;
	
	@JsonProperty("hotelLatitude")
	private Double hotelLatitude;
	
	@JsonProperty("hotelLongitude")
	private Double hotelLongitude;
	
	@JsonProperty("hotelStarRating")
	private Double hotelStarRating;
	
	@JsonProperty("hotelGuestReviewRating")
	private Double hotelGuestReviewRating;
	
	@JsonProperty("hotelReviewTotal")
	private Integer hotelReviewTotal;
	
	@JsonProperty("hotelImageUrl")
	private String hotelImageUrl;
	
	@JsonProperty("isOfficialRating")
	private Boolean isOfficialRating;

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocalizedHotelName() {
		return localizedHotelName;
	}

	public void setLocalizedHotelName(String localizedHotelName) {
		this.localizedHotelName = localizedHotelName;
	}

	public String getHotelDestination() {
		return hotelDestination;
	}

	public void setHotelDestination(String hotelDestination) {
		this.hotelDestination = hotelDestination;
	}

	public Long getHotelDestinationRegionID() {
		return hotelDestinationRegionID;
	}

	public void setHotelDestinationRegionID(Long hotelDestinationRegionID) {
		this.hotelDestinationRegionID = hotelDestinationRegionID;
	}

	public String getHotelLongDestination() {
		return hotelLongDestination;
	}

	public void setHotelLongDestination(String hotelLongDestination) {
		this.hotelLongDestination = hotelLongDestination;
	}

	public String getHotelStreetAddress() {
		return hotelStreetAddress;
	}

	public void setHotelStreetAddress(String hotelStreetAddress) {
		this.hotelStreetAddress = hotelStreetAddress;
	}

	public String getHotelCity() {
		return hotelCity;
	}

	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}

	public String getHotelProvince() {
		return hotelProvince;
	}

	public void setHotelProvince(String hotelProvince) {
		this.hotelProvince = hotelProvince;
	}

	public String getHotelCountryCode() {
		return hotelCountryCode;
	}

	public void setHotelCountryCode(String hotelCountryCode) {
		this.hotelCountryCode = hotelCountryCode;
	}

	public Double getHotelLatitude() {
		return hotelLatitude;
	}

	public void setHotelLatitude(Double hotelLatitude) {
		this.hotelLatitude = hotelLatitude;
	}

	public Double getHotelLongitude() {
		return hotelLongitude;
	}

	public void setHotelLongitude(Double hotelLongitude) {
		this.hotelLongitude = hotelLongitude;
	}

	public Double getHotelStarRating() {
		return hotelStarRating == null ? 0.0 : hotelStarRating;
	}
	
	public Double getHotelStarRatingPercent() {
		if(getHotelStarRating() == 0)
			return 0d;
		return (getHotelStarRating() * 100d ) / 5d;
	}

	public void setHotelStarRating(Double hotelStarRating) {
		this.hotelStarRating = hotelStarRating;
	}

	public Double getHotelGuestReviewRating() {
		return hotelGuestReviewRating;
	}

	public void setHotelGuestReviewRating(Double hotelGuestReviewRating) {
		this.hotelGuestReviewRating = hotelGuestReviewRating;
	}

	public Integer getHotelReviewTotal() {
		return hotelReviewTotal;
	}

	public void setHotelReviewTotal(Integer hotelReviewTotal) {
		this.hotelReviewTotal = hotelReviewTotal;
	}

	public String getHotelImageUrl() {
		return hotelImageUrl;
	}

	public void setHotelImageUrl(String hotelImageUrl) {
		this.hotelImageUrl = hotelImageUrl;
	}

	public Boolean getIsOfficialRating() {
		return isOfficialRating;
	}

	public void setIsOfficialRating(Boolean isOfficialRating) {
		this.isOfficialRating = isOfficialRating;
	}

	@Override
	public String toString() {
		return "HotelInfo [hotelId=" + hotelId + ", hotelName=" + hotelName + ", localizedHotelName="
				+ localizedHotelName + ", hotelDestination=" + hotelDestination + ", hotelDestinationRegionID="
				+ hotelDestinationRegionID + ", hotelLongDestination=" + hotelLongDestination + ", hotelStreetAddress="
				+ hotelStreetAddress + ", hotelCity=" + hotelCity + ", hotelProvince=" + hotelProvince
				+ ", hotelCountryCode=" + hotelCountryCode + ", hotelLatitude=" + hotelLatitude + ", hotelLongitude="
				+ hotelLongitude + ", hotelStarRating=" + hotelStarRating + ", hotelGuestReviewRating="
				+ hotelGuestReviewRating + ", hotelReviewTotal=" + hotelReviewTotal + ", hotelImageUrl=" + hotelImageUrl
				+ ", isOfficialRating=" + isOfficialRating + "]";
	}
}
