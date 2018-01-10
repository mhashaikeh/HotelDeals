package com.expedia.webapps.controllers;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expedia.util.JsonParserManager;
import com.expedia.util.Utilities;
import com.expedia.util.beans.HTTPRespons;
import com.expedia.util.json.HotelOffers;

@Controller
public class HomeController {

	private static Logger log = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value="/home", method = { RequestMethod.GET, RequestMethod.POST})
	public String HomeHandler(HttpServletRequest request, HttpServletResponse response) {
		String requesterIP = request.getRemoteAddr();
        
        log.debug("requester IP : " + requesterIP);
        
        log.debug("Request Encoding:" + request.getCharacterEncoding());
		log.debug("Request Content Type:" + request.getContentType());
		
		printParameters(log, request);
		printHeaders(log, request);
		
		String min_start_trip_date = request.getParameter("min_start_trip_date");
		log.debug("min_start_trip_date: " + min_start_trip_date);
		String min_start_trip_date_mills = "";
		
		if(min_start_trip_date == null || min_start_trip_date.trim().equals("")) {
			min_start_trip_date = Utilities.getCurrentDate(0);
			min_start_trip_date_mills = Utilities.getCurrentDateInMills(0);
		}else {
			if(!Utilities.checkDateFormat(min_start_trip_date)) {
				min_start_trip_date = Utilities.getCurrentDate(0);
				min_start_trip_date_mills = Utilities.getCurrentDateInMills(0);
			}else {
				min_start_trip_date_mills = Utilities.convertStringToDateMills(min_start_trip_date);
			}
		}
		
		String max_start_trip_date = request.getParameter("max_start_trip_date");
		log.debug("max_start_trip_date: " + max_start_trip_date);
		String max_start_trip_date_mills = "";
		if(max_start_trip_date == null || max_start_trip_date.trim().equals("")) {
			max_start_trip_date = Utilities.getCurrentDate(1);
			max_start_trip_date_mills = Utilities.getCurrentDateInMills(1);
		}else {
			if(!Utilities.checkDateFormat(max_start_trip_date)) {
				max_start_trip_date = Utilities.getCurrentDate(1);
				max_start_trip_date_mills = Utilities.getCurrentDateInMills(1);
			}else {
				max_start_trip_date_mills = Utilities.convertStringToDateMills(max_start_trip_date);
			}
		}
		
		int lengthOfStay;
		
		try {
			lengthOfStay = Integer.parseInt(request.getParameter("length_of_stay"));
		}catch(Exception ex) {
			lengthOfStay = 7;
		}
		
		String url = Utilities.dealsFinderURL;
		
		url = url.replace("#MIN_TRIP_START_DATE#", min_start_trip_date);
		url = url.replace("#MAX_TRIP_START_DATE#", max_start_trip_date);
		url = url.replace("#LENGTH_OF_STAY#", ""+lengthOfStay);
		
		int minStarRating;
		try {
			minStarRating = Integer.parseInt(request.getParameter("minStarRating"));
		}catch(Exception ex) {
			minStarRating = 0;
		}
		log.debug("minStarRating: " + minStarRating);
		
		if(minStarRating > 0) {
			url += "&minStarRating="+minStarRating;
		}
		
		int maxStarRating;
		try {
			maxStarRating = Integer.parseInt(request.getParameter("maxStarRating"));
		}catch(Exception ex) {
			maxStarRating = 0;
		}
		log.debug("maxStarRating: " + maxStarRating);
		
		if(maxStarRating > 0) {
			url += "&maxStarRating="+maxStarRating;
		}
		
		int minTotalRate;
		try {
			minTotalRate = Integer.parseInt(request.getParameter("minTotalRate"));
		}catch(Exception ex) {
			minTotalRate = 0;
		}
		log.debug("minTotalRate: " + minTotalRate);
		
		if(minTotalRate > 0) {
			url += "&minTotalRate="+minTotalRate;
		}
		
		int maxTotalRate;
		try {
			maxTotalRate = Integer.parseInt(request.getParameter("maxTotalRate"));
		}catch(Exception ex) {
			maxTotalRate = 0;
		}
		log.debug("maxTotalRate: " + maxTotalRate);
		
		if(maxTotalRate > 0) {
			url += "&maxTotalRate="+maxTotalRate;
		}
		
		int minGuestRating;
		try {
			minGuestRating = Integer.parseInt(request.getParameter("minGuestRating"));
		}catch(Exception ex) {
			minGuestRating = 0;
		}
		log.debug("minGuestRating: " + minGuestRating);
		
		if(minGuestRating > 0) {
			url += "&minGuestRating="+minGuestRating;
		}
		
		int maxGuestRating;
		try {
			maxGuestRating = Integer.parseInt(request.getParameter("maxGuestRating"));
		}catch(Exception ex) {
			maxGuestRating = 0;
		}
		log.debug("maxGuestRating: " + maxGuestRating);
		
		if(maxGuestRating > 0) {
			url += "&maxGuestRating="+maxGuestRating;
		}
		
		String city = request.getParameter("city");
		if(city != null && !city.isEmpty()) {
			String city_name = city;
			if(city_name.indexOf(',') != -1) {
				city_name = city_name.substring(0, city_name.indexOf(','));
			}
			
			city_name = Utilities.URLEncoding(city_name);
			
			url += "&destinationCity="+city_name;
		}else {
			city = "";
		}
		
		
//		&destinationCity=#DISTANATION_CITY#&minGuestRating=#MIN_GUEST_RATING#&maxGuestRating=#MAX_GUEST_RATING#
//		
//		url = url.replace("#DISTANATION_CITY#", "");
//		url = url.replace("#MIN_STAR_RATING#", "");
//		url = url.replace("#MAX_STAR_RATING#", "");
//		url = url.replace("#MIN_TOTAL_RATING#", "");
//		url = url.replace("#MAX_TOTAL_RATING#", "");
//		url = url.replace("#MIN_GUEST_RATING#", "");
//		url = url.replace("#MAX_GUEST_RATING#", "");
		
		HTTPRespons httpRespons = Utilities.excuteGETHTTPCall_JSONResponse(url);
		
		if(httpRespons == null) {
			return "error";
		}
		
		if(httpRespons.getResponseCode() == 200) {
			JsonParserManager<HotelOffers> manager = new JsonParserManager<HotelOffers>(HotelOffers.class);
			
			HotelOffers hotelOffers = null;
			
			try {
				hotelOffers = manager.parseJSONToObject(httpRespons.getResult());
			} catch (IOException ex) {
				log.error("Error parsing CheckStatus JSON", ex);
				return "error";
			}
			
			request.setAttribute("cities", Utilities.cities);
			request.setAttribute("city", city);
			
			log.debug("Received JSON After Parsing: \n" + hotelOffers.toString());
			request.setAttribute("HotelOffers", hotelOffers);
			
			request.setAttribute("min_start_trip_date", min_start_trip_date);
			request.setAttribute("min_start_trip_date_mills", min_start_trip_date_mills);
			request.setAttribute("max_start_trip_date", max_start_trip_date);
			request.setAttribute("max_start_trip_date_mills", max_start_trip_date_mills);
			request.setAttribute("lengthOfStay", lengthOfStay);
			request.setAttribute("minStarRating", minStarRating);
			request.setAttribute("maxStarRating", maxStarRating);
			request.setAttribute("minTotalRate", minTotalRate);
			request.setAttribute("maxTotalRate", maxTotalRate);
			request.setAttribute("minGuestRating", minGuestRating);
			request.setAttribute("maxGuestRating", maxGuestRating);
			
			return "index";
			
		}else {
			return "error";
		}
	}
	
	public void printParameters(Logger log, HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			log.debug("Param Name: " + paramName);
			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				log.debug("\tParamValue: " + paramValue);
			}
		}	
	}
	
	public void printHeaders(Logger log, HttpServletRequest request) {
		Enumeration<String> parameterNames = request.getHeaderNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			log.debug("Header Name: " + paramName);
			log.debug("\tHeader Value: " + request.getHeader(paramName));
		}	
	}
}
