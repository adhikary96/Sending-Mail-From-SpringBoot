<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sendMail" method="get">
		
		Customers Email Id: <input type="text" id="customerMail" name="customerMail"><br/>
		Customers Password:<input type="text" id="password" name="password"><br/>
		Friend's Email ID :<input type="text" id="friendEmail" name="friendEmail"><br/>
		<button type="submit" id="invite">Invite A Friend</button>
		
	</form>
</body>
</html>