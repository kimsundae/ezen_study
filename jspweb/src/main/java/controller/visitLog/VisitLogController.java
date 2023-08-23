package controller.visitLog;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.member.VisitDto;
import model.dao.VisitDao;

/**
 * Servlet implementation class VisitLogController
 */
@WebServlet("/VisitLogController")// 해당 서블릿(자바)/컨트롤러 클래스를 호출하는 HTTP 매핑주소
public class VisitLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisitLogController() {super();}
    // 1. 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX의 DATA속성에 있는 객체 정보(속성명이용)을 호출하기
		String vwriter = request.getParameter("vwriter"); System.out.println("vwriter : " + vwriter);
		String vpwd = request.getParameter("vpwd"); System.out.println("vpwd : " + vpwd);
		String vcontent = request.getParameter("vcontent"); System.out.println("vcontent : " + vcontent);
		// 2. 객체화
		VisitDto visitDto = new VisitDto( vwriter , vpwd , vcontent ); System.out.println(visitDto.toString());
		// 3. DAO 객체 전달 후 응답받고
		boolean result = VisitDao.getInstance().vwrite(visitDto);
		response.setContentType("application/json;charset=UTF-8");
		// 4. 결과를 AJAX에게 응답한다.
		response.getWriter().print(result);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 [ x ] : 모든 글 출력은 조건이 없으므로 요청값 없다. VS 개별 글 출력 : 조건이 출력할 글 번호
		// 2. 객체화 [ x ] 
		// 3. DAO
		ArrayList<VisitDto> result = VisitDao.getInstance().vread();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(result);
		response.setContentType("application/json;charset=UTF-8");
		// 4. 응답
		response.getWriter().print(jsonArray); // 응답은 가능하나.. js가 ArrayList타입 사용이 불가능 [ 문제 발생 ]
	}

	


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX data 데이터 요청한다.
			// request.getParameter("속성명"); String 반환
		int vno = Integer.parseInt(request.getParameter("vno"));
		String vcontent = request.getParameter("vcontent");
		String vpwd = request.getParameter("vpwd");
		System.out.println(vno + " " + vcontent + " " + vpwd);
		// 2. (데이터 많으면) 객체화
		// 3. Dao 에게 전달 후 SQL 결과를 받는다.
		// 4. 결과를 AJAX에게 전달한다.
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX data 데이터 요청한다.
		int vno = Integer.parseInt(request.getParameter("vno"));
		String vpwd = request.getParameter("vpwd");
		System.out.println(vno  + " " + vpwd);
		// 2. (데이터 많으면) 객체화
		// 3. Dao 에게 전달 후 SQL 결과를 받는다.
		// 4. 결과를 AJAX에게 전달한다.
	}
	/*
	 *  - HTTP 서블릿 클래스는 기본적으로 get,post,put,delete 함수 제공
	 *  - 기본 톰캣서버는 get,post만 매개변수(데이터) 전달 가능
	 *  - put,delete 함수도 매개변수 전달 가능하도록 설정 [서버마다 설정]
	 *  server.xml
	 *  	63줄쯤 원본 코드
	 *  		    <Connector connectionTimeout="20000" maxParameterCount="1000" port="80" protocol="HTTP/1.1" redirectPort="8443"/>
	 *  	put,delete에도 매개변수 전달가능하도록 
	 *  
	 */
	

}
