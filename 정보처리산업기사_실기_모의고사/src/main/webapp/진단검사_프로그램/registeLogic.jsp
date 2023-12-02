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
	<%
		request.setCharacterEncoding("UTF-8");
		String p_no = request.getParameter("p_no");
		String t_code = request.getParameter("t_code");
		String t_sdate = request.getParameter("t_sdate");
		String checkStatus = request.getParameter("checkStatus");
		String t_ldate = request.getParameter("t_ldate");
		String checkResult = request.getParameter("checkResult");
		new Dao().registe( p_no, t_code, t_sdate, checkStatus, t_ldate, checkResult );
		
		response.sendRedirect("./index.jsp");
		
	%>
</body>
</html>