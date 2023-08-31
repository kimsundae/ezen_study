package model.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberFindController
 */
@WebServlet("/MemberFindController")
public class MemberFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberFindController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청한다.
		String type = request.getParameter("type");
		String data = request.getParameter("data");
		// 2. 객체화/유효성검사
		// 3. DAO 요청결과
		boolean result = MemberDao.getInstance().findIdOrEmail( type , data);
		System.out.println(result);
		// 4. 결과 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 매개변수 요청한다.
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		
		// 2. (객체화/유효성검사)
		
		// 3. DAO에게 전달 후 결과 받기
		boolean result = MemberDao.getInstance().login(mid, mpwd);
		
		// - 만약에 로그인 성공하면 세션에 로그인한 정보를 담기..
		if( result == true ) {
			// 1. 세션에 저장할 데이터를 만든다.
			
			// 2. 세션에 저장한다.
			request.getSession().setAttribute( "로그인인증서" , 3 );
		}
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);	
	}
}

/*
 * 	로그인 했다는 중거 => 인증 [ 인증서 -> 세션 저장 ]
 * 		JS : sessionStorage
 * 			세션저장 : sessionStorage.setItem( 키 , 데이터 );
 * 			세션호출 : sessionStorage.getItem( 키 );
 * 
 * 		JAVA(서블릿) : request.getSession()
 * 			세션저장 : request.getSession().setAttribute( "속성명" , 데이터 );
 * 			세션호출 : request.getSession().getAttribute( "속성명" );
 * 
 * 	서블릿
 * 		내장객체
 * 			request : 요청객체
 * 				request.getParameter() 						: ajax로 부터 전달된 데이터 요청
 * 				request.getServletContext().getRealPath()	: 서블릿 저장소의 실제 경로 
 * 			response : 응답객체
 * 				response.getWriter().print()	: ajax에게 전달할 데이터 응답
 * 				response.setContentType("application/json;charset=utf-8"); [ 데이터 타입 설정 ]
 * 
 * 
 */
