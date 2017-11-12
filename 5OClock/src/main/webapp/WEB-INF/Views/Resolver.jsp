<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<style>
#resolverdiv {
	border: 5px, black;
}
</style>
<body>
	<form method="get" action="resolver">
		<div id="resolverdiv" class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<table id="resolverTable" style="width: 100%">
				<tr>
					<th class="dealIdRow">Deal Id</th>
					<th class="typeRow">Type</th>
					<th class="descriptionRow">Description</th>
					<th class="priceRow">Price</th>
					<th class="startTimeRow">Start Time</th>
					<th class="endTimeRow">End Time</th>
					<th class="statusRow">Status</th>
					<th class="venueNameRow">Venue</th>
					<th class="venueAddressRow">Address</th>
				<tr>
			</table>
		</div>

		<input name="dealId" placeholder="dealID"> <input
			type="submit" name=approve value="approve"> <input
			name="deal" placeholder="dealID"> <input type="submit"
			name="action" value="deny">
	</form>
</body>
<script type="text/javascript">
	window.onload = function() {
		sendAJAX("http://localhost:8082/FiveOClock/resolvers", getResolved);
	}
	function sendAJAX(url, func) {
		var xhr = new XMLHttpRequest()
				|| new ActiveXObject("Microsoft.HTTPRequest");
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				func(this);
			}
		};
		xhr.open("GET", url, true);
		xhr.send();
	}
	function getResolved(xhr) {
		var res = xhr.responseText;
		res = res.substring(1, res.length - 1);
		res = "{" + res + "}";
		//console.log("working");
		res = JSON.parse(res);
		table = document.getElementById("resolverTable");
		console.log("got data");
		for (x in res) {
			table.innerHTML += "<tr><td>" + res[x].dealId + "</td><td>"
					+ res[x].type + "</td><td>" + res[x].description
					+ "</td><td>" + res[x].price + "</td><td>"
					+ res[x].startTime + "</td><td>" + res[x].endTime
					+ "</td><td>" + res[x].status + "</td><td>"
					+ res[x].venue.venueName + "</td><td>"
					+ res[x].venue.address + "</td></tr>";
		}
	}
</script>


</html>