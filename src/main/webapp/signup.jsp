<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HII FROM H! TAG</h1>
<%!String message="hii this is not null"; %>
<%if(message!=null){ %>
<%=message %>
<%}else{ %>

<%="HII THIS MESSAGE IS NULL SO THIS IS FROM ELSE BLOCK" %>

<%} %>
</body>
</html>