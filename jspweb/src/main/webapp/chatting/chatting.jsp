<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>>
	<div class="webcontainer">
		<h2>채팅</h2>
		<div>
			<div class="contentbox"></div>
			<input class="inputcontent"/>
			<button class="sendbtn" onclick="send()" type="button">전송</button>
		</div>
	
	</div>

	<script src="chatting.js" type="text/javascript"></script>
</body>
</html>