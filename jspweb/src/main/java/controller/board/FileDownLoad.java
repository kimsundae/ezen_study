package controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownLoad
 */
@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileDownLoad() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ------------- 1. 다운로드할 파일 경로 찾기 -------------// 
		// 1. 다운로드 할 파일명 요청
			// 1. 다운로드 할 파일명 요청
		String filename = request.getParameter("filename");
			// 2. 첨부파일의 폴더의 경로
		String uploadpath = request.getServletContext().getRealPath("/board/img");
			// 3. 다운로드 할 파일의 전체 경로
		String filepath = uploadpath + "/" + filename;
		//------------2. 응답 파일 옵션 ---------------------//
		response.setHeader(
						"Content-Disposition", // Content-Disposition : 각 브라우저마다 다운로드 형식 HTTP옵션 추가
						"attachment;filename=" + URLEncoder.encode( filename , "UTF-8" ));
		// ------------- 3. 파일 내보내기 ------------------- //
		// 1. 파일 객체화
			File file = new File(filepath); // 해당 경로의 파일 객체화
		// 2. 파일 입력 스트림 객체
			// 1. 입력객체
			FileInputStream fin = new FileInputStream(file);
			// 2. 읽어온 바이트를 저장할 배열 선언
			byte[] bytes = new byte[(int)file.length()];
			// 3. 바이트를 읽어서 배열에 저장하기
			fin.read(bytes);
		// 3. 파일 출력 스트림 객체
			// 1. 파일 출력 스트림 객체 [ 출력할 위치가 respnse ]
			BufferedOutputStream oin = new BufferedOutputStream( response.getOutputStream() );
			//ServletOutputStream oin1 = new ServletOutputStream(  );
			// 2. 파일 내보내기
			oin.write(bytes);
			
		// 4. 대용량 전송 시 안전하게 스트림(바이트이동통로) 닫기
		fin.close(); oin.flush(); oin.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	// 5. 파일 삭제

}
