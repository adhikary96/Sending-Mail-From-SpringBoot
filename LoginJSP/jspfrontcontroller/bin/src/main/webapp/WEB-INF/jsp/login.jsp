<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- sendLoginToRestController -->
<form action="/loginREST">
	USERNAME:	<input type="text" name="user" id="user">
	PASSWORD:	<input type="password" name="password" id="password">
	<button type="submit" id="submit">LOGIN</button>
</form>
</body>
</html>