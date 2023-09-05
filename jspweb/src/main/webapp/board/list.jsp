<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">	
<title>Insert title here</title>
	<link href="/jspweb/css/list.css" rel="stylesheet">
</head>
<body>

	<%@include file="../header.jsp"%>
	<div class="webcontainer">
		
		<div class="boardtop">
			<h2> 게시판 </h2>
			<p> 다양한 사람들과 정보를 공유 하세요. </p>
		</div>
		
		<div class="boardtopetc">		
			<div>	
				<select onChange="onListSize()" class="listsize bbtn"><!-- 하나의 페이지에 표시할 최대 게시물 수  -->
					<option value="10">10</option>
					<option value="15">15</option>
					<option value="20">20</option>
				</select>
				<span class="boardcount"> 전체 게시물 수 : 13 </span><!-- 전체 게시물 수  -->
			</div>	
			
			<button class="bbtn" onclick="onWrite()" type="button"> 글쓰기 </button>	
			
		</div>	
		
		<div class="category">
			<button onclick="onCategory(0)" class ="bbtn" type="button"> 전체보기 </button>
			<button onclick="onCategory(1)" class ="bbtn" type="button"> 공지사항 </button>	
			<button onclick="onCategory(2)" class ="bbtn" type="button"> 자유게시판 </button>
			<button onclick="onCategory(3)" class ="bbtn" type="button"> 노하우 </button>
		</div>
		
		<table class="boardTable">
				<tr>
					<th>게시글 번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>조회수</th>
					<th>작성일</th>				
				</tr>
		</table>		
		
		<!-- 5. 페이징처리 구역 -->
		<div class="boardbottom">
			<div class="pagebox">
				
			</div>				
			<!-- 6. 검색 구역 -->				
			<select class="bbtn">	<!-- 검색할 필드명 -->
				<option> 제목 </option>
				<option> 내용 </option>
				<option> 작성자 </option>
			</select>
			<input class="keyword" type="text"><!-- 검색 내용 -->
			<button class="bbtn" type="button">검색</button>
		</div>							
	</div>
	<script src="/jspweb/js/list.js" type="text/javascript"></script>
</body>
</html>