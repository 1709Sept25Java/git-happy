<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>

</head>
<body>
	<form action="search" method="POST">
		<input id="input" name="input" class="controls" type="text"
			placeholder="Enter location" style="width: 250px;"> <input
			type="submit" value="Get Happy!" id="submit">
	</form>
	<div id="map"></div>


</body>
<script src="<c:url value="/resources/Scripts/Search.js" />"></script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&libraries=places&callback=initMap"
	async defer></script>
</html>