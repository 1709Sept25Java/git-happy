function initMap() {
	var input = document.getElementById('input');
	var search = new google.maps.places.SearchBox(input);
	var autocomplete = new google.maps.places.Autocomplete(input);

	var infowindow = new google.maps.InfoWindow();
	var infowindowContent = document.getElementById('infowindow-content');
	infowindow.setContent(infowindowContent);
	var marker = new google.maps.Marker({
		map : map,
		anchorPoint : new google.maps.Point(0, -29)
	});
	autocomplete.addListener('place_changed', function() {
		infowindow.close();
		var place = autocomplete.getPlace();
		if (!place.geometry) {
			window.alert("No details available for input: '" + place.name
							+ "'");
			return;
		}
	});
}