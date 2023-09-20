<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/wishList/wishList.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<%@ include file="../../header.jsp" %>
	<div class="container"><!-- bs: container 디바이스 크기에 따른 반응형 구역 -->
		<table class="table table-hover table-striped align-middle"> 
		    <tr>
		      <th width="5%"><input class="checkbox" type="checkbox"></th>
		      <th width="5%">이미지</th>
		      <th width="40%">제품 정보</th>
		      <th width="10%">가격</th>
		      <th width="10%">비고</th>
		    </tr>

		    <tr>
		      <td><input class="checkbox" type="checkbox"></td>
		      <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT31IFBHgVxP_iQ06NEQkF1BddtLx6ONwBUfA&usqp=CAU" width="100%"/></td>
		      <td>팝니다111</td>
		      <td>33121</td>
		      <td><button type="button">X</button></td>
		    </tr>
		    
		    <tr>
		      <td><input class="checkbox" type="checkbox"></td>
		      <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT31IFBHgVxP_iQ06NEQkF1BddtLx6ONwBUfA&usqp=CAU" width="100%"/></td>
		      <td >팝니다</td>
		      <td>33333</td>
		      <td><button type="button">X</button></td>
		    </tr>		   
		</table>
		<div class="selectbtn">
			<button  type="button">선택 삭제</button>
			<button  type="button">전체 삭제</button>
		</div>
		<div class="buybtn">
			<button  type="button">선택 구매</button>
			<button  type="button">전체 구매</button>
		</div>
		
	</div>

	<script src="/jspweb/js/wishList/wishList.js" type="text/javascript"></script>
	
</body>
</html>