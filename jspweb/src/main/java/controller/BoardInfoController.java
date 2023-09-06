package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dto.BoardDto;
import model.dto.MemberDto;
import model.dto.PageDto;

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
		// 1. 요청
		String type = request.getParameter("type");		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		
		if( type.equals("1") ) {
			
			//----------- 1. 카테고리 ---------------//
			int bcno = Integer.parseInt(request.getParameter("bcno"));
			//----------- 2. 출력할 게시물수/하나의 페이지의 최대 게시물 수 -----------//
			int listsize = Integer.parseInt(request.getParameter("listsize"));
			//------------ 3. 페이징 처리 하기 ------------//
			int page = Integer.parseInt(request.getParameter("page"));
				// 1. 페이지별 레코드의 시작번호
			int startrow = (page-1)*listsize; // 페이지번호*최대게시물수
				// 1*10 => 10
				// 2*10 => 20
			// ---------------- 4. 마지막 페이지번호 --------------- //
				// 1. 마지막페이지번호/총 페이지 수 = 전체 게시물 수 / 페이지별 게시물 수 
				// 2. 전체게시물 수
			int totalsize = BoardDao.getInstance().getTotalSize(bcno);
				// 3. 마지막 페이지 번호/총 페이지 수 
			int totalpage = totalsize%listsize == 0 ? 		// 만약에 나머지가 없으면
								totalsize/listsize : 		// 몫
									totalsize/listsize + 1;	// 몫 + 1
			
			// --------------- 5. 페이지 번호 버튼 시작번호 , 마지막 번호 --------------//
			
			// 1. 페이지 버튼 번호의 쵀대개수
			int btnsize = 5;
			// 2. 페이지버튼 번호의 시작번호
			int startbtn = ( (page-1) / btnsize ) * btnsize + 1;
			// 3. 페이지버튼 번호의 마지막번호
			int endbtn = startbtn+(btnsize-1);
				// 단 마지막 번호는 총페이지수보다 커질 수 없음
				// 만약에 마지막 번호가 총 페이지수보다 크거나 같으면 총페이지 수로 제한두기
			if( endbtn >= totalpage) endbtn = totalpage;
			
			// ------------ pageDto 구성 -------------- //
			
			
			ArrayList<BoardDto> result = BoardDao.getInstance().listRead( bcno , listsize , startrow);
			PageDto pageDto = new PageDto(
					page , listsize , startrow , totalsize , totalpage , startbtn, endbtn, result
					);
					
					
			json = objectMapper.writeValueAsString(pageDto);
	
						
		}else if( type.equals("2")) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDto result = BoardDao.getInstance().getBoard(bno);
				// 3. 만약에 (로그인 혹은 비로그인 ) 요청한 사람과 게시물 작성한 사람과 동일하면
					// 로그인 정보[세션]
			Object object = request.getSession().getAttribute("loginDto");
			if( object == null )
				result.setIshost(false);
			else {
				MemberDto login = (MemberDto)object;
				// 내가 쓴 글
				if( login.getMno() == result.getMno())result.setIshost(true);
				else result.setIshost(false);		
			}
				
			json = objectMapper.writeValueAsString(result);
		}
			// 공통 로직
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(json);
		
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

		// 1. 수정할 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/board/img") ,
				1024 * 1024 * 10,
				"UTF-8", 
				new DefaultFileRenamePolicy()
				);
		// 2. 수정할 데이터 요청
		int bcno = Integer.parseInt( multi.getParameter("bcno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 2. 수정할 게시물 식별키
		int bno = Integer.parseInt( multi.getParameter("bno"));
		BoardDto updateDto = new BoardDto(bno, btitle, bcontent, bfile, bcno);
		// * 만약에 새로운 첨부파일이 없으면 기존 첨부파일 그대로 사용
		if( updateDto.getBimg() == null )
			// 기존 첨부파일
			updateDto.setBimg(BoardDao.getInstance().getBoard(bno).getBimg()); 
		
		// 3. Dao
		boolean result = BoardDao.getInstance().onUpdate(updateDto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt( request.getParameter("bno") );
		boolean result = BoardDao.getInstance().onDelete(bno);
		
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

}
