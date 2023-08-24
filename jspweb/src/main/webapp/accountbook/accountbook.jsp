<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="accountbook.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="wrap">
		<div class="input_box">
			<input class="input_content" type="text" placeholder="내용">
			<input class="input_price" type="text" placeholder="금액">
			<input class="input_date" type="date" placeholder="날짜">
			<button onclick="등록()" class="input_button" type="button">등록</button>
		</div>

		<div class="output_text">
			<div class="tittle">
				<div class="tcontent">내용</div>
				<div class="tprice">금액</div>
				<div class="tdate">날짜</div>
			</div>
			<div class="text">
				<div class="content">의료비</div>
				<div class="price">10000</div>
				<div class="date">2028-10-30</div>
				<div class="button_box">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>
		</div>
	
	</div>


	<script src="https://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
	<script src="accountbook.js" type="text/javascript"></script>
</body>
</html>