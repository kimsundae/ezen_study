package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;

/**
 * Servlet implementation class BoardInfoController
 */
@WebServlet("/BoardInfoController")
public class BoardInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 첨부파일 업로드 [ cos.jar -> MultipartRequest 클래스 ] 
		
		// 1. (입력받은 매개변수) 요청
		
		// 2. 유효성 검사/ 객체화
		
		// 3. Dao 처리
		 
		// 4. (Dao 결과) 응답
		
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/board/img");
		System.out.println("board 폴더 img 폴더 실제(서버)경로 : " + uploadPath);	
		
		MultipartRequest multi = new MultipartRequest(
				request , 
				uploadPath , // 2.첨부파일을 저장할 폴더 경로
				1024 * 1024 * 10 ,// 3. 첨부파일 용량 허용 범위 [ 바이트 단위 ] 10MB
				"UTF-8" , // 4. 한글 인코딩타입
				new DefaultFileRenamePolicy()	// 5. 만약에	
				);
		
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		int mno = ((MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		int bcno = Integer.parseInt( multi.getParameter("bcno"));
			// - 작성자(mno)는 입력x / 세션
		BoardDto boardDto = new BoardDto(btitle, bcontent , bfile, mno, bcno); System.out.println(boardDto);
		boolean result = BoardDao.getInstance().write(boardDto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
