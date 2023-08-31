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
		
			<div class="emailcheckbox">프로필 변경</div>
			<!-- <태그명 이벤트명="함수명( this )"  -->
			<input onchange="preimg( this )" name="mimg" class="mimg" type="file" accept="image/*"/><br/> 
			
			<img class="preimg" alt="" src="img/default.webp" width="100px"><!-- 등록 사진을 미리보기 할 사진 태그 -->
			<div class="intitle">아이디</div>	
			<div class="mid"> qweqwe </div>
			
			<div class="intitle">이메일</div>
			<div class="memail">qwe@qwe.com</div>
			
			<div class="intitle">기존 비밀번호</div>
			<input maxlength="20" onkeyup="pwcheck()" name = "mpwd" class="mpwd" type="password"/>
		
			<div class="intitle">새로운 비밀번호</div>
			<input maxlength="20" onkeyup="pwcheck()" name = "newmpwd" class="newmpwd" type="password"/>	
			<div class="pwcheckbox"></div>
	
			
			<button class="signupbtn" onclick="mupdate()" type="button"> 수정 </button>					
			<button class="signupbtn" onclick="mdelete()" type="button"> 탈퇴 </button>
			
		</form>
	</div>
	
	<script src="/jspweb/js/mypage.js" type="text/javascript"></script>
</body>
</html>