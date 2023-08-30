<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/header.css" rel="stylesheet">
</head>
<body>

	<!-- 헤더  -->	
	<div id="header">
		<div class="mainlogo"><!-- 로고 -->
			<a href="/jspweb/index.jsp">
				<img alt="" src="/jspweb/img/ezen.png" />
			</a>
		</div>
		<ul class="mainmenu"><!-- 본메뉴  -->
			<li><a href="/jspweb/visitlog/visitlog.jsp">방문록(절대경로)</a></li>		
			<li><a href="#">기능1</a></li>
			<li><a href="#">기능2</a></li>
			<li><a href="#">기능3</a></li>		
			<li><a href="/jspweb/accountbook/accountbook.jsp">과제1:가계부</a></li>
			<li><a href="/jspweb/library/library.jsp">과제2:열람실</a></li>
			<li><a href="#">과제3:</a></li>
		</ul>
		<ul class="submenu"><!-- 서브메뉴 -->
			<li><a href="/jspweb/index.jsp">홈으로</a></li>
			<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
			<li><a href="#">로그인</a></li>
			<li><a href="#">로그아웃</a></li>
			<li><a href="#">마이페이지</a></li>	
			<li><img class="hmimg" src="/jspweb/member/img/default.webp"></li>
		</ul>
	</div>
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일)  -->
	<script src="https://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	
</body>
</html>
<!-- 
	헤더 많은 페이지에서 참조하는 페이지이므로 공통적인 코드
	1. 라이브러리
		1. JQUERY[<script src="https://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>]
  -->	