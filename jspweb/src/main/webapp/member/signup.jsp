<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="../css/member.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer"><!--회원가입 전체 구역  -->
		<form class="signupForm"><!-- 폼 전송시 각 input에 name -->
		
			<h2> 이젠 개발자 커뮤니티 회원가입</h2>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다.</p>
			
			<div class="intitle">아이디</div>	
			<input maxlength="30" onkeyup="idcheck()" name="mid" class="mid" type="text"/>	
			<div class="idcheckbox"> </div>
			<div class="intitle">비밀번호</div>
			<input maxlength="20" onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password"/>
			<div class="intitle">비밀번호 확인</div>
			<input maxlength="20" onkeyup="pwcheck()"  class="mpwdconfirm" type="password"/>
	
			
			<div class="pwcheckbox"></div>
	
			<div class="intitle">이메일</div>
			<div class="emailbox">
				<input onkeyup="emailcheck()" name="memail" class="memail" type="text"/>
				<button class="authReqBtn" onclick="authReq()" disabled type="button">인증요청</button>		
			</div>		
			<div class="authbox">
				<!-- 인증 호출 구역 -->
			</div>
		
			<div class="emailcheckbox">프로필</div>
			<!-- <태그명 이벤트명="함수명( this )"  -->
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image/*"/><br/> 
			
			<img class="preimg" alt="" src="img/default.webp" width="100px"><!-- 등록 사진을 미리보기 할 사진 태그 -->
			<button class="signupbtn" onclick="signup()" type="button">회원가입</button>
			
		</form>
	</div>
	
	<script src="/jspweb/js/signup.js" type="text/javascript"></script>
</body>
</html>