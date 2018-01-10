package com.expedia.util.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferDateRange {

	@JsonProperty("travelStartDate")
	private List<Integer> travelStartDate;
	
	@JsonProperty("travelEndDate")
	private List<Integer> travelEndDate;
	
	@JsonProperty("lengthOfStay")
	private int lengthOfStay;

	public List<Integer> getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(List<Integer> travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	public List<Integer> getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(List<Integer> travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	@Override
	public String toString() {
		return "OfferDateRange [travelStartDate=" + travelStartDate + ", travelEndDate=" + travelEndDate
				+ ", lengthOfStay=" + lengthOfStay + "]";
	}
}
