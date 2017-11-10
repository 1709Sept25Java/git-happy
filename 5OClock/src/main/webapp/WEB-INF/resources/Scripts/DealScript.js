/*document.getElementById("filterForm").addEventListener("change", filter)



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

	for (x in res) {

		dist = getDistance(res[x].venue.address);

		res[x].venue.distance = dist;

	}



	table = document.getElementById("dealTable");

	for (x in res) {

		// distCells = document.getElementsByClassName("distance-cell");

		// for (cell in distCells){

		// if (cell.innerHTML<res[x].venue.distance){

		// index = distCells.indexOf(cell);

		// }

		// }

		row = table.insertRow();

		typeCell = row.insertCell();

		typeCell.setAttribute("class", "type-cell");

		typeCell.innerHTML = res[x].type;

		priceCell = row.insertCell();

		priceCell.setAttribute("class", "price-cell");

		priceCell.innerHTML = "$" + res[x].price +"0";

		descriptionCell = row.insertCell();

		descriptionCell.setAttribute("class", "description-cell");

		descriptionCell.innerHTML = res[x].description;

		distanceCell = row.insertCell();

		distanceCell.setAttribute("class", "distance-cell");

		distanceCell.innerHTML = res[x].venue.distance;

//		 var link = document.createElement("a");

//		link.setAttribute("href", "../Venue/"+"x");

//		nameCell.appendChild(link);

	}

}



function getDistance(address) {

	address = address.replace(/,/g, "");

	addressArr = address.split(" ");

	addressQuery = "";

	for (y in addressArr) {

		if (y == addressArr.length - 1) {

			addressQuery = addressQuery + addressArr[y];

			break;

		}

		addressQuery = addressQuery + addressArr[y] + "+";

	}

	headingStr = document.getElementById("heading").innerHTML;

	origin = headingStr.substring(22);

	origin = origin.replace(/,/g, "");

	originArr = origin.split(" ");

	originQuery = "";

	for (z in originArr) {

		if (z == originArr.length - 1) {

			originQuery = originQuery + originArr[z];

			break;

		}

		originQuery = originQuery + originArr[z] + "+";

	}

	url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="

			+ originQuery + "&destinations=" + addressQuery

			+ "&key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&units=imperial";

	sendAjaxGet(url, getDistanceFromAPI);

}



function getDistanceFromAPI() {

	var ApiRes = xhr.responseText;

	ApiRes = JSON.parse(ApiRes);

	ApiDist = ApiRes.rows.elements.distance.text;



}



function filter(){

	console.log("weee check box changed!");

}*/