package controller.board;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
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
		String uploadpath = request.getServletContext().getRealPath("/board/upload");
			// 3. 다운로드 할 파일의 전체 경로
		String filepath = uploadpath + "/" + filename;
		
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
			// 2. 파일 내보내기
			oin.write(bytes);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
