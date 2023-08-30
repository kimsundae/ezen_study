<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="hrm.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="webcontainer">
		<form class="hform">
			<h2> 이젠아카데미 사원 등록 시스템 </h2>	
			<div>직원명</div>
			<input type="text" name="hname" class="hname">
			<div>직원전화번호</div>
			<input type="text" name="hphone" class="hphone">
			<div>직급</div>
			<select name="hrank" class="hrank">
				<option>사장</option>
				<option>부장</option>
				<option>팀장</option>
				<option>대리</option>
				<option>주임</option>
				<option>사원</option>
			</select>
			<div>직원사진</div>
			<input onchange="chimg(this)" name="himg" class="himg" type="file" accept="image/*"/>
			<div>
				<img class="preimg" alt="" src="img/default.webp"  width="100px"><!-- 등록 사진을 미리보기 할 사진 태그 -->
			</div>	
			<div><button onclick="hregist()" type="button">등록하기</button></div>
			
			<div class="bottomContent"> 이젠 아카데미 직원 현황</div>
			<!-- 전 직원 출력 구역  -->
			<div class="houtBox">
				
				<ul class="hout">
					<li><img src="img/default.webp" width="100px"></li>
					<li>이름 : 김근배</li>
					<li>전화번호 : 01012345678</li>
					<li>직급 : 대리</li>
					<li>등록일 : 2023-123-123</li>
				</ul>
					
			</div>
		</form>
	</div>
	
	<script src="hrm.js" type="text/javascript"></script>
</body>
</html>