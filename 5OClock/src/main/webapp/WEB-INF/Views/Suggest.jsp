<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suggestions</title>
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
</head>
<script>
	var counter = 1;
	var limit = 3;
	function addInput(divName) {

		if (counter == limit) {
			alert("you have reached the limit of adding deals")
		} else {

			var newdiv = document.createElement('div');
			newdiv.innerHTML = '<input id="dealType" placeholder="Deal\'s Type"> <input id="description" placeholder="Description"> <input id="price" placeholder="Price"> <input id="startTime" placeholder="Start Time"> <input id="endTime" placeholder="End Time"> ';
			document.getElementById(divName).appendChild(newdiv);
			counter++;

		}
	}
</script>
<body>
	<h4>Venue Suggestion</h4>
	<div>
		<form id="suggestForm" action="suggest" method="post">

			<input id="venueName" placeholder="venueName"> <input
				id="venueAddress" placeholder="venueAddress"> <input
				id="venuePhone" placeholder="venuePhone">

			<h4>Deals Suggestion</h4>

			<input id="dealType" placeholder="Deal's Type"> <input
				id="description" placeholder="Description"> <input
				id="price" placeholder="Price"> <input id="startTime"
				placeholder="Start Time"> <input id="endTime"
				placeholder="End Time"> <span id="submitGlyph"
				class="glyphicon glyphicon-plus-sign"
				onClick="addInput('nextDeal');"></span>
			<div id="nextDeal"></div>
			<input id="submit" type="submit" value="Get Happy">
		</form>

	</div>
</body>
<%-- <script src="<c:url value="/resources/Scripts/Suggest.js" />"></script> --%>
<script>
	document.getElementById("submit").addEventListener("click", submitFunc)

	function submitFunc() {

		document.getElementById("suggestForm").submit();

	}
</script>
</html>

