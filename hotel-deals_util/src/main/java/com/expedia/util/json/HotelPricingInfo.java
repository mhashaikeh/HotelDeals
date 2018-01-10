package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelPricingInfo {
	
	@JsonProperty("averagePriceValue")
	private Double averagePriceValue;
	
	@JsonProperty("totalPriceValue")
	private Double totalPriceValue;
	
	@JsonProperty("crossOutPriceValue")
	private Double crossOutPriceValue;
	
	@JsonProperty("originalPricePerNight")
	private Double originalPricePerNight;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("percentSavings")
	private Double percentSavings;
	
	@JsonProperty("drr")
	private Boolean drr;

	public Double getAveragePriceValue() {
		return averagePriceValue;
	}

	public void setAveragePriceValue(Double averagePriceValue) {
		this.averagePriceValue = averagePriceValue;
	}

	public Double getTotalPriceValue() {
		return totalPriceValue;
	}

	public void setTotalPriceValue(Double totalPriceValue) {
		this.totalPriceValue = totalPriceValue;
	}

	public Double getCrossOutPriceValue() {
		return crossOutPriceValue;
	}

	public void setCrossOutPriceValue(Double crossOutPriceValue) {
		this.crossOutPriceValue = crossOutPriceValue;
	}

	public Double getOriginalPricePerNight() {
		return originalPricePerNight;
	}

	public void setOriginalPricePerNight(Double originalPricePerNight) {
		this.originalPricePerNight = originalPricePerNight;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPercentSavings() {
		return percentSavings;
	}

	public void setPercentSavings(Double percentSavings) {
		this.percentSavings = percentSavings;
	}

	public Boolean getDrr() {
		return drr;
	}

	public void setDrr(Boolean drr) {
		this.drr = drr;
	}

	@Override
	public String toString() {
		return "HotelPricingInfo [averagePriceValue=" + averagePriceValue + ", totalPriceValue=" + totalPriceValue
				+ ", crossOutPriceValue=" + crossOutPriceValue + ", originalPricePerNight=" + originalPricePerNight
				+ ", currency=" + currency + ", percentSavings=" + percentSavings + ", drr=" + drr + "]";
	}
}
