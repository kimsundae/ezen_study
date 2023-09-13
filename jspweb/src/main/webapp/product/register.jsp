<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file ="../header.jsp" %>
	
	<div class="webcontainer">
		<h3> 제품 등록 페이지 [ form 태그 없는 경우 1] </h3>
		<div>
			제품명 : <input class="pname1" type="text"><br/>
			제품설명 : <textarea class="pcontent1"></textarea><br/>
			<button onclick="register1()" type="button">둥록</button>
		</div>	
		
		<h3> 제품 등록 페이지 [ form 태그 이용하는 경우2 ]</h3>
		<form class="registerForm1">
				제품명 : <input name="pname2" class="pname2" type="text"><br/>
			제품설명 : <textarea name="pcontent2" class="pcontent2"></textarea><br/>
			<button onclick="register2()" type="button">둥록</button>
		
		</form>
	</div>

	<script src="/jspweb/product/register.js" type="text/javascript"></script>
</body>
</html>