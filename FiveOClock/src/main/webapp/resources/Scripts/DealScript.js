input = document.getElementById("timeInput");
var d = new Date();
currentTime = d.getHours() + ":" + d.getMinutes();
input.setAttribute("value", currentTime);
timeNum = " " + d.getHours() + d.getMinutes();
timeNum = timeNum.trim();

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
}

function postDeals(xhr) {
	// get response text, calculate the distance
	var res = xhr.responseText;
	res = res.substring(1, res.length - 1);
	res = "{" + res + "}";
	res = JSON.parse(res);
	table = document.getElementById("dealTable");
	for (x in res) {
		console.log(res[x].startTime);
		console.log(res[x].startTime);
		if (res[x].startTime < timeNum < res[x].startTime) {
			row = table.insertRow();
			row.addEventListener("click", function link() {
				window.location.href = "venue/" + x
			});
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
		} else {
			continue;
		}
	}
	setTimeout(sortDistances, 1000);
}

service = new google.maps.DistanceMatrixService();
function getDistance(destination) {
	count = 0;
	origin = document.getElementById("heading").innerHTML;
	origin = origin.substring(22);
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
		distanceCells = document.getElementsByClassName("distance-cell");
		distanceCells[count].innerHTML = response.rows[0].elements[0].distance.text
		if (count == distanceCells.length - 1) {
			return;
		}
		if (count > 1) {
			currentDistance = distanceCells[count].innerHTML;
			currentDistance = currentDistance.substring(0,
					currentDistance.length - 2);
			previousDistance = distanceCells[count - 1].innerHTML;
			previousDistance = previousDistance.substring(0,
					previousDistance.length - 2);
			if (currentDistance > previousDistance) {
				distanceCells[count].parentNode.parentNode.insertBefore(
						distanceCells[count].parentNode,
						distanceCells[count - 1].parentNode);
			}
		}
		count++;
	} else {
		alert("Error: " + status);
	}
}

// ////////////event listener and function to filter results by type///////////
document.getElementById("filterForm").addEventListener("change", filter);
function filter() {
	console.log("weee check box changed!");
	checkBoxes = document.getElementsByClassName("checkBox");
	for (i = 0; i < checkBoxes.length; i++) {
		if (!checkBoxes[i].checked) {
			type = checkBoxes[i].id;
			console.log(type);
			typeCells = document.getElementsByClassName("type-cell");
			for (j = 0; j < typeCells.length; j++) {
				console.log(typeCells[j].innerHTML);
				if (typeCells[j].innerHTML == type) {
					typeCells[j].parentNode.setAttribute("style",
							"display: none;");
				}
			}
		}
		if (checkBoxes[i].checked) {
			type = checkBoxes[i].id;
			console.log(type);
			typeCells = document.getElementsByClassName("type-cell");
			for (j = 0; j < typeCells.length; j++) {
				console.log(typeCells[j].innerHTML);
				if (typeCells[j].innerHTML == type) {
					typeCells[j].parentNode.removeAttribute("style");
				}
			}
		}
	}
}

function sortDistances() {
	distanceCells = document.getElementsByClassName("distance-cell");
	for (a = 0; a < distanceCells.length; a++) {
		for (z = 1; z < distanceCells.length; z++) {
			if (z == distanceCells.length) {
				return;
			}
			currentDistance = distanceCells[z].innerHTML;
			currentDistance = currentDistance.substring(0,
					currentDistance.length - 2);
			previousDistance = distanceCells[z - 1].innerHTML;
			previousDistance = previousDistance.substring(0,
					previousDistance.length - 2);
			if (currentDistance < previousDistance) {
				distanceCells[z].parentNode.parentNode.insertBefore(
						distanceCells[z].parentNode,
						distanceCells[z - 1].parentNode);
			}

		}
	}
}

// ////////////event listener and function to filter results by time///////////
document.getElementById("timeButton").addEventListener("click", changeTime);
function changeTime() {
	console.log("clicked");
	input = document.getElementById("timeInput");
	console.log(input.value);
}
