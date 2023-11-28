<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	*{ margin:0px; padding:0px;}
	.wrap{background-color: gray; min-height: 600px;}
	a{text-decoration:none; color: white;}
	tr{border:1px solid black;}
	th,td{padding:5px; text-align:center;border:1px solid black;}
</style>
<body>
	<center style="background-color:skyblue;color:white; padding: 30px;">
		<h1>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2020-05</h1>
	</center>
	<div style="width:100%; background-color:purple;"> 
		<div style="width:500px;display:flex; justify-content: space-between; margin-left:10px; padding:10px;">
			<a href="./memberFind.jsp">후보조회</a><a href="./vote.jsp">투표하기</a><a href="./voteCheck.jsp">투표검수조회</a>
			<a href="./memberNo.jsp">후보자등수</a><a href="./index.jsp">홈으로</a>
		</div>
	</div>
</body>
</html>