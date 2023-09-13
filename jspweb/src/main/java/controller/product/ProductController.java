package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.dto.ProductDto;



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
		
		// 3. 파일 업로드 객체
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		// 4. 파일 업로드 요청[ 요청방식 : request ]
		try {
			
			Map<Integer, String > imgList = new HashMap<>();
			// form 전송 시 input/select/textarea 등 태그의 모든 데이터 한번에 요청해서 결과를 List 반환
			List<FileItem> fileList = fileUpload.parseRequest(request); 
		
			int i = 0;
			// 5. 업로드 실행
			for( FileItem item : fileList ) {
				
				// 1. 일반 필드 [ isFormField() : 만약에 일반폼필드이면 true / 아니고 첨부파일필드이면 false ]
				if( item.isFormField()) {
					System.out.println(item.toString());
				}
				else { // 2.file필드
					// 만약에 파일 필드이면 업로드 진행
					System.out.println("업로드할 파일명 : " + item.getName());
					System.out.println(new File(uploadPath + "/" + item.getName()));
					// 6.
					item.write(new File(uploadPath + "/" + item.getName())); // 파일 업로드할 경로를 file 타입으로 제공	
					// 7. 업로드 된 파일명을 Map에 저장[ -DB에 저장하려고 ]
					i++;
					imgList.put( i ,  item.getName());
				}	
			}
			ProductDto productDto = new ProductDto(
									Integer.parseInt(fileList.get(0).getString()) ,
									fileList.get(1).getString(),
									fileList.get(2).getString(),
									Integer.parseInt(fileList.get(3).getString()),
									null,null,0,null);
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
