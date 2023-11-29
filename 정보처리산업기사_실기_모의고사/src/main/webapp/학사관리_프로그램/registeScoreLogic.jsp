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
	<%
		request.setCharacterEncoding("UTF-8");
		String sno = request.getParameter("sno");
		String ekor = request.getParameter("ekor");
		String emath = request.getParameter("eeng");
		String eeng = request.getParameter("eeng");
		String ehist = request.getParameter("ehist");
		System.out.println(sno);
		System.out.println(ekor);
		System.out.println(emath);
		System.out.println(eeng);
		System.out.println(ehist);
		boolean result = new Dao().registeScore( sno, ekor, emath, eeng, ehist );
		System.out.println(result);
		response.sendRedirect("./registeScore.jsp");
	%>
	
</body>
</html>