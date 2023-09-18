<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	
	<!-- JSP파일 안에 다른 JSP 파일 import하기 -->
	<%@include file ="header.jsp" %>
	
	<!-- 대문  -->
	<div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
		<div class="carousel-indicators">
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	  </div>
	  <div class="carousel-inner">
	    <div class="carousel-item active" data-bs-interval="2000">
	      <img src="https://image.nbkorea.com/NBRB_Site/20230907/NB20230907082016334001.jpg" class="d-block w-100" alt="...">    	
	    </div>
	    <div class="carousel-item" data-bs-interval="2000">
	      <img src="https://image.nbkorea.com/NBRB_Site/20230907/NB20230907155403443001.jpg" class="d-block w-100" alt="...">    	
      	</div>	   
	    <div class="carousel-item" data-bs-interval="2000">
	      <img src="https://image.nbkorea.com/NBRB_Site/20230901/NB20230901092736430001.jpg" class="d-block w-100" alt="...">
      	</div>
      </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
	
	<div class="container">
		<div class="productBox row row-cols-1 row-cols-md-4 g-4">
			  
		</div>
	</div>
	<!-- JSP파일 안에 다른 JSP 파일 import 하기  -->
	<%@include file ="footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	<script src="/jspweb/js/index.js" type="text/javascript"></script>
</body>
</html>