<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	function login(){
		let memberid=$("#memberid").val().trim();
		let memberpw=$("#memberpw").val().trim();
	
		let loginVal={
			"memberid":memberid,
			"memberpw":memberpw
		};
		
		if(memberid==null||memberid==""||memberpw==null||memberpw==""){
			alert("ID 및 PW를 확인해 주세요");
		}else{
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data:JSON.stringify(loginVal),
				contentType:"application/json",
				dataType:"json",
				success:function(msg){
					if(msg.check==true){
						alert("로그인 성공");
						location.href="list.do";
					}else{
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
</script>
</head>
<body>
	<table>
		<tr>
			<th>I D</th>
			<td><input type="text" id="memberid" name="memberid"></td>
		</tr>
		<tr>
			<th>P W</th>
			<td><input type="text" id="memberpw" name="memberpw"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login();"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>