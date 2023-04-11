<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 

	EL: 데이터 표현하기 위한 언어
	기존 => < %= %>
	el: \${변수/속성}
	속성-attribute (범위가 큰 jsp 객체부터 탐색)


 -->
<h1>EL: Expression Language</h1>
<table border="1">
	<tr>
		<th>EL</th>
		<th>RESULT</th>
	</tr>
	<tr>
		<td>\${1}</td>
		<td>${1}</td>
	</tr>
	<tr>
		<td>\${1+2 }</td>
		<td>${1+2 }</td>
	</tr>
	<tr>
		<td>\${1-2 }</td>
		<td>${1-2 }</td>
	</tr>
	<tr>
		<td>\${(1==2)?3:4 }</td>
		<td>${(1==2)?3:4 }</td>
	</tr>


</table>









</body>
</html>