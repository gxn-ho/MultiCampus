<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.el.score.Score"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Score sco = (Score)request.getAttribute("score");
%>
<h1>EL Page</h1>
<table border="1">
	<tr>
		<th colspan="2"><%=sco.getName() %> 님의 점수는...</th>
	</tr>
	<tr>
		<th>국어</th>
		<th>${score.kor }</th>
	</tr>
	<tr>
		<th>영어</th>
		<th>${score.eng }</th>
	</tr>
	<tr>
		<th>수학</th>
		<th>${score.math }</th>
	</tr>
</table>





























</body>
</html>