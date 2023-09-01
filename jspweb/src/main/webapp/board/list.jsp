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
		<div class="category">
			<button type="button"> 전체 </button>
			<button type="button"> 공지사항 </button>
			<button type="button"> 자유게시판 </button>
			<button type="button"> 노하우 </button>
		</div>
		<div>
			<button onclick="onWrite()" type="button"> 글쓰기 </button>
		</div>	
		<table class="board">
				<tr>
					<th>게시글 번호</th>
					<th width="60%">제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<tr class="list">
					<td>1</td>
					<td>안녕하세요</td>
					<td>홍길동</td>
					<td>2014/2/3</td>
					<td>10</td>
				</tr>
		</table>											
	</div>
	<script src="/jspweb/js/list.js" type="text/javascript"></script>
</body>
</html>