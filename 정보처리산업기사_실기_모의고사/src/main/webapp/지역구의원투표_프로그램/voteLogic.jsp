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
	<%
		request.setCharacterEncoding("UTF-8");
	
		String jumin = request.getParameter("jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String check = request.getParameter("check");
		
		System.out.println( jumin );
		System.out.println( v_name );
		System.out.println( m_no );
		System.out.println( v_time );
		System.out.println( v_area );
		System.out.println( check );
		new Dao().onVote( jumin, v_name, m_no, v_time, v_area, check );
		
		response.sendRedirect( "./index.jsp" );
	%>
</body>
</html>