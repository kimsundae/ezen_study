<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/frontendProject/CSS/kiosk.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="kioskwrap">
		<a href="#여기"> 가장 아래호 </a>
		<div class="">	<!-- 헤더 : 카테고리 출력/광고 이미지 표시되는 구역 -->
		
			<!-- 광고이미지  -->
			<img class="himg" src="../img/himg1.png">
			
			<!-- 카테고리  -->
			<ul class="categorymenu">
				<!-- categoryPrint함수가 html 넣어주는 위치  -->			
			</ul>
			
		</div>	
		
		<div class="kioskcontent"><!-- 본문 : 제품 출력/장바구니 출력 구역 -->
		
			<div class="productbox"><!-- 제품구역 -->
				<!-- 제품 1개 들어갈 위치  -->
			</div><!-- 제품구역 end  -->
			
			<div class="cartbox"><!-- 카트구역 -->
				<div class="cartcontent">	<!-- 제품개수/가격 , 제품정보 출력 -->
					<div class="carttop"><!-- 제품개수/총가격  -->
						<div> 카트 <span class="ccount" >0</span> </div>
						<div> 총 주문금액 <span class="ctotal" >0</span> </div>
					</div>
					<div class="cartbottom">	<!-- 제품정보 출력 구역  -->
							<!-- innerHTML -->				
					</div>
				
				</div>	
				<div class="cartbtn" id="여기">	<!-- 버튼 구역 -->
					<button onclick="cartCancel()" class="cancelbtn">취소하기</button>
					<button onclick="productOrder()" class="orderbtn">주문하기</button>
				</div>	
			</div><!-- 카트구역 end  -->
			
		</div><!-- 본문 end  -->
		
	</div>
	
	<%@include file="../footer.jsp" %>
	
	<script src="/frontendProject/JS/kiosk.js" type="text/javascript"></script>
</body>
</html>