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
			<h2>환자조회</h2>
			<table>
				<tr>
					<th>환자번호</th><th>환자성명</th><th>생년월일</th><th>성별</th><th>전화번호</th>
					<th>지역</th>
				</tr>
				<%
					List<Map<String,String>> list = new Dao().searchPatient();
					for( int i = 0; i < list.size(); i++ ){
					Map<String,String> map = list.get(i);
					String city = "";
					switch( map.get("p_city") ){
						case "10" :
							city = "서울";break;
						case "20" :
							city = "경기";break;
						case "30" :
							city = "강원";break;
						case "40" :
							city = "대구";break;
					}
					char[] birth = map.get("p_birth").toCharArray();
				%>
				<tr>
					<td><%=map.get("p_no") %></td><td><%=map.get("p_name") %></td>
					<td><%="" + birth[0] + birth[1] + birth[2] + birth[3] +"년" + birth[4] + birth[5] + "월" + birth[6] + birth[7] + "일" %></td>
					<td><%=map.get("p_gender").equals("M") ? "남" : "여" %></td><td><%=map.get("p_tel") %></td>
					<td><%=city %></td>
				</tr>
				
				<% } %>
			
			</table>
		</center>
		</div>
		
	<%@ include file="./footer.jsp" %>	
</body>
</html>