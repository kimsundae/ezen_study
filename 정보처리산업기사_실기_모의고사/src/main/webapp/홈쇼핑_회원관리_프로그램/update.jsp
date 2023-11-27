<%@page import="홈쇼핑_회원관리_프로그램.Dao"%>
<%@page import="java.util.Map"%>
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
		<center> <h1>홈쇼핑 회원 정보 수정</h1> </center>
		
		<%
			int custno = Integer.parseInt(request.getParameter("custno"));
			
			Map<String,String> map = new Dao().getMember(custno);
		
			
		%>
		
		<center>
			<form name="updateForm" method="post" action="updateLogic.jsp?beforeCustno= <%= custno %> ">
				<div>회원번호(자동발생) <input type="text" value= <%= map.get("custno") %> name="custno"/></div>
				<div>회원성명 <input type="text" value = <%= map.get("custname") %> name="custname"/></div>
				<div>회원전화 <input type="text" value = <%= map.get("phone") %> name="phone"/></div>
				<div>회원주소 <input type="text" value = <%= map.get("address") %> name="address"/></div>
				<div>가입일자 <input type="text" value = <%= map.get("joindate").split(" ")[0] %> name="joindate"/></div>
				<div>고객등급 [A:VIP,B:일반,C:직원] <input type="text" name="grade" value = <%= map.get("grade") %> /></div>
				<div>도시코드 <input type="text" name="city" value= <%= map.get("city") %> /></div>
				<div><center><button type="button" onclick="onUpdate()">수정</button><button type="button">조회</button></center></div>
				</form>
		</center>
	
	</div>
	<%@ include file="./footer.jsp" %>
	
	<script>
		function onUpdate(){
			alert('회원정보수정이 완료 되었습니다.')
			document.updateForm.submit();
		}
	</script>
</body>
</html>