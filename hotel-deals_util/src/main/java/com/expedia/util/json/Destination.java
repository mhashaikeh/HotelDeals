package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination {

	@JsonProperty("regionID")
	private Long regionID;
	
	@JsonProperty("associatedMultiCityRegionId")
	private Long associatedMultiCityRegionId;
	
	@JsonProperty("longName")
	private String longName;
	
	@JsonProperty("shortName")
	private String shortName;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("province")
	private String province;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("tla")
	private String tla;
	
	@JsonProperty("nonLocalizedCity")
	private String nonLocalizedCity;

	public Long getRegionID() {
		return regionID;
	}

	public void setRegionID(Long regionID) {
		this.regionID = regionID;
	}

	public Long getAssociatedMultiCityRegionId() {
		return associatedMultiCityRegionId;
	}

	public void setAssociatedMultiCityRegionId(Long associatedMultiCityRegionId) {
		this.associatedMultiCityRegionId = associatedMultiCityRegionId;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTla() {
		return tla;
	}

	public void setTla(String tla) {
		this.tla = tla;
	}

	public String getNonLocalizedCity() {
		return nonLocalizedCity;
	}

	public void setNonLocalizedCity(String nonLocalizedCity) {
		this.nonLocalizedCity = nonLocalizedCity;
	}

	@Override
	public String toString() {
		return "Destination [regionID=" + regionID + ", associatedMultiCityRegionId=" + associatedMultiCityRegionId
				+ ", longName=" + longName + ", shortName=" + shortName + ", country=" + country + ", province="
				+ province + ", city=" + city + ", tla=" + tla + ", nonLocalizedCity=" + nonLocalizedCity + "]";
	}
}
