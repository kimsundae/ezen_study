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
			<h1>후보조회</h1> 
		
		<table>
			<tr>
				<th>후보번호</th><th>성명</th><th>소속정당</th>
				<th>학력</th><th>주민번호</th><th>지역구</th>
				<th>대표전화</th>
			</tr>
			<%
			List<Map<String, String>> list = new Dao().getMemberList();
			for( int i = 0; i < list.size(); i++){
				Map<String,String> map = list.get(i);
				int school = Integer.parseInt( map.get("p_school") );
			%>
			<tr>
				<td><%= map.get("m_no") %></td>
				<td><%= map.get("m_name") %></td>
				<td><%= map.get("p_name") %></td>
				<td><%= school == 1 ? "고졸" : school == 2 ? "학사" : school == 3 ? "석사" : "박사"  %> </td>
				<td><%= map.get("m_jumin") %></td>
				<td><%= map.get("m_city") %></td>
				<td><%= map.get("p_tel1") + '-' + map.get("p_tel2") + '-' + map.get("p_tel3") %></td>
			</tr>
		
			<%}%>
		</table>
		
		
		</center>
	</div>


	<%@ include file="./footer.jsp" %>
</body>
</html>