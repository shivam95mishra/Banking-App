<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Page</title>
</head>
<body>
<h2>Dear Customer</h2><br/>
<h2>Your Balance is<%out.println(session.getAttribute("balance")); %></h2>
</body>
</html>