<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer money page</title>
</head>
<body>
<form action="Transfer">
<table>
<tr>
<td>Receiver Accno:</td>
<td><input type="text" name="raccno" placeholder="Enter the data" required="required"/></td>
</tr>

<tr>
<td>Amount:</td>
<td><input type="text" name="amt" placeholder="Enter the ammount" required="required"/></td>
<tr/>

<tr>
<td></td>
<td><input type="submit" value="Transfer"/></td>
</tr>

</table>
</form>
</body>
</html>