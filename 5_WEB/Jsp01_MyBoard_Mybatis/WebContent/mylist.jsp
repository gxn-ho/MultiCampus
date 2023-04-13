<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//java code
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectAll();
	
%>

<body>
	<h1>LIST PAGE</h1>
	
	<table border="1">
		<col width="50px"><col width="100px">
		<col width="200px"><col width="100px">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>UPD</th>
			<th>DEL</th>
		</tr>
<%
		for(int i=0; i<list.size(); i++){
%>
			<tr>
				<td><%=list.get(i).getMyno() %></td>
				<td><%=list.get(i).getMyname() %></td>
				<td><a href="detail.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
				<td><%=list.get(i).getMydate() %></td>
				<td>수정</td>
				<td>삭제</td>
			</tr>
<%
		}
%>
	
		<tr>
			<td colspan="6" align="right">
				<button onclick="location.href='myinsert.jsp'" >글쓰기</button>
			</td>
		</tr>
	</table>
	
	
	
	
	
</body>
</html>

























