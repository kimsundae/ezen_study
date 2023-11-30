<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{margin:0px;padding:0px;}
	a{text-decoration:none;color:white;}
	.wrap{min-height:700px; background-color:#e8e8e8; border: 3px solid black;}
	tr,th,td{ text-align:center; border: 1px solid black; padding:4px;}
	table{border-collapse:collapse;}
</style>
</head>
<body>
	<center style="padding:20px;background-color:blue;color:white; border:3px solid black;">
		<h1>학사관리 프로그램</h1>
		
	</center>
	<div style="width:100%; background-color:purple;border:3px solid black;">
		<div style="width:400px; display:flex; justify-content:space-between;margin-left:10px;padding:10px;">
			<a href="./studentList.jsp">학생목록</a><a href="./registeScore.jsp">성적입력</a>
			<a href="./studentScoreList.jsp">학생성적</a><a href="./index.jsp">홈으로</a>
		</div>
	</div>
</body>
</html>