<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/view/view.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	
	<%@include file ="../../header.jsp"%>
	<div class="webcontent">
		<div class="productBox">
			<div id="carouselExample" class="carousel slide"><!-- 캐러셀 : 이미지 슬라이드  -->
			  <div class="imgbox carousel-inner"><!-- carousel-inner : 캐러셀 안에 넣을 이미지 목록 구역  -->
			    	<!-- 캐러셀 안에 넣을 이미지 구역 -->
			  </div>
			  <!-- 왼쪽 이동 버튼 -->
			  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Previous</span>
			  </button>
			  <!-- 오른쪽 이동 버튼 -->
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="visually-hidden">Next</span>
			  </button>
			</div>
			<div>판매자 : 강호동</div>
			<div>
				카테고리 : <span> 노트북 </span>
				등록일 : <span> 2023-09-19 11:47 </span>
			</div>
			<div>노트북 팝니다.</div>
			<div> 657,000원 </div>
			<div> 노트북 팝니다. 노트북 팝니다.<br/> 노트북 팝니다. 노트북 팝니다. 노트북 팝니다</div>
			<div>
				<button type="button">찜하기♡</button>
				<button type="button">바로구매</button>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6627d92a562d0e01aed3c8ae1c67211e"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/view/view.js" type="text/javascript"></script>
</body>
</html>