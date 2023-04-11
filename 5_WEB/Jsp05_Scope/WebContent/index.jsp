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
<%
	/* 
	jsp에서 scope: 변수들이 사용가능한 범위를 스코프라고 한다. 
	page scope, request scope, session scope, application scope
	*/
	pageContext.setAttribute("pageId", "myPageIdVal");
	request.setAttribute("reqId", "myRequestIdVal");
	session.setAttribute("sessionId", "mySessionIdVal");
	application.setAttribute("appId", "myAppIdVal");
	
	
%>
<body>
<h1>index</h1>
pageId: <%=pageContext.getAttribute("pageId") %> <br>
reqId: <%=request.getAttribute("reqId") %> <br>
sessionId: <%=session.getAttribute("sessionId") %> <br>
appId: <%=application.getAttribute("appId") %> <br>

<a href="result.jsp">이동(result.jsp)</a>
<a href="myservlet.do">이동(controller)</a>










</body>
</html>