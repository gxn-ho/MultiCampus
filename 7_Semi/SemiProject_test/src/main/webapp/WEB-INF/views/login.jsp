<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/loginstyle.css">
<title>Insert title here</title>
</head>
<body>
<div class="head_wrap">
      <div class="head_left">
        <div class="std_room"><a href="#">스터디룸</a></div>
        <div class="qna_list"><a href="#">Q&A</a></div>
      </div>
      <div class="head_title">
        <a href="#"><img src="../resources/pic/logo.png" id="logo" /></a>
      </div>
      <div class="head_right">
        <div class="login"><a href="#">로그인</a></div>
        <div class="sign"><a href="#">회원가입</a></div>
      </div>
    </div>
    <div id="line"></div>
    <div id="logintitle">
      <h1 id="loginTxt">로그인</h1>
      <div class="container">
        <div class="content">
          <div class="contenttxt">
            <div class="signTxt">아이디</div>
            <div class="signTxt">비밀번호</div>
          </div>
          <div class="registInput">
          <form name="login" method="post" action="login">
          <input id="id" class="ipBox" type="text" />
            <input id="pw" class="ipBox" type="password" />
          </div>
        </div>
        <div class="find">
          <div class="findtxt">아이디 찾기</div>
          <div class="findtxt">&nbsp;|&nbsp;</div>
          <div class="findtxt">비밀번호 찾기</div>
        </div>
        <div id="buttonbox">
          <div class="button">
            <button type="button" class="loginButton" abled onclick="signUpCheck()">로그인</button>
        </form>
        <button type="button" class="signUpButton" abled onclick="joinCheck()" >회원가입</button>
        <button type="button" class="signUpButton" abled onclick="naverSignUpCheck()" id="naver" >네이버 로그인</button>
        <button type="button" class="signUpButton" abled onclick="kakaoSignUpCheck()" id="kakao" >카카오 로그인</button>
      </div>
    </div>
  </div>
</div>

<form action="${loginUrl}" method="get">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            사용자ID 또는 비밀번호를 확인해 주세요.
        </div>
    </c:if>
    <div class="mb-3">
        <label for="username" class="form-label">사용자ID</label>
        <input type="text" name="username" id="username" class="form-control">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">비밀번호</label>
        <input type="password" name="password" id="password" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">로그인</button>
</form>
</body>
</html>