<%@page import="com.my.dto.MyBoardDto"%>
<%@page import="com.my.dao.MyBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
%>
<body>
<h1>게시글 수정</h1>
<form action="myupdate_res.jsp" method="post">
	<input type="hidden" name="myno" value="<%=dto.getMyno()%>">
	<table>
	<tr>
		<th>NAME: </th>
		<td><%=dto.getMyname() %></td>
	</tr>
	<tr>
		<th>TITLE: </th>
		<td><input type="text" name="mytitle" value="<%=dto.getMytitle() %>"></td>
	</tr>
	<tr>
		<th>CONTENT: </th>
		<td>
			<textarea rows="10" cols="40" name="mycontent"><%=dto.getMycontent() %></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>

















</body>
</html>