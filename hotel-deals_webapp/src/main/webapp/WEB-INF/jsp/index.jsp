<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.expedia.util.json.HotelOffers"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="resources/css/general_style.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="resources/css/jquery.rateyo.min.css">
	<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="resources/script/jquery.rateyo.min.js"></script>
	<script src="resources/script/script.js"></script>
</head>
<body style="background: url('resources/images/bg.png') no-repeat top left; background-size: 100% 100%; width: 100%; height: auto !important; min-height: 100%;">

	<div id="HotelModal" class="modal">
	  <span class="close" onclick="closeModel();">&times;</span>
	  
	  <div class="modal_scroll_inside">
	  	
	  	<font size="5" color="white"><p id="hotel_name"></p></font>
	  	<img id="hotel_image" src="" style="width: 25%;" />
	  	<div class="star-ratings-sprite"><span id="star_rating" style="" class="star-ratings-sprite-rating"></span></div>
		
		<div style="width: 100%; text-align: center;">
			<div class="popup_hotel_details">
				<p class="popup_hotel_details_title">Address</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_address"></p></font>
				
				<p class="popup_hotel_details_title">Guest rating</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<div class="star-ratings-sprite" style="margin-left: 3px; margin-top: 10px;"><span id="guest_rating" style="" class="star-ratings-sprite-rating"></span></div>
				
				<p class="popup_hotel_details_title">Guest review rating total</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_guestreviewtotal"></p></font>
				
				<p class="popup_hotel_details_title">Number of people viewed</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_peopleviewed"></p></font>
				
				<p class="popup_hotel_details_title">Number of people booked</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_peoplebooked"></p></font>
				
				<p class="popup_hotel_details_title">Left Rooms</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_leftrooms"></p></font>
				
				<p class="popup_hotel_details_title">Last booked Date/Time</p></font>
				<p class="popup_hotel_details_title">: </p></font>
				<p class="popup_hotel_details_title" id="hotel_lastbooked"></p></font>
			</div>
		</div>
		
		<div id="map" class="map" ></div>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
	  </div>
	</div>
	
		
	<span style="font-size:30px; color: #0000FFFF; margin-left: 2px; cursor:pointer" onclick="openNav()">&#9776;</span>
	
	<section id="sidenav" class="sidenav">
		<form action="home" method="post" id="filter_form" name="filter_form">
		<div class="sideOpenIcon" onclick="closeNav()">
			&times;
		</div>
		
		<div class="side_menu_divs" style="margin-top: -10%;">
			<p class="side_menu_titles">City</p>
			<input list="cities" name="city" id="city" value="${city}" style="border-radius: 5px; margin-top: 2px;" >
			<datalist id="cities">
				<c:forEach items="${cities}" var="city_name">
					<option value="${city_name}">
				</c:forEach>
			</datalist>
		</div>
	
		<div class="side_menu_divs">
			<p class="side_menu_titles">Min Trip Start Date</p>
			<input type="text" id="min_start_trip_date" name="min_start_trip_date" class="date_picker" maxlength="10" size="10" value="2018-01-08" >
			<script type="text/javascript">datePicking('min_start_trip_date', ${min_start_trip_date_mills});</script>
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Max Trip Start Date</p>
			<input type="text" id="max_start_trip_date" name="max_start_trip_date" class="date_picker" maxlength="10" size="10" value="2018-01-08" >
			<script type="text/javascript">datePicking('max_start_trip_date', ${max_start_trip_date_mills});</script>
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">No. Of Days To Stay</p>
			<select name="length_of_stay" id="length_of_stay" style="margin-top: 2px; width: 80%; border-radius: 5px;">
				<c:forEach var = "i" begin = "1" end = "60">
  					<option value="${i}" <c:if test="${i == lengthOfStay}">selected="selected"</c:if> >${i}</option>
  				</c:forEach>
			</select>
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Min Star Rating</p>
			<div id="minStarRating_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('minStarRating_div', ${minStarRating});</script>
			<input type="hidden" name="minStarRating" id="minStarRating" value="${minStarRating}" />
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Max Star Rating</p>
			<div id="maxStarRating_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('maxStarRating_div', ${maxStarRating});</script>
			<input type="hidden" name="maxStarRating" id="maxStarRating" value="${maxStarRating}" />
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Min Total Rate</p>
			<div id="minTotalRate_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('minTotalRate_div', ${minTotalRate});</script>
			<input type="hidden" name="minTotalRate" id="minTotalRate" value="${minTotalRate}" />
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Max Total Rate</p>
			<div id="maxTotalRate_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('maxTotalRate_div', ${maxTotalRate});</script>
			<input type="hidden" name="maxTotalRate" id="maxTotalRate" value="${maxTotalRate}" />
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Min Guest Rating</p>
			<div id="minGuestRating_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('minGuestRating_div', ${minGuestRating});</script>
			<input type="hidden" name="minGuestRating" id="minGuestRating" value="${minGuestRating}" />
		</div>
		
		<div class="side_menu_divs">
			<p class="side_menu_titles">Max Guest Rating</p>
			<div id="maxGuestRating_div" style="display: inline-block;"></div>
			<script type="text/javascript">setStarRating('maxGuestRating_div', ${maxGuestRating});</script>
			<input type="hidden" name="maxGuestRating" id="maxGuestRating" value="${maxGuestRating}" />
		</div>
		
		<div style="padding-top: 10px; text-align: center;">
			<img src="resources/images/reset.png" style="cursor: pointer; margin-right: 3%;" width="40" height="40" onclick="resetForm()" />
			<input type="image" src="resources/images/search.png" style="cursor: pointer;" width="40" height="40" onclick="submitFilterForm()" />
		</div>
		</form>
	</section>
	
	<section class="scroll_section">
		<div class="wrapper">
			<c:forEach items="${HotelOffers.offers.hotel}" var="hotel">

				<div class="row_hotel" style="background-color: #FFFFFF99;">
					<img src="${hotel.hotelInfo.hotelImageUrl}" style="width: 80%; border-radius: 5px;" />
					<div class="hotel_inline_details">
						<div class="star-ratings-sprite"><span style="width:${hotel.hotelInfo.getHotelStarRatingPercent()}%" class="star-ratings-sprite-rating"></span></div>
						<p><font size="4" color="black">${hotel.hotelInfo.hotelName}</font></p>
						<p><font size="2" color="black">${hotel.hotelInfo.hotelLongDestination}</font></p>
						<p><font size="1" color="black">Left Rooms: ${hotel.hotelUrgencyInfo.numberOfRoomsLeft}</font></p>
					</div>
					<div style="display: inline;">
						<input type="hidden" id="hidden_${hotel.hotelInfo.hotelId}" value='${HotelOffers.getHotelAsJSON(hotel)}' />
						<p style="cursor: pointer;" onclick="openModel('hidden_${hotel.hotelInfo.hotelId}');"><font size="5" color="black">&gt;&gt;</font></p>
						
					</div>
					
					<div>
					<a href="${hotel.hotelUrls.hotelInfositeUrl}" target="_blank" ><font size="1">Hotel Info</font></a>
					<br />
					<a href="${hotel.hotelUrls.hotelSearchResultUrl}" target="_blank" ><font size="1">Expedia Search</font></a>
					</div>
					
					<div>${hotel.hotelPricingInfo.crossOutPriceValue}  ${hotel.hotelPricingInfo.currency}</div>
				</div>

			</c:forEach>
		</div>
	</section>

	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASoveeS53TVaY1Xmr_I4R2XHAHTEZHiIk&callback=initMap">
    </script>
</body>
</html>
