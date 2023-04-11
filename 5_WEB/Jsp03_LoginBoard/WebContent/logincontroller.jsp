<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="com.login.dto.MyMemberDto" %>
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
	System.out.println("[command: "+command+"]");
	
	MyMemberDao dao = new MyMemberDao();
	
	
	if(command.equals("login")){
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id,pw);
		
		if(dto.getMyid() != null){
			//session scope 세션 영역
			//그 외에 application, pageContext 등이 있다.
			session.setAttribute("dto", dto);
/*
page 영역: 하나의 jsp 페이지 내에서만 공유하는 영역
request 영역: 요청 받아서 응답하기까지 객체가 유효한 영역
session 영역:	 하나의 브라우저당 1개의 session 객체 생성 후 공유하는 영역
application 영역: 하나의 어플리케이션당 1개의 application 객체 생성 후 공유하는 영역
*/
			//session에 담긴 객체가 살아있는 시간(음수: 무제한, 60*60: 1시간, 기본: 30분)
			session.setMaxInactiveInterval(60*60);
			
			if(dto.getMyrole().equals("ADMIN") ){
				response.sendRedirect("adminmain.jsp");
			}else if(dto.getMyrole().equals("USER") || dto.getMyrole().equals("MANAGER")){
				response.sendRedirect("usermain.jsp");
			}
			
		} else{
%>
		<script type="text/javascript">
			alert("login 실패");
			location.href='index.jsp';
		</script>
<%			
			
		}
		
	}else if(command.equals("logout")){
		//session 정보 삭제
		session.invalidate();
		response.sendRedirect("index.jsp");
	}else if(command.equals("userlistall")){
		List<MyMemberDto> list = dao.selectAll();
		
		request.setAttribute("list", list);
		pageContext.forward("userlistall.jsp");
	}else if(command.equals("userlistenabled")){
		List<MyMemberDto> list = dao.selectEnabled();
		request.setAttribute("list", list);
		pageContext.forward("userlistenabled.jsp");
		
	}else if(command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		
		request.setAttribute("selectOne", dto);
		pageContext.forward("updateroleform.jsp");
		
	}else if(command.equals("updaterole")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = dao.updateRole(myno, myrole);
		
		if(res>0){
%>	
		<script type="text/javascript">
			alert("회원 등급 조정 성공");
			location.href="logincontroller.jsp?command=userlistenabled";
		</script>
<%			
		}else{
%>
		<script type="text/javascript">
			alert("회원 등급 조정 실패");
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
		</script>

<%			
		}
	}else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
	}else if(command.equals("idchk")){
		String myid = request.getParameter("id");
		String res = dao.idChk(myid);
		
		boolean idnotused = true;
		
		if(res != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
	}else if(command.equals("insertuser")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MyMemberDto dto = new MyMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = dao.insertUser(dto);
		if(res>0){
%>			
			<script type="text/javascript">
				alert("회원가입 성공");
				location.href="index.jsp";
			</script>
<%			
		}else{
%>		
			<script type="text/javascript">
				alert("회원가입 실패");
				location.href="logincontroller.jsp?command=registform";
			</script>
<%	
		}
		
	}else if(command.equals("userinfo")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MyMemberDto dto = dao.selectUser(myno);
		
		request.setAttribute("dto", dto);
		pageContext.forward("userinfo.jsp");
		
	}else if(command.equals("deleteuser")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		boolean res = dao.deleteUser(myno);
		
		if(res){
%>
			<script type="text/javascript">
				alert("탈퇴 성공");
				location.href="logincontroller.jsp?command=logout";
			</script>
<%		
		}else{
%>
			<script type="text/javascript">
			alert("탈퇴 실패");
			location.href="logincontroller.jsp?command=userinfo&myno=<%=myno%>";
		</script>
<%	
		}
	}
%>









</body>
</html>