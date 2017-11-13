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

<style>
body {
	background:
		url("https://wallpaperclicker.com/storage/wallpaper/Beer-Fest-55846404.jpg")
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	
}
#box{
top: 300px;
	padding : 20px;
	padding-bottom : 45px;
	border-radius : 20px;
	
align:center;
}

</style>

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
<div id="box" style="width:1000px; margin:0 auto;">
	<h3 style="color:#F1D744;">Venue Suggestion</h3>
	
		<form id="suggestForm" action="suggest" method="post">

			<input id="venueName" placeholder="venueName"> <input
				id="venueAddress" placeholder="venueAddress"> <input
				id="venuePhone" placeholder="venuePhone">

			<h3 style="color:#F1D744;">Deals Suggestion</h3>

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

</html>

