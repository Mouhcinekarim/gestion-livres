<%@page import="domains.Livre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
<%
	Livre l = (Livre)request.getAttribute("l");
	if (l != null){
%>
<p>titre: <%= l.getTitre() %></p>
<%}else{ %><p>Le livre n'existe pas!</p><%}%>
</body>
</html>