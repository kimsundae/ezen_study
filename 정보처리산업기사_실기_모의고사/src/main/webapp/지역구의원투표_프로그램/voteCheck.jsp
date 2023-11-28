<%@page import="java.time.LocalDate"%>
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
				<h2>투표검수조회</h2>
				<table>
					<tr>
						<th>성명</th><th>생년월일</th><th>나이</th><th>성별</th>
						<th>후보번호</th><th>투표시간</th><th>유권자확인</th>
					</tr>
					<%
						List<Map<String,String>> list = new Dao().voteList();
						for( int i = 0; i < list.size(); i++ ){
							Map<String,String> map = list.get(i);
							char[] jumin = map.get("v_jumin").toCharArray();
							String birth = 
									"19" + jumin[0] + jumin[1]+"년"
										+ jumin[2] + jumin[3]+"월"
											+ jumin[4] + jumin[5]+"일생";
							int afterBirth = Integer.parseInt(""+jumin[2]+jumin[3]+jumin[4]+jumin[5]) 
							- Integer.parseInt(LocalDate.now().getMonthValue() + "" + LocalDate.now().getDayOfMonth())
							>= 0 ? 1 : 0;
							int age = LocalDate.now().getYear() - Integer.parseInt("19"+jumin[0]+jumin[1]) - afterBirth;
							char[] time = map.get("v_time").toCharArray();
					%>
					<tr>
						<td> <%=map.get("v_name") %> </td>
						<td> <%=birth %> </td>
						<td> <%="만 "+age+"세" %> </td>
						<td> <%=map.get("v_jumin").charAt(6) == '1' ? "남" : "여" %> </td>
						<td> <%=map.get("m_no") %> </td>
						<td> <%=""+time[0]+time[1]+":"+time[2]+time[3] %> </td>
						<td> <%=map.get("v_confirm").equals("N") ? "미확인" : "확인" %> </td>
					</tr>
				
					<%}%>
				
				</table>
			</center>
			
			
		</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>