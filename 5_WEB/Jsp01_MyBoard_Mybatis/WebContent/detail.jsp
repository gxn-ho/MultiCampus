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
	<h1>상세페이지</h1>
	<table>
		<tr>
			<th>NAME: </th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>TITLE: </th>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>CONTENT: </th>
			<td><textarea rows="10" cols="40" readonly="readonly"><%=dto.getMycontent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button onclick="location.href='myupdate.jsp?myno=<%=dto.getMyno()%>'">수정</button>&nbsp;&nbsp;
				<button onclick="location.href='mydelete.jsp?myno=<%=dto.getMyno()%>'">삭제</button>&nbsp;&nbsp;
				<button onclick="location.href='mylist.jsp'">목록</button>&nbsp;
			</td>
		</tr>
	</table>


























</body>
</html>