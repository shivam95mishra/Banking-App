<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Get Statement Page</title>
</head>
<body>
<h1>Transactions are:</h1>
<br/>
<h2>Credited Amount:</h2>
<br/>
<%
ArrayList<Integer>al=(ArrayList<Integer>)session.getAttribute("al");
for(int i=0;i<=al.size()-1;i++)
{
	if(al.get(i)>0)
	{
		out.println(al.get(i));
	}
}
%>
<br/>
<h2>Debited Amount:</h2>
<br/>
<% 
for(int i=0;i<=al.size()-1;i++)
{
	if(al.get(i)<0)
	{
		out.println(al.get(i));
	}
}
%>
</body>
</html>