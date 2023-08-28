<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="library.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="wrap">	
		<h3>도서관 열람실 좌석 현황</h3>
		<div class="seat_table">
			<span class="button_box">	
					<button class="button1" onclick="chNum(1)" type="button"> 1 </button>
					<button class="button2" onclick="chNum(2)" type="button"> 2 </button>
					<button class="button3" onclick="chNum(3)" type="button"> 3 </button>
					<button class="button4" onclick="chNum(4)" type="button"> 4 </button><br/>										
					<button class="button5" onclick="chNum(5)" type="button"> 5 </button>
					<button class="button6" onclick="chNum(6)" type="button"> 6 </button>
					<button class="button7" onclick="chNum(7)" type="button"> 7 </button>
					<button class="button8" onclick="chNum(8)" type="button"> 8 </button>	
			</span>
			<span class="input_box">
				<input class="name" type="text" placeholder="이름"/>
				<input class="phonenumber" type="text" placeholder="전화번호"/>
			</span>
		</div>
		<div class="botton_table">	
			<div>현재 선택된 좌석 번호 : <span class="ch_num"></span></div>
			<div class="room_button">
				<button onclick="checkIn()" class="getIn" type="button">입실</button>
				<button onclick="getOut()" class="getOut" type="button">퇴실</button>
			</div>
		</div>
		
	</div>







	<script src="library.js" type="text/javascript"></script>
</body>
</html>