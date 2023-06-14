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
		console.log(res.images[0].fields[0].inferText);
		console.log(res.images[0].fields[0].name);
		console.log(res.images[0].fields[1].inferText);
		console.log(res.images[0].fields[1].name);
		
		for(let i=0; i<res.images[0].fields.length; i++){
			$("div").append("<p>"+res.images[0].fields[i].name+"</p>");
			$("div").append("<p>"+res.images[0].fields[i].inferText+"</p>");
		}
	});
</script>
</head>
<body>
<h1>OCR Result</h1>
<div></div>
</body>
</html>