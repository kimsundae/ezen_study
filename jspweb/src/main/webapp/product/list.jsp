<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<link href="/jspweb/product/list.css" rel="stylesheet">
<body>

	<%@include file ="../header.jsp" %>
	<div class="mapcontent"> <!-- 지도와 사이드바 포함된 구역  -->
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>
		
		<!-- 사이드바 구역 -->
		<div class="sidebar"></div>
	</div>


	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6627d92a562d0e01aed3c8ae1c67211e&libraries=clusterer"></script>
	<script src="list.js" type="text/javascript"></script>		
</body>
</html>