<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/Styles/Resolver.css" />">

</head>

<body>
	<div class="contentDiv">
		<h4>Venue Suggestion</h4>
		<div>

			<form id="suggestForm" action="suggest" method="post">

				<input name="venueName" placeholder="venueName"> <input
					name="venueAddress" placeholder="venueAddress"> <input
					name="venuePhone" placeholder="venuePhone">

				<h4>Deals Suggestion</h4>
							<div id="div1">
				<select name="dealType">
				<option value="Beer">Beer</option>
				<option value="Wine">Wine</option>
				<option value="Cocktails">Cocktails</option>
			</select> <input name="description" placeholder="Description"> <input
				name="price" type="number" placeholder="Price"> <input name="startTime" type="number"
				placeholder="Start Time (e.g. 1700 for 5pm)" class="timeInput"> <input name="endTime" type="number"
				placeholder="End Time (e.g. 1900 for 7pm)" class="timeInput"> <span id="submitGlyph"
				class="glyphicon glyphicon-plus-sign"
				onClick="addInput('nextDeal');"></span>
				<div id="nextDeal"></div>
			</div>
			
			<div id="div2" style="display: none;">
				<select name="dealType2">
				<option value="Beer">Beer</option>
				<option value="Wine">Wine</option>
				<option value="Cocktails">Cocktails</option>
			</select> <input name="description2" placeholder="Description"> <input
				name="price2" type="number" placeholder="Price"> <input name="startTime2" type="number"
				placeholder="Start Time (e.g. 1700 for 5pm)" class="timeInput"> <input name="endTime2" type="number"
				placeholder="End Time (e.g. 1900 for 7pm)" class="timeInput">

			</div>
			<div id="div3" style="display: none;">
				<select name="dealType3">
				<option value="Beer">Beer</option>
				<option value="Wine">Wine</option>
				<option value="Cocktails">Cocktails</option>
			</select> <input name="description3" placeholder="Description"> <input
				name="price3" type="number" placeholder="Price"> <input name="startTime3" type="number"
				placeholder="Start Time (e.g. 1700 for 5pm)" class="timeInput"> <input name="endTime3" type="number"
				placeholder="End Time (e.g. 1900 for 7pm)" class="timeInput">
			</div>			</form>
			<br> <br>
		</div>
		<button id="backButton">Back</button>
	</div>
	<script>
		document.getElementById("submitGlyph").addEventListener("click",
				addInput);
		var counter = 1;
		var limit = 4;
		function addInput() {
			console.log(document.getElementById("div1"));
			console.log(document.getElementById("div2"));
			console.log(document.getElementById("div3"));
			if (counter == limit) {
				alert("you have reached the limit of adding deals")
				console.log("working");
			} else {
				if (counter == 2) {
					document.getElementById("div2").removeAttribute("style");
					console.log("ok");
				} else if (counter == 3) {
					document.getElementById("div3").removeAttribute("style");
					console.log("ok2");
				}
				counter++;
				// 			var newdiv = document.createElement('div');
				// 			newdiv.innerHTML = '<input id="dealType" placeholder="Deal\'s Type"> <input id="description" placeholder="Description"> <input id="price" placeholder="Price"> <input id="startTime" placeholder="Start Time"> <input id="endTime" placeholder="End Time"> ';
				// 			document.getElementById(divName).appendChild(newdiv);
			}
		}
	</script>

</body>

</html>