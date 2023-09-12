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
	<%@include file="../header.jsp" %>
	<div class="webcontainer">
		<!-- 채팅전체구역 -->
		<div class="chatbox">
			<!-- 채팅내욕 목록 -->
			<div class="chatcont">
			
				<!-- 보냈을 때 메시지 -->
				<div class="rcont">
					<div class="subcont">
						<div class="date">오전 10:02</div>
						<div class="content">안녕하세요.111</div>
					</div>
				</div>
				<!-- 알림 메시지 -->
				<div class="alarm"> 강호동님이 입장하셨습니다.</div>
				<!-- 받았을 때 메시지 -->
				<div class="lcont">
					<!-- 보낸사람 프로필 -->
					<img class="pimg" src="/jspweb/member/img/default.webp">
					<div class="tocont">
						<div class="name">강호동</div><!-- 보낸사람 -->
						<div class="subcont">
							<div class="content"> 그래 안녕~~ </div>
							<div class="date"> 오전 10:10 </div>
						</div>					
					</div>
				</div>
			</div>
			<!-- 채팅입력창 , 전송버튼 -->
			<div class="chatbottom">
				<textarea onkeyup="onEnterKey()" class="msg"></textarea>
				<button onclick="onSend()" type="button"></button>
			</div>
		</div>
	</div>

	<script src="chatting.js" type="text/javascript"></script>
</body>
</html>