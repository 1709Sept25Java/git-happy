<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
	href="<c:url value="/resources/Styles/Home.css" />">

<title>Happy Hour Deals Near ${location}</title>
</head>
<body>
	<h2 id="heading">Happy Hour Deals Near ${location}</h2>
	<div>
		Refine Search:
		<form id="filterForm" style="display: inline;">
			<input id="Beer" type="checkbox" name="type" value="beer"
				class="checkBox" checked /> Beer <input id="Wine" type="checkbox"
				name="type" value="wine" class="checkBox" checked /> Wine <input
				id="Cocktails" type="checkbox" name="type" value="cocktails"
				class="checkBox" checked /> Cocktails
		</form>
			<div class="col-xs-2">
				<input id="timeInput" type="text" class="form-control input-sm" />
			</div>
			<button id="timeButton">
				<span class="glyphicon glyphicon-time"></span>
			</button>

	</div>
<br>

	<table id="dealTable">
		<tr>
			<th class="typeRow">Type</th>
			<th class="priceRow">Price</th>
			<th class="descriptionRow">Description</th>
			<th class="distanceRow">Distance</th>
		<tr>
	</table>

	<script type="text/javascript"
		src="http://maps.google.com/maps/api/js?key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&sensor=false"></script>
	<script src="<c:url value="/resources/Scripts/DealScript.js" />"></script>

</body>
</html>