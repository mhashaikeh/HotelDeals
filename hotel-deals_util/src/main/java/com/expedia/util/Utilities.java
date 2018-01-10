package com.expedia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import com.expedia.util.beans.HTTPRespons;

public class Utilities {
	private static Logger log = Logger.getLogger(Utilities.class);
	
	public static final String dealsFinderURL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTripStartDate=#MIN_TRIP_START_DATE#&maxTripStartDate=#MAX_TRIP_START_DATE#&lengthOfStay=#LENGTH_OF_STAY#";

	public static ArrayList<String> cities = null;
	
	public static HTTPRespons excuteGETHTTPCall_JSONResponse(String targetURL) {
		
		log.debug("Calling the URL: " + targetURL);
		
		HTTPRespons httpRespons = null;
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
				
	        HttpGet get = new HttpGet(targetURL);
	        
	        get.setHeader("charset", "utf-8");
	        
	        
	        HttpResponse response = client.execute(get);
	        
	        int respCode = response.getStatusLine().getStatusCode();
	        log.debug("Response Code : " + respCode);
	        
	        httpRespons = new HTTPRespons();
	        httpRespons.setResponseCode(respCode);
	        
	        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	
	        StringBuilder result = new StringBuilder();
	        String line = "";
	        while ((line = rd.readLine()) != null) {
	            result.append(line);
	        }
	        rd.close();
	        httpRespons.setResult(result.toString());
	        
	        return httpRespons;
	        
       } catch (UnsupportedEncodingException ex) {
           log.debug("UnsupportedEncodingException: ", ex);
           return null;
       } catch (IOException ex) {
    	   log.debug("Post Request Error: ", ex);
           return null;

       }
	}
	
	public static String getCurrentDate(int plusDays) {
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, plusDays);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(cal.getTime());

		return date;
	}
	
	public static String getCurrentDateInMills(int plusDays) {
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, plusDays);
		
		return ""+cal.getTime().getTime();
	}
	
	public static String convertStringToDateMills(String date_string) {
		
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(date_string);
		} catch (ParseException e) {
			e.printStackTrace();
			return ""+Calendar.getInstance().getTime().getTime();
		}
		return ""+date.getTime(); 
	}
	
	public static boolean checkDateFormat(String date) {
		return date.matches("\\d{4}-\\d{2}-\\d{2}");
	}
	
	public static String URLEncoding(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}
}
