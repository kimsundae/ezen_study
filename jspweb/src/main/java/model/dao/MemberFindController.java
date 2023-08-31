package model.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

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
			MemberDto loginDto = MemberDao.getInstance().info(mid);
			// 2. 세션에 저장한다.
			request.getSession().setAttribute( "loginDto" , loginDto );
			// 세션 상태 확인
			MemberDto dto = (MemberDto)request.getSession().getAttribute("loginDto");
			System.out.println("세션 상태 : " + dto);
		}
		
		// 4. 결과를 응답한다.
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);	
	}
}

/*	
 * - 저장소
 * 	1. JAVA/JS 메모리
 * 		- JAVA 종료되거나 JS종료/페이지전환/새로고침 되면 휘발성/초기화/사라짐
 * 		- DTO 이동객체 ,  로직 필요한 변수들 ( 생성조건에 따라 사용범위가 다름 )
 * 		
 * 		세션( static ) : 모든 곳에서 동일한 메모리 사용	[ 문자열 타입 ]
 * 			- 장점 : 모든 곳에서 동일한 메모리 (동일한 주소값) 사용
 * 			- 단점 : 프로그램/서버가 종료될 때까지 유지( 메모리 ) 
 * 			- 로그인정보 : 페이지전환 되더라도 로그인상태 유지
 * 			- 실제 데이터
 * 	2. DB 메모리
 * 		- 영구 저장 [ 논리구조(관계형/표) 저장 ]
 * 		- 회원정보,게시판정보,제품정보 등등
 * 		- 실제 데이터
 * 	3. 파일
 * 		- 영구 저장[ 문자열 저장 ]
 * 		- 로그/기록 ( 예외처리 오류 정보 , 접속수 , 최상위 보안 자료 )
 * 	4. 세션
 * 	로그인 했다는 중거 => 인증 [ 인증서 -> 세션 저장 ]
 * 		JS : sessionStorage
 * 			세션타입 : 문자열 타입 ( 타입변환 필수! )
 * 			세션저장 : sessionStorage.setItem( 키 , 데이터 );
 * 			세션호출 : sessionStorage.getItem( 키 );
 * 
 * 		JAVA(서블릿) : request.getSession() : 모든 서블릿에서 사용가능한 메모리 공간 [ Object ]
 * 			- 세션 타입 : Object
 * 			세션저장 : request.getSession().setAttribute( "속성명" , 데이터 );
 * 			세션호출 : request.getSession().getAttribute( "속성명" );
 * 			세션내 속성초기화
 * 				1. 세션의 모든 속성 초기화하는 함수
					request.getSession().invalidate(); 				
				2 :세션의 특정 속성 JVM GC(쓰레기수집기 = 해당 객체를 아무도 참조하고 있지 않으면 삭제)
				 	삭제할 세션속성명과 동일하게 null 대입
				  	request.getSession().setAttribute("loginDto", null);
 * 
 * 	서블릿 클래스
 * 		내장객체
 * 			request : 요청객체
 * 				request.getParameter() 						: ajax로 부터 전달된 데이터 요청
 * 				request.getServletContext().getRealPath()	: 서블릿 저장소의 실제 경로 
 * 
 * 			response : 응답객체
 * 				response.getWriter().print()	: ajax에게 전달할 데이터 응답
 * 				response.setContentType("application/json;charset=utf-8"); [ 데이터 타입 설정 ]
 * 
 * 
 */
