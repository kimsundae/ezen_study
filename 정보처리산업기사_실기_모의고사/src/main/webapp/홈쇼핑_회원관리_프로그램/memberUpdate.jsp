<%@page import="홈쇼핑_회원관리_프로그램.Dao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th{border:1px solid #e8e8e8;}
	tr{border:1px solid #e8e8e8;}
	td{border:1px solid #e8e8e8;}
</style>
</head>
<body>
	<%@ include file="./header.jsp" %>

	<div class="wrap">
		<center><h1>회원목록조회/수정</h1>
			<table style="border:1px solid #e8e8e8;">
				<tr>
					<th width="10%">회원번호</th><th width="10%">회원성명</th><th width="10%">전화번호</th>
					<th width="30%">주소</th><th width="10%">가입일자</th><th width="10%">고객등급</th><th width="10%">거주지역</th>
				</tr>
				<%
					List<Map<String,String>> list = new Dao().getList();
					for( int i = 0; i < list.size(); i++ ){
						Map<String,String> map = list.get(i);
				%>
				<tr style="border:1px solid #e8e8e8;" >
					<td width="10%" style="text-align: center; color:white;" ><a href="./update.jsp?custno=<%= map.get("custno") %>"><%= map.get("custno") %></a> </td>
					<td width="10%" style="text-align: center;"> <%= map.get("custname") %> </td>
					<td width="10%" style="text-align: center;"> <%= map.get("phone") %> </td>
					<td width="30%" style="text-align: center;"> <%= map.get("address") %> </td>
					<td width="10%" style="text-align: center;"> <%= map.get("joindate").split(" ")[0] %> </td>
					<td width="10%" style="text-align: center;"> <%= map.get("grade") %> </td>
					<td width="10%" style="text-align: center;"> <%= map.get("city") %> </td>
				</tr>
				
			
				<%} %>
			</table>
		</center>
	</div>
	
	<%@ include file="./footer.jsp" %>

</body>
</html>