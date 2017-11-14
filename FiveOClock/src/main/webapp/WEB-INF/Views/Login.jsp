<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>5 O'Clock</title>

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
	href="<c:url value="/resources/Styles/LoginStyle.css" />">

</head>
<body>
	<div id="contentDiv">
		<h1 id="header">5 O'Clock</h1>
		<p id="errorMessage">${message}</p>
		<div id="formDiv">
			<form id="loginForm" action="login" method="post">
				 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input name="username"
					placeholder="Username"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				<input name="password" type="password" placeholder="Password">
				&nbsp; &nbsp; &nbsp; <span id="submitGlyph"
					class="glyphicon glyphicon-circle-arrow-right"></span>
			</form>
		</div>
	</div>
	<script src="<c:url value="/resources/Scripts/Login.js" />"></script>

</body>
</html>