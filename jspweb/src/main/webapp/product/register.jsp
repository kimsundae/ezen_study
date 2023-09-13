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
		<form class="registerForm">
			카테고리 : <select name="pcno">
						<option value="1">노트북</option>
						<option value="2">태블릿</option>
						<option value="3">냉장고</option>
					</select><br/>
			제품명 : <input name="pname" type="text"><br/>
			제품설명 : <textarea name="pcontent" rows="" cols=""></textarea><br/>
			제품가격 : <input name="pprice" type="number"> <br/>
			
			<!-- 첨부파일 1개일 때  -->
			제품이미지 : <input name="pimg" type="file" multiple="multiple"><br/>
			
			<!-- 2. cos.jar 첨부파일 여러개일 때  input 속성에 multiple="multiple"-->
			<!-- 해결방안 : 1. multiple="multiple" 사용하지 않고 input 여러개 사용 -->
			<!-- 해결방안 : 2. multiple="multiple" 사용하고 cos.jar 대신 commons jar -->
			<button onclick="onRegister()" type="button">등록</button>
		</form>
	</div>

	<script src="/jspweb/product/register.js" type="text/javascript"></script>
</body>
</html>