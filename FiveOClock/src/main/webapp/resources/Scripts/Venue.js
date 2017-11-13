address = document.getElementById("address").innerHTML;
address = address.substring(9);
console.log(address);
addressArr = address.split(" ");
urlString ="https://www.google.com/maps/dir/?api=1&destination="
for (j = 0; j < addressArr.length; j++) {
	if (j == addressArr.length - 1) {
		urlString = urlString + addressArr[j];
		break;
	}
	urlString = urlString + addressArr[j] + "+";
}
console.log(urlString);
document.getElementById("directionButton").setAttribute("href", urlString);