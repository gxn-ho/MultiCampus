<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	
	System.out.println("[command : "+command+"]");
	
	MVCBoardDao dao = new MVCBoardDao();
	
	
	if(command.equals("boardlist")){
		List<MVCBoardDto> list = dao.selectAll();
		request.setAttribute("allList", list);
		
		
		/* 
			pageContext 객체
			jsp 기본 객체 중 하나.
			페이지당 하나, 주요 기능은 다른 기본 객체들을 구할 때 사용 or 페이지 흐름을 제어
		*/
		
		
		
		pageContext.forward("boardlist.jsp");
		/* 
			페이지 흐름을 제어(페이지 이동!)
			forward: req, res 객체 유지되면서 페이지 전환, 이동된 url이 안 보인다.
				1)pageContext
				2)<jsp:forward>
				3)requestDispatcher(서블릿에서 사용)
			sendRedirect: 새로운 req, res, 클라이언트가 새로운 페이지를 요청한 것과 같다.
				response.sendRedirect()
				
		*/
		
		
		
		
	}else if(command.equals("boarddetail")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("boarddetail.jsp");
		
	}else if(command.equals("boardinsertform")){
		response.sendRedirect("boardinsert.jsp");
		
	}else if(command.equals("boardinsert")){
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setTitle(title);
		dto.setWriter(writer);
		dto.setContent(content);
		
		int res = dao.insert(dto);
		
		if(res>0){
%>
	<script type="text/javascript">
		alert("글 작성 성공");
		location.href='mycontroller.jsp?command=boardlist';
	</script>			
<%			
		}else{
%>
	<script type="text/javascript">
		alert("글 작성 실패");
		location.href='mycontroller.jsp?command=boardlistform';
	</script>			
<%
		}
		
	}else if(command.equals("boardupdateform")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("dto", dto);
		pageContext.forward("boardupdate.jsp");
		
	}else if(command.equals("boardupdate")){
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(seq);
		
		int res = dao.update(dto);

		if(res>0){
%>			
		<script type="text/javascript">
		alert("글 수정 성공");
		location.href="mycontroller.jsp?command=boarddetail&seq="+<%=seq%>;
		</script>			
<%			
		}else{
%>			
		<script type="text/javascript">
		alert("글 수정 실패");
		location.href="mycontroller.jsp?command=boardupdateform&seq="+<%=seq%>;
		</script>

<%			
		}
		
	}else if(command.equals("muldel")){
		String[] seq = request.getParameterValues("chk");
		int res = dao.delete(seq);
		
		if(res == seq.length){
%>			
		<script type="text/javascript">
			alert("글 삭제 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>			
<%			
		}else{
%>			
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%			
		}
		
	}else if(command.equals("boarddelte")){
		String[] seq = new String[1];
		seq[0] = request.getParameter("seq");
		int res = dao.delete(seq);
		
		if(res == seq.length){
%>			
		<script type="text/javascript">
			alert("글 삭제 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>			
<%			
		}else{
%>			
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%			
		}
		
	}
%>
















</body>
</html>