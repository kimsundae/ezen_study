package controller.product;

import java.io.File;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;



/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 1. 제품 등록
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 2. 제품 조회
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// commons-io.jar , commons-fileupload.jar 빌드 필요!!	
		// 옵션 1.요청방식 2.저장위치 3.용량 4.한글인코딩 5.파일명중복일때	
		// 1. 저장경로
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		// 2. 업로드 객체 [ import org.apache.commons.fileupload.FileItem ]
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository( new File(uploadPath) ); // 2. 저장위치
		itemFactory.setSizeThreshold( 1024 * 1024 * 1024 ); // 3. 용량
		itemFactory.setDefaultCharset("UTF-8"); // 4. 한글인코딩
		
		
		
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
