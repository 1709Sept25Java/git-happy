<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/Styles/Resolver.css" />">
</head>
<style>
#resolverdiv {
	border: 5px, black;
}
</style>
<body>
	<div class="contentDiv">
		<form method="post" action="resolver">
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
				<br>
			</div>
			<input name="dealId" placeholder="dealID"> <input
				type="submit" name=approve value="approve"
				class="btn btn-primary btn-sm active"
				style="background-color: #342017; display: inline;"> <input
				name="deal" placeholder="dealID"> <input type="submit"
				name="action" value="deny" class="btn btn-primary btn-sm active"
				style="background-color: #342017; display: inline;">
		</form>
		<br>
		<div style="text-align: center;">
			<a href="search"><button class="btn btn-primary btn-sm active"
					style="background-color: #342017;">Return to Search</button></a>
		</div>
	</div>
</body>
<script type="text/javascript">
	window.onload = function() {
		sendAjaxGet('http://localhost:8082/FiveOClock/deals', getResolved);
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
			console.log(res[x]);
			if (res[x].status == "pending") {
				table.innerHTML += "<tr><td>" + x + "</td><td>" + res[x].type
						+ "</td><td>" + res[x].description + "</td><td>"
						+ res[x].price + "</td><td>" + res[x].startTime
						+ "</td><td>" + res[x].endTime + "</td><td>"
						+ res[x].status + "</td><td>" + res[x].venue.venueName
						+ "</td><td>" + res[x].venue.address + "</td></tr>";
			}
		}
	}
</script>


</html>