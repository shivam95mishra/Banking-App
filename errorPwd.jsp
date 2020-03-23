<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Password page</title>
</head>
<body>
<h2>New password and confirm new password did not match.Try Again....!</h2>
<form action="ChangePwd">
<table>
<tr>
<td>New Password:</td>
<td><input type="password" name="npwd" placeholder="fill the pwd" /></td>
</tr>

<tr>
<td>Confirm New Password:</td>
<td><input type="password" name="cnpwd" placeholder="fill the pwd" /></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Change"/></td>
</tr>

</table>
</form>

</body>
</html>