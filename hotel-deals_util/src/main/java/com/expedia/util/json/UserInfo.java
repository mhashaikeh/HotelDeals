package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
	
	@JsonProperty("persona")
	private Persona persona;
	
	@JsonProperty("userId")
	String userId;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserInfo [persona=" + persona + ", userId=" + userId + "]";
	}
}
