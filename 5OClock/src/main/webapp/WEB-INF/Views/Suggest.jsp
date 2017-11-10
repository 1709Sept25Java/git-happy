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
<body>
<h4>Venue Suggestion</h4>
<div>
	<form>
	
		<input id="venueName" placeholder="Name"> <input
			id="venueAddress" placeholder="Address"> <input
			id="venuePhone" placeholder="Phone Number">
			<input type="submit" value="Get Happy">

<h4>Deals Suggestion</h4>
		<input id="dealType" placeholder="Deal's Type"> <input
			id="description" placeholder="Description"> <input id="price"
			placeholder="Price"> <input id="startTime"
			placeholder="Start Time"> <input id="endTime"
			placeholder="End Time"> <span id="submitGlyph"
			class="glyphicon glyphicon-plus-sign"></span>
			<div id= "nextDeal"></div>
	</form>
</div>
</body>
<%-- <script src="<c:url value="/resources/Scripts/Suggest.js" />"></script> --%>
<script>
document.getElementById("submitGlyph").addEventListener("click",function(){
	
	document.getElementById("nextDeal").innerHTML='<input id="dealType" placeholder="Deal\'s Type"> <input id="description" placeholder="Description"> <input id="price" placeholder="Price"> <input id="startTime"'+
		'placeholder="Start Time"> <input id="endTime" placeholder="End Time">;

	alert("hello");

});


</script>
</html>

