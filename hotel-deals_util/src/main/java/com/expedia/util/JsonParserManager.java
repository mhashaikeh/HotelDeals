package com.expedia.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserManager<T> {

	private Class<T> type;
	private static Logger log = Logger.getLogger(JsonParserManager.class);

	public JsonParserManager(Class<T> type) {
		this.type = type;
	}

	public String parseObjectToJSON(T entity) throws IOException {
		log.debug("parse entity Object to json object");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(entity);
		return json;
	}

	public T parseJSONToObject(String json) throws IOException {
		log.debug("parse json object to entity Object");
		ObjectMapper mapper = new ObjectMapper();
		T entity = mapper.readValue(json, type);
		return entity;
	}

}
