package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.MemberDao;
import model.dto.MemberDto;


/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 첨부파일 저장할 폴더의 절대 경로
		// 1. 개발자 pc경로에 업로드할 경우 업로드파일을 수시로 서버로 빌드하게 됨
		//String uploadPath = "C:\\Users\\504\\git\\ezen_study\\jspweb\\src\\main\\webapp\\member\\img"; // 첨부파일 저장할 경로
		// 2. 서버 pc 경로 업로드 [ 사용자는 바로 서버pc 업로드 ]
		//String uploadPath = "C:\\Users\\504\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\jspweb\\member\\img";
		// 3. 서버 pc 경로( 상대경로 = 서버경로 찾아주는 함수 ) 
			// 서버에 build(배포)된 폴더/파일의 경로 찾기
			// request.getSession().getServletContext().getRealPath("프로젝트명이하 경로")
		String uploadPath = request.getSession().getServletContext().getRealPath("/member/img");
		System.out.println("member 폴더 img 폴더 실제(서버)경로 : " + uploadPath);	
		
		// 1. AJAX 통신받은 data요청한다. [request]
		//request.getParameter("form객체전송시input name")
			// MultipartRequest : 파일 업로드 해주는 클래스
		
		MultipartRequest multi = new MultipartRequest( 
				request , 	// 1.요청방식
				uploadPath , // 2.첨부파일을 저장할 폴더 경로
				1024 * 1024 * 10 ,// 3. 첨부파일 용량 허용 범위 [ 바이트 단위 ] 10MB
				"UTF-8" , // 4. 한글 인코딩타입
				new DefaultFileRenamePolicy()	// 5. 만약에 서버 내 첨부파일이 동일한 이름이 있을 때 이름뒤에 숫자를 자동으로 붙이기 [ 보안 ]
				);
		// 첨부파일 전송 했을 때
			// 1. 첨부파일 서버PC에 업로드( COS 라이브러리 )
			
			// 2. form 안에 있는 각 데이터 호출	
		// 일반input : multi.getParameter("form객체전송시 input name")
		// 첨부파일 input : 
		String mid = multi.getParameter("mid"); System.out.println(mid);
		String mpwd = multi.getParameter("mpwd");System.out.println(mpwd);
		String memail = multi.getParameter("memail");System.out.println(memail);
		String mimg = multi.getFilesystemName("mimg");System.out.println(mimg);
		
		// *만약에 사진업로드 안했으면 기본프로필 사용하도록 변경 = default.webp
				if( mimg == null) mimg = "default.webp"; 
		// 2. (선택) 객체화
		MemberDto dto = new MemberDto( mid , mpwd , memail , mimg);
		// 3. Dao에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(dto);
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [respnse]
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}
	// 2. 회원정보 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청하기 [ 기능 구분을 위한 요청 ]
		String type = request.getParameter("type");
		if( type.equals("info")) {
			// 1. 요청한다. [X]
			// 2. 유효성/객체화 [X]
			// 3. Dao 처리 [X]
			// 4. 응답한다.
				// * 세션에 저장된 로그인 객체를 꺼내기
					// 1. 세션호출한다. [ 세션타입은 Object ]
					// 2. 타입변환한다. [ 부 -> 자 (캐스팅/강제타입변환) ]
			Object session = request.getSession().getAttribute("loginDto");
			MemberDto loginDto = (MemberDto)session;
			
				// - DTO는 JS가 이해할 수 없는 언어이므로 JS가 이해할 수 있게 JS 언어로 변환
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(loginDto);
			
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);		
		}else if( type.equals("logout")) {
			// * 세션에 저장된 로그인객체를 없애기/초기화/지우기/삭제
			// 방법1 : (세션의 모든 속성) 초기화하는 함수
				//request.getSession().invalidate(); // 로그인 정보 뿐만 아니라 모두 삭제
			// 방법2 :(세션의 특정 속성) JVM GC(쓰레기수집기 = 해당 객체를 아무도 참조하고 있지 않으면 삭제)
				// 삭제할 세션속성명과 동일하게 null 대입
			request.getSession().setAttribute("loginDto", null);
		}
		
	}
	// 3. 회원 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	// 4. 회원 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
/*
 *  용량 단위
 *  	bit 0 or 1
 *  	byte: 01010101 -> 1byte
 *  	kb : 1024byte -> 1kb
 *  
 * 
 * */

