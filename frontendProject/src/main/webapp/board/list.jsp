<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 뷰포트 : 반응형 동작 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 부트스트랩에서 만든 CSS  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

</head>
<body>

	<!--
		부트스트랩 : 미리 만들어진 CSS/JS 빠르게 적용
			설치/적용 
				1. <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
				2. <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
			-
				1. .container : 반응형 구역
				2. 그리드 : 해당 구역 12조각
					.row		: 하위 요소 가로 배치
					.col		: 열
					.col-조각수	: 열-그리드 수
					justify-content-md-center : 가로배치 가로정렬
					.g-여백수		: 커터 열마다 자동여백[24px] g-0[여백제거]
				2. 
					.table			: 테이블 기본 CSS
					.table-striped	: 행마다 홀/짝 구별 생상
					.table-hover 	: 행에 마우스를 올렸을 때 색상
					.table-bordered : 테이블 테두리
				3. text-center		: 하위 요소 가운데 정렬
				4. .navigation		: 페이지네이션 / 페이징처리 버튼
				5. .form-select		: 셀렉트 상자 꾸미기
				6. .form-control	: input 상자 꾸미기
				
	  -->
	<%@include file="../header.jsp" %>
	<!-- CSS/JS 관련 라이브러리( 미리 만들어진 CSS/JS )제공 -->
	
	<div class="container"><!-- 현재 게시물출력 페이지 전체 구역  -->
		<h3> 커뮤니티 </h3>
		<a href="write.jsp"><button type="button" class="btn btn-outline-secondary">글쓰기</button></a>
		<table class="table table-striped table-hover table-bordered text-center"><!-- 테이블 -->	
			<thead class="table-light">
				<tr>
					<th width="5%">번호</th> <th width="55%">제목</th> <th width="10%">작성자</th> <th width="10%">작성일</th>
					<th width="10%">조회수</th> <th width="10%">추천수</th> 
				</tr>
			</thead>
			<tbody class="tcontent">
				<!-- boardPrint() 함수가 inner 되는 구역  -->
			</tbody>
			<tfoot>
				<tr><td colspan="6">total 3</td></tr>
			</tfoot>
		</table> <!-- 테이블end -->
		
		<!-- 페이징처리 구역 -->
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link">이전</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">다음</a>
		    </li>
		  </ul>
		</nav>
		
		<!-- 검색 창 구역  -->
		<div class="row justify-content-md-center gx-0	"><!-- 구역마다 12조각  -->
			<div class="col-2">
				<select class="form-select">
					<option> 키워드 </option> <option> 번호 </option> <option> 제목 </option> <option> 작성자 </option>
				</select>
			</div>
			<div class="col-3">
				<input type="text" class="form-control">
			</div>
			<div class="col-1">
				<button class="form-control">검색</button>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
	
	<script src="../JS/list.js" type="text/javascript"></script>
	<!-- 부트스트랩에서 만든 JS 적용  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>