input = document.getElementById("timeInput");
var d = new Date();
minutes = d.getMinutes();
minutes = minutes + " ";
if (minutes.length - 1 == 1) {
	minutes = " " + 0 + minutes;
	minutes = minutes.trim();
}
currentTime = d.getHours() + ":" + minutes;
input.setAttribute("value", currentTime);
timeNum = " " + d.getHours() + minutes;
timeNum = timeNum.trim();
timeNum = 1700;

window.onload = function() {
	sendAjaxGet('http://localhost:8082/FiveOClock/deals', postDeals, timeNum);
}

function sendAjaxGet(url, func, arg) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this, arg);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

count = 0;
var numberOfRows = 0;
function postDeals(xhr, time) {
	// get response text, calculate the distance
	var res = xhr.responseText;
	res = res.substring(1, res.length - 1);
	res = "{" + res + "}";
	res = JSON.parse(res);
	table = document.getElementById("dealTable");
	oldRows = document.getElementsByClassName("table-rows");
	// for(r=0;r<oldRows.length;r++){
	// oldRows[r].remove();
	// }
	for (x in res) {
		if (res[x].status == "published") {
			if (res[x].startTime < 1600 && 1600 < res[x].endTime) {
				count = count + 1;
				row = table.insertRow();
				row.setAttribute("class", "table-rows");
				row.addEventListener("click", venuePage);
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
				venueCell = row.insertCell();
				venueCell.setAttribute("class", "venue-cell");
				venueCell.setAttribute("value", res[x].venue.venueId);
				numberOfRows++;
			}
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
		if (count == distanceCells.length) {
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
	checkBoxes = document.getElementsByClassName("checkBox");
	for (i = 0; i < checkBoxes.length; i++) {
		if (!checkBoxes[i].checked) {
			type = checkBoxes[i].id;
			typeCells = document.getElementsByClassName("type-cell");
			for (j = 0; j < typeCells.length; j++) {
				if (typeCells[j].innerHTML == type) {
					typeCells[j].parentNode.setAttribute("style",
							"display: none;");
				}
			}
		}
		if (checkBoxes[i].checked) {
			type = checkBoxes[i].id;
			typeCells = document.getElementsByClassName("type-cell");
			for (j = 0; j < typeCells.length; j++) {
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
	// for(x = 0; x < distanceCells.length; x++){
	// str = distanceCells[x].innerHTML;
	// str = "x" +str;
	// if(str.length<7){
	// console.log(distanceCells[x].parentNode.parentNode.parentNode);
	// //distanceCells[x].parentNode.parentNode.parentNode.deleteRow(x);
	// }
	// }
}

// ////////////event listener and function to filter results by time///////////
document.getElementById("timeButton").addEventListener("click", changeTime);
function changeTime() {
	input = document.getElementById("timeInput");
	timeInput = input.value
	newTime = "" + timeInput.substring(0, 2) + timeInput.substring(3, 5);
	console.log(newTime);
	oldRows = document.getElementsByTagName("tr");
	sendAjaxGet('http://localhost:8082/FiveOClock/deals', postDeals2, newTime);
}

// ///////// redirects page based on venue Id saved in a hidden table row/////
function venuePage() {
	console.log(event.target);
	venueIdCell = event.target.parentNode.lastChild;
	window.location.href = "venue/" + venueIdCell.getAttribute("value");
}

function postDeals2(xhr, time) {
	// get response text, calculate the distance
	console.log(time);
	var res = xhr.responseText;
	res = res.substring(1, res.length - 1);
	res = "{" + res + "}";
	res = JSON.parse(res);
	table = document.getElementById("dealTable");
	tableRows = table.getElementsByTagName("tr");
	for (m = 1; m < tableRows.length - 3; m++) {
		table.deleteRow(m);
	}
	//	
	// for (x in res) {
	// if (res[x].startTime < time && time < res[x].endTime) {
	// count = count+1;
	// row = table.insertRow();
	// row.setAttribute("class","table-rows");
	// row.addEventListener("click", venuePage);
	// typeCell = row.insertCell();
	// typeCell.setAttribute("class", "type-cell");
	// typeCell.innerHTML = res[x].type;
	// priceCell = row.insertCell();
	// priceCell.setAttribute("class", "price-cell");
	// priceCell.innerHTML = "$" + res[x].price + "0";
	// descriptionCell = row.insertCell();
	// descriptionCell.setAttribute("class", "description-cell");
	// descriptionCell.innerHTML = res[x].description;
	// distanceCell = row.insertCell();
	// distanceCell.setAttribute("class", "distance-cell");
	// getDistance(res[x].venue.address);
	// venueCell = row.insertCell();
	// venueCell.setAttribute("class", "venue-cell");
	// venueCell.setAttribute("value", res[x].venue.venueId);
	// } else {
	// continue;
	// }
	// }

	// retrutn here
	// allRows = document.getElementsByTagName("tr");
	// console.log(allRows[numberOfRows]);
	// console.log(numberOfRows);
	// for(n=numberOfRows-1; n<allRows.length;n++){
	// //table.deleteRow(n);
	// allRows[n].remove;
	// }
	// allRows = document.getElementsByTagName("tr");
	// console.log(allRows[numberOfRows]);
	// console.log(numberOfRows);
	// for(n=numberOfRows-1; n<allRows.length;n++){
	// //table.deleteRow(n);
	// allRows[n].remove;
	// }
	// setTimeout(sortDistances, 1000);
}

document.getElementById("suggestLink").addEventListener("click", goToSuggest);

function goToSuggest() {
	window.location.href = "suggest";
}