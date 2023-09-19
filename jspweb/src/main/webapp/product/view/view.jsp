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
			<div class="mid">판매자 : 강호동</div>
			<div class="categorydate">
				<div class="pcname">카테고리 : 노트북 </div>
				<div class="pdate">등록일 :  2023-09-19 11:47 </div>
			</div>
			<div class="pname">노트북 팝니다.</div>	
			<div class="pprice"> 657,000원 </div>
			<div class="pcontent"> 
				노트북 팝니다. 노트북 팝니다.
				<br/> 노트북 팝니다. 노트북 팝니다. 노트북 팝니다
			</div>
			<div class="etcbtnbox">
				<button type="button">찜하기♡</button>
				<button type="button">바로구매</button>
			</div>
			<!-- 1. 탭 목록 -->
			<ul class="mt-5 nav nav-pills nav-fill" id="myTab" role="tablist">
			  <li class="nav-item" role="presentation">
			    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#navTab1" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">
			   		 제품위치
			    </button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#navTab2" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">
			   		 제품후기
			    </button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#navTab3" type="button" role="tab" aria-controls="contact-tab-pane" aria-selected="false">
			  	  	QnA
			    </button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="disabled-tab" data-bs-toggle="tab" data-bs-target="#navTab4" type="button" role="tab" aria-controls="disabled-tab-pane" aria-selected="false" >
			   		 구매 유의사항 
			   	 </button>
			  </li>
			</ul>
			<!-- 2.탭 내용 -->
			<div class="my-2 tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="navTab1" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
					 제품위치 출력되는 구역
			  </div>
			  <div class="tab-pane fade" id="navTab2" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
					제품후기 구역
			  </div>
			  <div class="tab-pane fade" id="navTab3" role="tabpanel" aria-labelledby="contact-tab" tabindex="0">
			 		QnA 출력되는 구역
			  </div>
			  <div class="tab-pane fade" id="navTab4" role="tabpanel" aria-labelledby="disabled-tab" tabindex="0">
					구매 유의사항 출력되는 구역 
			  </div>
			</div>
			
		</div>
	</div>
	
	
	
	
	
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6627d92a562d0e01aed3c8ae1c67211e"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/view/view.js" type="text/javascript"></script>
</body>
</html>