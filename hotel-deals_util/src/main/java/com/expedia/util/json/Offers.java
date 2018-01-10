package com.expedia.util.json;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Offers {
	
	@JsonProperty("Hotel")
	private ArrayList<Hotel> hotel;

	public ArrayList<Hotel> getHotel() {
		return hotel;
	}

	public void setHotel(ArrayList<Hotel> hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Offers [hotel=" + hotel + "]";
	}
}
