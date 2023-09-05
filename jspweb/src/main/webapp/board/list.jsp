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
				
				<select class="bbtn"><!-- 하나의 페이지에 표시할 최대 게시물 수  -->
					<option>10</option>
					<option>15</option>
					<option>20</option>
				</select>
				<span class="boardcount"> 전체 게시물 수 : 13 </span><!-- 전체 게시물 수  -->
			</div>	
			
			<button class="bbtn" onclick="onWrite()" type="button"> 글쓰기 </button>	
			
		</div>	
		
		<div class="category">
			<button class ="bbtn" type="button"> 전체 </button>
			<button class ="bbtn" type="button"> 공지사항 </button>	
			<button class ="bbtn" type="button"> 자유게시판 </button>
			<button class ="bbtn" type="button"> 노하우 </button>
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
				<button type="button"> < </button>	<!-- 이전버튼 -->
					<button type="button"> 1 </button>	<!-- 페이징 버튼 -->
					<button type="button"> 2 </button>
					<button type="button"> 3 </button>
					<button type="button"> 4 </button>
					<button type="button"> 5 </button>
					<button type="button"> 6 </button>			
				<button type="button"> > </button>	<!-- 다음버튼  -->
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