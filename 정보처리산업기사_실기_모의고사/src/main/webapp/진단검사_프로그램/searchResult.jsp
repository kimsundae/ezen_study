<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="진단검사_프로그램.Dao"%>
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
			<h2>검사결과조회</h2>
			<table>
				<tr>
					<th>환자번호</th><th>환자명</th><th>검사명</th>
					<th>검사시작일</th><th>검사상태</th><th>검사완료일</th>
					<th>검사결과</th>
				</tr>
				<%
					List<Map<String,String>> list = new Dao().getResultList();
					for(int i = 0; i < list.size(); i++ ){
					Map<String,String> map = list.get(i);
				%>
					<tr>
						<td><%=map.get("p_no") %></td>
						<td><%=map.get("p_name") %></td>
						<td><%=map.get("t_name") %></td>
						<td><%=map.get("t_sdate").split(" ")[0] %></td>
						<td><%=map.get("t_status").equals("1") ? "검사중" : "검사완료" %></td>
						<td><%=map.get("t_ldate").split(" ")[0] %></td>
						<td><%=map.get("t_result").equals("X") ? "미입력" : map.get("t_result").equals("P") ? "양성"  : "음성"%></td>
					</tr>
				<%}%>
			</table>
		</center>
	</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>