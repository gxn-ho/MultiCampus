
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/allgrid.css">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	function pickCategory(ele){
		console.log(ele);
		console.log(ele.selectedIndex);
		console.log(ele.options[ele.selectedIndex].value);
		
		let changeOptionValue = ele.options[ele.selectedIndex].value;
		
		var con = document.getElementsByClassName("projectGridWrap");
		if(changeOptionValue=="all"){
			for(let i=0; i<con.length; i++){
					con[i].style.display = 'block'; 
			
			}
		}
		else{
			for(let i=0; i<con.length; i++){
				if(﻿changeOptionValue != ﻿con[i].title){
					con[i].style.display = 'none'; 
				}else{
					con[i].style.display = 'block'; 
				}
			
			}
		}	
	}

 	function clickImg(elem){
		if(﻿$(elem).attr('src') == "../resources/pic/star.png"){
			﻿elem.src = ﻿"../resources/pic/star2.png";
		}else{
			﻿elem.src = ﻿"../resources/pic/star.png"
		}
	}  
 	
</script>

</head>
<body>
	<div class="head_wrap">
		<div class="head_left">

			<div class="std_room">
				<a href="#">스터디룸</a>
			</div>
			<div class="qna_list">
				<a href="#">Q&A</a>
			</div>
			<div class="emp">
				<a href="#"> </a>
			</div>
			<div class="emp">
				<a href="#"> </a>
			</div>
			<div class="emp">
				<a href="#"> </a>
			</div>
		</div>
		<div class="head_title">
			<a href="#"><img src="../resources/pic/logo.png" width="250px"
				height="150px"></a>
		</div>
		<div class="head_right">
			<div class="make">
				<a href="#">스터디룸 생성</a>
			</div>
			<div class="login">
				<a href="#">로그인</a>
			</div>
			<div class="sign">
				<a href="#">회원가입</a>
			</div>
		</div>
	</div>

	<div class="projectAllGridView">
		<h2>스터디룸</h2>
		<form>
		
			<div class="searchOption">
				<select class="smSelect" onchange="pickCategory(this);">
					<option value="all" selected>전체</option>
					<option value="----취업----">----취업----</option>
					<option value="me">자기소개서</option>
					<option value="interview">면접</option>
					
				
					<option value="----학업----">----학업----</option>
					<option value="data">자료구조</option>
					<option value="science">데이터사이언스</option>
				
					<option value="----기획----">----기획----</option>
					<option value="ui">UI/UX기획</option>
					<option value="game">게임기획</option>
					<option value="PM">PM</option>
			
					<option value="----개발----">----개발----</option>
					<option value="front">프론트엔드</option>
					<option value="back">백엔드</option>
					<option value="android">안드로이드</option>
					<option value="etc">기타전체</option>
				</select>
			</div>
		</form>
		


		
		<div class="projectGridView">
			<c:choose>
				<c:when test="${empty list }">
					<h3>스터디룸이 존재하지 않습니다.</h3>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<div class="projectGridWrap" title="${dto.category }">
							<div class="projectTopInfo">
								<div class="projectThumb">
									<img src="../resources/pic/${dto.category }.png" width="285px"
										height="230px">
								</div>
							</div>
							<div class="projectBottomInfo">
								<div class="txtWrap projectWrap">
									<h4 class="category">
										<c:if test="${dto.category eq 'me'}">자기소개서</c:if>
										<c:if test="${dto.category eq 'interview'}">면접</c:if>
										<c:if test="${dto.category eq 'data'}">자료구조</c:if>
										<c:if test="${dto.category eq 'science'}">데이터사이언스</c:if>
										<c:if test="${dto.category eq 'ui'}">UI/UX기획</c:if>
										<c:if test="${dto.category eq 'game'}">게임기획</c:if>
										<c:if test="${dto.category eq 'PM'}">PM</c:if>
										<c:if test="${dto.category eq 'front'}">프론트</c:if>
										<c:if test="${dto.category eq 'back'}">백엔드</c:if>
										<c:if test="${dto.category eq 'android'}">안드로이드</c:if>
										<c:if test="${dto.category eq 'etc'}">기타</c:if>
									</h4>
									<h3 class="tit">${dto.title }</h3>
								</div>
							</div>
							<div class="bottomWrap">
								<div>모집인원</div>
								<div>${dto.people_num }/8</div>
								<div class="favorite ">
									
									<img id ="starclick"src="../resources/pic/star.png" height="23px" onclick="clickImg(this)">
									
								</div>
							</div>
						</div>
					</c:forEach>

				</c:otherwise>
			</c:choose>

		</div>

	</div>
	
	
	 <c:set var="pageMaker" value="${pageMaker}" />
	<div class="big-width" style="text-align: center">
	   <c:if test="${pageMaker.prev}">
	       <a class="changePage" href="${startPage - 1}"><code>&lt;</code></a>
	   </c:if>
	   <c:forEach var="num" begin="${pageMaker.getStartPage()}" end="${pageMaker.getEndPage()}">
	       <c:choose>
	           <c:when test="${pageMaker.cri.getPageNum() == num}">
	               <code><c:out value="${num}" /></code>
	           </c:when>
	           <c:otherwise>
	               <a class="changePage" href="list?page=${num}"><code><c:out value="${num}" /></code></a>
	           </c:otherwise>
	       </c:choose>
	   </c:forEach>
	   <c:if test="${pageMaker.next}">
	       <a class="changePage" href="${endPage + 1}"><code>&gt;</code></a>
	   </c:if>
	</div>
	<div class="small-width" style="text-align: center">
	   <c:if test="${cri.pageNum > 1}">
	       <a class="changePage" href="${cri.pageNum - 1}"><code>&lt;</code></a>
	   </c:if>
	   <code>${cri.pageNum}</code>
	   <c:if test="${cri.pageNum < realEnd}">
	       <a class="changePage" href="myboard/list?page=${cri.pageNum + 1}" ><code>&gt;</code></a>
	   </c:if>
	</div>
	<form action="list" method="get" name="pageForm">
	    <input type="hidden" name="pageNum" value="${cri.pageNum}" />
	   <input type="hidden" name="amount" value="${cri.amount}" />
	</form> 

</body>
</html>