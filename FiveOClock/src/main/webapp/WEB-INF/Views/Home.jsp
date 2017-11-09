<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 id="heading">Happy Hour Deals Near ${location}</h2>
<div>Refine Search: 
<form id="filterForm" style="display:inline;">
  <input type="checkbox" name="type" value="beer" checked> Beer
  <input type="checkbox" name="type" value="wine" checked> Wine
  <input type="checkbox" name="type" value="cocktails" checked> Cocktails
</form>
</div>
<table id="dealTable">
	<tr>
		<th class="typeRow">Type</th>
		<th class="priceRow">Price</th>
		<th class="descriptionRow">Description</th>
		<th class="distanceRow">Distance</th>
	<tr>
</table>


<script src="<c:url value="/resources/Scripts/DealScript.js" />"></script>

</body>
</html>