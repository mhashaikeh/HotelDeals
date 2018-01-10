package com.expedia.util.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {

	@JsonProperty("personaType")
	private String personaType;

	public String getPersonaType() {
		return personaType;
	}

	public void setPersonaType(String personaType) {
		this.personaType = personaType;
	}

	@Override
	public String toString() {
		return "Persona [personaType=" + personaType + "]";
	}
}
