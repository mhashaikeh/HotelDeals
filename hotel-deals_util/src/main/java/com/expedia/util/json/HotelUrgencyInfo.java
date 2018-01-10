package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelUrgencyInfo {
	@JsonProperty("airAttachRemainingTime")
	private Integer airAttachRemainingTime;
	
	@JsonProperty("numberOfPeopleViewing")
	private Integer numberOfPeopleViewing;
	
	@JsonProperty("numberOfPeopleBooked")
	private Integer numberOfPeopleBooked;
	
	@JsonProperty("numberOfRoomsLeft")
	private Integer numberOfRoomsLeft;
	
	@JsonProperty("lastBookedTime")
	private Long lastBookedTime;
	
	@JsonProperty("almostSoldStatus")
	private String almostSoldStatus;
	
	@JsonProperty("link")
	private String link;
	
	@JsonProperty("airAttachEnabled")
	private Boolean airAttachEnabled;

	public Integer getAirAttachRemainingTime() {
		return airAttachRemainingTime;
	}

	public void setAirAttachRemainingTime(Integer airAttachRemainingTime) {
		this.airAttachRemainingTime = airAttachRemainingTime;
	}

	public Integer getNumberOfPeopleViewing() {
		return numberOfPeopleViewing;
	}

	public void setNumberOfPeopleViewing(Integer numberOfPeopleViewing) {
		this.numberOfPeopleViewing = numberOfPeopleViewing;
	}

	public Integer getNumberOfPeopleBooked() {
		return numberOfPeopleBooked;
	}

	public void setNumberOfPeopleBooked(Integer numberOfPeopleBooked) {
		this.numberOfPeopleBooked = numberOfPeopleBooked;
	}

	public Integer getNumberOfRoomsLeft() {
		return numberOfRoomsLeft;
	}

	public void setNumberOfRoomsLeft(Integer numberOfRoomsLeft) {
		this.numberOfRoomsLeft = numberOfRoomsLeft;
	}

	public Long getLastBookedTime() {
		return lastBookedTime;
	}

	public void setLastBookedTime(Long lastBookedTime) {
		this.lastBookedTime = lastBookedTime;
	}

	public String getAlmostSoldStatus() {
		return almostSoldStatus;
	}

	public void setAlmostSoldStatus(String almostSoldStatus) {
		this.almostSoldStatus = almostSoldStatus;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getAirAttachEnabled() {
		return airAttachEnabled;
	}

	public void setAirAttachEnabled(Boolean airAttachEnabled) {
		this.airAttachEnabled = airAttachEnabled;
	}

	@Override
	public String toString() {
		return "HotelUrgencyInfo [airAttachRemainingTime=" + airAttachRemainingTime + ", numberOfPeopleViewing="
				+ numberOfPeopleViewing + ", numberOfPeopleBooked=" + numberOfPeopleBooked + ", numberOfRoomsLeft="
				+ numberOfRoomsLeft + ", lastBookedTime=" + lastBookedTime + ", almostSoldStatus=" + almostSoldStatus
				+ ", link=" + link + ", airAttachEnabled=" + airAttachEnabled + "]";
	}
}
