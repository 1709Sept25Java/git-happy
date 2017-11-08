<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>5 O'Clock</title>
</head>
<body>
	<div id="contentDiv">
		<h2 id="header">Welcome</h2>
		<p>Please enter your credentials below:</p>
		<div id="formDiv">
			<form action="login" method="post">
				<input name="username" placeholder="Username"> <input
					name="password" type="password" placeholder="Password">
				<p></p>
				<input type="submit" value="Log In">
			</form>
		</div>
	</div>
</body>
</html>