<%@page import="홈쇼핑_회원관리_프로그램.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Dao dao = new Dao();
		request.setCharacterEncoding("UTF-8");
	
		String custno = request.getParameter("custno");
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		System.out.println( custno + custname + phone + address + joindate + grade + city );
		boolean result = dao.registe( custno, custname, phone, address, joindate, grade, city );
		System.out.println(result);
		
		response.sendRedirect("./memberRegiste.jsp");
	
		
	%>


</body>
</html>