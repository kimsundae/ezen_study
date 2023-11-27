<%@page import="홈쇼핑_회원관리_프로그램.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header.jsp" %>

	<%
		int lastCustno = new Dao().lastCustno();
	 %>
	<div class="wrap">
		<center> <h1>홈쇼핑 회원 등록</h1> </center>
		
		<center>
			<form name="registeForm" method="post" action="registe.jsp">
				<div>회원번호(자동발생) <input type="text" value= <%= lastCustno+1 %> name="custno"/></div>
				<div>회원성명 <input type="text" name="custname"/></div>
				<div>회원전화 <input type="text" name="phone"/></div>
				<div>회원주소 <input type="text" name="address"/></div>
				<div>가입일자 <input type="text" name="joindate"/></div>
				<div>고객등급 [A:VIP,B:일반,C:직원] <input type="text" name="grade"/></div>
				<div>도시코드 <input type="text" name="city"/></div>
				<div><center><button type="button" onclick="onRegiste()">등록</button><button type="button">조회</button></center></div>
				</form>
		</center>
	
	</div>
	<%@ include file="./footer.jsp" %>
	<script src="./registe.js"></script>
</body>
</html>