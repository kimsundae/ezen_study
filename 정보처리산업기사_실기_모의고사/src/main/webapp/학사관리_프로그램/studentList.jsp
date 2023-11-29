<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="학사관리_프로그램.Dao"%>

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
			<h2>학생목록</h2>
			<table>
				<tr>
					<th>학번</th><th>이름</th><th>학년</th><th>반</th><th>번호</th>
					<th>성별</th><th>전화번호</th><th>주소</th>
				</tr>
				<%
					List<Map<String,String>> list = new Dao().studentList();
					for( int i = 0; i< list.size(); i++){
						Map<String,String> map = list.get(i);
						char[] studentNumber = map.get("sno").toCharArray();
				%>
				<tr>
					<td> <%=map.get("sno") %> </td>
					<td> <%=map.get("sname") %> </td>
					<td> <%=studentNumber[0] %> </td>
					<td> <%=""+studentNumber[1]+studentNumber[2] %> </td>
					<td> <%=""+studentNumber[3]+studentNumber[4] %> </td>
					<td> <%=map.get("sgender").equals("M") ? "남" : "여" %> </td>
					<td> <%=map.get("sphone") %> </td>
					<td> <%=map.get("sadress") %> </td>
				</tr>
				<%} %>
			</table>
		</center>
	</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>