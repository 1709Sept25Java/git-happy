<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>


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
	href="<c:url value="/resources/Styles/Search.css" />">


</head>
<body>
<div id="logoutButton"><a href="logout"><button class="btn">Log Out</button></a></div>
<div id=contentDiv>
<h4>Where are you looking for happy hour deals?</h4>
	<form action="search" method="POST">
		<input id="input" name="input" class="controls" type="text"
			placeholder="Enter location" style="width: 250px;"> <input
			type="submit" value="Get Happy!" id="submit">
	</form>
	<div id="map"></div>
</div>

</body>
<script src="<c:url value="/resources/Scripts/Search.js" />"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&libraries=places&callback=initMap"async defer></script>
</html>