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
		let res = ${res};
		console.log(res);
		
		$('#cel').append(res.faces[0].celebrity.value);
		$('#conf').append(res.faces[0].celebrity.confidence);
		
	});
</script>
</head>
<body>
<h1>CFR</h1>
<div>
	닮은꼴 : <span id="cel"></span><br>
	닮은정도 : <span id="conf"></span>
</div>
</body>
</html>