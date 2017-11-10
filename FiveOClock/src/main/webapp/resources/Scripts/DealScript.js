document.getElementById("filterForm").addEventListener("change", filter)

window.onload = function() {
	sendAjaxGet('http://localhost:8082/FiveOClock/deals', print2console);
	sendAjaxGet('http://localhost:8082/FiveOClock/deals', postDeals);
}

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function print2console(xhr) {
	var res = xhr.responseText;
	res = res.substring(1, res.length - 1);
	res = "{" + res + "}";
	res = JSON.parse(res);
	console.log(res);
}

function postDeals(xhr) {
	// get response text, calculate the distance
	var res = xhr.responseText;
	res = res.substring(1, res.length - 1);
	res = "{" + res + "}";
	res = JSON.parse(res);
	table = document.getElementById("dealTable");
	for (x in res) {
		row = table.insertRow();
		typeCell = row.insertCell();
		typeCell.setAttribute("class", "type-cell");
		typeCell.innerHTML = res[x].type;
		priceCell = row.insertCell();
		priceCell.setAttribute("class", "price-cell");
		priceCell.innerHTML = "$" + res[x].price + "0";
		descriptionCell = row.insertCell();
		descriptionCell.setAttribute("class", "description-cell");
		descriptionCell.innerHTML = res[x].description;
		distanceCell = row.insertCell();
		distanceCell.setAttribute("class", "distance-cell");
		getDistance(res[x].venue.address);
	}
}


function getDistance(destination) {
	origin = document.getElementById();
	service.getDistanceMatrix({
		origins : [ origin ],
		destinations : [ destination ],
		travelMode : google.maps.TravelMode.DRIVING,
		avoidHighways : false,
		avoidTolls : false,
		unitSystem : google.maps.UnitSystem.IMPERIAL
	}, callback);
}
function callback(response, status) {
	if (status == "OK") {
		console.log(response.rows[0].elements[0].distance.text);
	} else {
		alert("Error: " + status);
	}
}

function filter() {
	console.log("weee check box changed!");
}
// TODO: create function to set all rows with class for type not checked
// display:none
// when they are rechecked they reappear
