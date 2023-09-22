<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
	
	<div class="webcontainer"><!--회원가입 전체 구역  -->
		<button onclick="requestPay()" type="button"> 결제하기 </button>
	</div>
	
	
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="/jspweb/js/payment/payment.js" type="text/javascript"></script>			
</body>	
</html>