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
			<table>
				<tr>
					<th>학년</th><th>반</th><th>번호</th>
					<th>이름</th><th>국어</th><th>수학</th>
					<th>영어</th><th>역사</th><th>합계</th>
					<th>평균</th><th>순위</th>
				</tr>
				<%
	
					List<Map<String,String>> list = new Dao().getScoreList();
					int korSum = 0, mathSum = 0, engSum = 0, histSum = 0, sumSum = 0, avrSum = 0 ,count = 0;
					double korAvr = 0, mathAvr = 0, engAvr = 0, histAvr = 0, sumAvr = 0, avrAvr = 0 ;

					for( int i = 0; i < list.size(); i++){
					
						Map<String,String> map = list.get(i);	
						korSum += map.get("ekor") != null ? Integer.parseInt( map.get("ekor") ) : 0; 
						mathSum += map.get("emath") != null ? Integer.parseInt( map.get("emath") ) : 0;
						engSum +=  map.get("eeng") != null ? Integer.parseInt( map.get("eeng") ) : 0; 
						histSum += map.get("ehist") != null ? Integer.parseInt( map.get("ehist") ) : 0;
						sumSum += Integer.parseInt( map.get("sum") ); 
						avrSum += Integer.parseInt(map.get("avr"));
						count += map.get("sum").equals("0") ? 0 : 1;
						
						
						char[] studentNumber = map.get("sno").toCharArray();
				%>
					<tr>
						<td> <%=studentNumber[0] %> </td>
						<td> <%=""+studentNumber[1]+studentNumber[2] %> </td>
						<td>  <%=""+studentNumber[3]+studentNumber[4] %> </td>
						<td> <%=map.get("sname") != null ? map.get("sname") : "" %></td>
						<td> <%=map.get("ekor") != null ? map.get("ekor") : "" %> </td>
						<td> <%=map.get("emath") != null ? map.get("emath") : "" %> </td>
						<td> <%=map.get("eeng") != null ? map.get("eeng") : "" %> </td>
						<td> <%=map.get("ehist") != null ? map.get("ehist") : "" %> </td>
						<td> <%=!map.get("sum").equals("0") ?  map.get("sum") : ""  %> </td>
						<td> <%=!map.get("avr").equals("0") ? map.get("avr") : "" %> </td>
						<td> <%=map.get("sum").equals("0") ? "" :  i+1 %> </td>
					</tr>
				
				<%} %>
				
				<tr>
					<td colspan="4">총 합</td><td><%=korSum %></td><td><%=mathSum %></td>
					<td><%=engSum %></td><td><%=histSum %></td><td><%=sumSum %></td><td><%=Math.round(avrSum) %></td><td></td>
				</tr>
				<tr>
					<td colspan="4">총평균</td><td><%= korSum / count %></td><td><%=mathSum / count %></td>
					<td><%=engSum / count %></td><td><%=histSum / count %></td><td><%=sumSum / count %></td><td><%=avrSum / count %></td><td></td>
				</tr>
			</table>
		
		</center>
	
	</div>
	<%@ include file="./footer.jsp" %>
</body>
</html>