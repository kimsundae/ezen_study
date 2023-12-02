<%@page import="진단검사_프로그램.Dao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
			<h2>(지역별)검사건수통계</h2>
			<table>
				<tr>
					<th>지역코드</th><th>지역명</th><th>검사건수</th>
				</tr>
				<%
					List<Map<String,String>> list = new Dao().getLocalSta();
					for( int i = 0; i < list.size(); i++ ){
						Map<String,String> map = list.get(i);
				%>
					<tr>
						<td><%=map.get("p_city") %></td>
						<td><%=map.get("p_city_name") %></td>
						<td><%=map.get("count") %></td>
					</tr>
				<% } %>
			</table>
		</center>
		
	
	
	</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>