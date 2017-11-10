<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<form id="SearchForm" name="SearchForm" action="search" method="post">
		<input id="input" name="input" class="controls" type="text"
			placeholder="Enter location" style="width: 250px;">
		<button type="button" id="submit">GetHappy!</button>
	</form>
	<div id="map"></div>
</body>
<!-- <script> src="<c:url value="/resources/Scripts/Search.js" />"></script> -->
<script>
	function initMap() {
		var input = document.getElementById('input');
		var search = new google.maps.places.SearchBox(input);
		var autocomplete = new google.maps.places.Autocomplete(input);

		var infowindow = new google.maps.InfoWindow();
		var infowindowContent = document.getElementById('infowindow-content');
		autocomplete.addListener('place_changed', function() {
			infowindow.close();
			var place = autocomplete.getPlace();
			if (!place.geometry) {
				window.location = "/5OClock/search";
				window.alert("No details for'" + place.name + "'");
				window.location = "/5OClock/search";
				//return;
				
			} else {
				var submit = document.getElementById("submit");
				submit.addEventListener("click", function() {
					window.location = "/5OClock/home";
				});
			}
		});
	}
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&libraries=places&callback=initMap"
	async defer></script>

</html>