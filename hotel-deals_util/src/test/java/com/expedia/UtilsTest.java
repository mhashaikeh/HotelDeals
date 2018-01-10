package com.expedia;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.expedia.util.Utilities;
import com.expedia.util.beans.HTTPRespons;

public class UtilsTest {

	@Test
	public void testCheckDateFormat(){
		Assert.assertTrue(Utilities.checkDateFormat("2018-02-01"));
	}
	
	@Test
	public void testURLEncoding() {
		Assert.assertEquals(Utilities.URLEncoding("TEST JAVA"), "TEST+JAVA");
	}
	
	@Test
	public void testURLValidAndHTTPCall() {
		HTTPRespons httpRespons = Utilities.excuteGETHTTPCall_JSONResponse("https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&minTripStartDate=2018-01-09&maxTripStartDate=2018-01-10&lengthOfStay=7");
		Assert.assertEquals(httpRespons.getResponseCode(), 200);
	}
}
