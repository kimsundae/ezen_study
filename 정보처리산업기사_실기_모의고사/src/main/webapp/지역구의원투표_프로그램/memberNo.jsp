<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="지역구의원투표_프로그램.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./header.jsp" %>
	<div class="wrap">
		<center>
			<h1>후보자 등수</h1>
			<table>
				<tr>
					<th>후보번호</th><th>성명</th><th>총투표건수</th>
				</tr>
				<%
				 List<Map<String,String>> list = new Dao().getNoList();
					for( int i = 0; i< list.size(); i++){
						Map<String,String> map = list.get(i);
					
				%>
				<tr>
					<th><%= map.get("m_no") %></th>
					<th><%= map.get("m_name") %></th>
					<th><%= map.get("count") %></th>
				</tr>	
				
				<%} %>
			</table>
		</center>
	
	</div>

	<%@ include file="./footer.jsp" %>
</body>
</html>