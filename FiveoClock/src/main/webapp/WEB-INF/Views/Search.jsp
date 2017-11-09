<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="home" method="post">
		<input id="input" class="controls" type="text" placehold="getHappy">
		<input type="submit" value="submit" id="submit">
	</form>
	<div id="map"></div>

  
</body>
  <script type="text/javascript" src="scripts/Search.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVYfU6ANVwwcUSLUM0DzeMgC9WanFMJ2Y&libraries=places&callback=initMap"
         async defer></script> 
</html>