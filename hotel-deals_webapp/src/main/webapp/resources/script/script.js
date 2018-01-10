function openNav() {
    $('#sidenav').css("width", "30%");
}

function closeNav() {
    $('#sidenav').css("width", "0%");
}

function closeModel(){
	$('#HotelModal').css("display", "none");
}

function openModel(id){
	$('#HotelModal').css("display", "block");
	
	var json = $('#'+id).val();
	var hotel = JSON.parse(json); 
	
	var srats_percent = (hotel.hotelInfo.hotelStarRating * 100) / 5;
	$('#star_rating').css('width', srats_percent+'%');
	
	$('#hotel_name').html(hotel.hotelInfo.hotelName);
	$('#hotel_image').attr('src', hotel.hotelInfo.hotelImageUrl);
	$('#hotel_address').html(hotel.hotelInfo.hotelStreetAddress + ', ' + hotel.hotelInfo.hotelLongDestination);
	$('#hotel_guestreviewtotal').html(hotel.hotelInfo.hotelReviewTotal);
	$('#hotel_peopleviewed').html(hotel.hotelUrgencyInfo.numberOfPeopleViewing);
	$('#hotel_peoplebooked').html(hotel.hotelUrgencyInfo.numberOfPeopleBooked);
	$('#hotel_leftrooms').html(hotel.hotelUrgencyInfo.numberOfRoomsLeft);
	
	var srats_guest_percent = (hotel.hotelInfo.hotelGuestReviewRating * 100) / 5;
	$('#guest_rating').css('width', srats_guest_percent+'%');
	
	var date = new Date(hotel.hotelUrgencyInfo.lastBookedTime);
	$('#hotel_lastbooked').html(formatDate(date));
	
	reloadMap(hotel.hotelInfo.hotelLatitude, hotel.hotelInfo.hotelLongitude);
}

function reloadMap(latitude, longitude) {
	console.log('reloadMap......................');
	
	if(!latitude || !longitude){
		latitude = 0;
		longitude = 0;
	}
	
	console.log('latitude: ' + latitude);
	console.log('longitude: ' + longitude);
	
    var uluru = {lat: latitude, lng: longitude};
    
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: uluru
    });
    
    var marker = new google.maps.Marker({
      position: uluru,
      map: map
    });
}

function initMap() {
    var uluru = {lat: -25.363, lng: 131.044};
    
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 1,
      center: uluru
    });
}

function formatDate(date) {
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var ampm = hours >= 12 ? 'pm' : 'am';
	hours = hours % 12;
	hours = hours ? hours : 12; // the hour '0' should be '12'
	minutes = minutes < 10 ? '0'+minutes : minutes;
	var strTime = hours + ':' + minutes + ' ' + ampm;
	return date.getDate() + " - " + (date.getMonth()+1) + " - " + date.getFullYear() + " @ " + strTime;
}

function datePicking(element, date_in_mills){
	console.log('element: ' + element);
	
	var currentDate = new Date(date_in_mills);

    $("#"+element).datepicker({
        dateFormat: 'yy-mm-dd',
        minDate: 0,
        changeYear: true 
    }).attr('readonly', 'readonly');
    
    $("#"+element).datepicker('setDate', currentDate);

}

function setStarRating(element, rating_value) {
	$("#"+element).rateYo({
		rating: rating_value,
		fullStar: true,
		starWidth: "20px"
	  });
}

function resetForm(){
	$('#city').val("");
	
	var minDate = new Date();
	var maxDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
	$('#min_start_trip_date').val(minDate.getFullYear() + "-" + ("0" + (minDate.getMonth() + 1)).slice(-2) + "-" + ("0" + minDate.getDate()).slice(-2));
	$('#max_start_trip_date').val(maxDate.getFullYear() + "-" + ("0" + (maxDate.getMonth() + 1)).slice(-2) + "-" + ("0" + maxDate.getDate()).slice(-2));
	
	$('#length_of_stay').prop('selectedIndex', 6);

	$("#minStarRating_div").rateYo("option", "rating", "0");
	$("#maxStarRating_div").rateYo("option", "rating", "0");
	
	$("#minTotalRate_div").rateYo("option", "rating", "0");
	$("#maxTotalRate_div").rateYo("option", "rating", "0");
	
	$("#minGuestRating_div").rateYo("option", "rating", "0");
	$("#maxGuestRating_div").rateYo("option", "rating", "0");
}

function submitFilterForm(){
	var minStartDate = $('#min_start_trip_date').val();
	var maxStartDate = $('#max_start_trip_date').val();
	
	var minDate = new Date(minStartDate);
	var maxDate = new Date(maxStartDate);
	
	if(minDate.getTime() > maxDate.getTime()){
		$('#max_start_trip_date').val(minStartDate);
	}
	
	var minStarRating_value = $("#minStarRating_div").rateYo("option", "rating");
	var maxStarRating_value = $("#maxStarRating_div").rateYo("option", "rating");
	
	if(minStarRating_value > 0 && maxStarRating_value > 0){
		if(minStarRating_value > maxStarRating_value){
			$('#minStarRating').val(maxStarRating_value);
			$('#maxStarRating').val(minStarRating_value);
		}else{
			$('#minStarRating').val(minStarRating_value);
			$('#maxStarRating').val(maxStarRating_value);
		}
	}else{
		$('#minStarRating').val(minStarRating_value);
		$('#maxStarRating').val(maxStarRating_value);
	}
	
	var minTotalRate_value = $("#minTotalRate_div").rateYo("option", "rating");
	var maxTotalRate_value = $("#maxTotalRate_div").rateYo("option", "rating");
	
	if(minTotalRate_value > 0 && maxTotalRate_value > 0){
		if(minTotalRate_value > maxTotalRate_value){
			$('#minTotalRate').val(maxTotalRate_value);
			$('#maxTotalRate').val(minTotalRate_value);
		}else{
			$('#minTotalRate').val(minTotalRate_value);
			$('#maxTotalRate').val(maxTotalRate_value);
		}
	}else{
		$('#minTotalRate').val(minTotalRate_value);
		$('#maxTotalRate').val(maxTotalRate_value);
	}
	
	var minGuestRating_value = $("#minGuestRating_div").rateYo("option", "rating");
	var maxGuestRating_value = $("#maxGuestRating_div").rateYo("option", "rating");
	
	if(minGuestRating_value > 0 && maxGuestRating_value > 0){
		if(minGuestRating_value > maxGuestRating_value){
			$('#minGuestRating').val(maxGuestRating_value);
			$('#maxGuestRating').val(minGuestRating_value);
		}else{
			$('#minGuestRating').val(minGuestRating_value);
			$('#maxGuestRating').val(maxGuestRating_value);
		}
	}else{
		$('#minGuestRating').val(minGuestRating_value);
		$('#maxGuestRating').val(maxGuestRating_value);
	}
	
	
	$('#hotel_name').submit();
}



