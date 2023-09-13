package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

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
		//[form 없는 경우1]
			// 1. ajax 전달한 data의 객체 속성명을 이용한 호출
		/*
		 * String pname1 = request.getParameter("pname1"); String pcontent1 =
		 * request.getParameter("pcontent1"); System.out.println(pname1);
		 * System.out.println(pcontent1);
		 */
		
		// [form 태그 이용하는 경우 2- 첨부파일 없음]
		MultipartRequest multi = new MultipartRequest(request, request.getServletContext().getRealPath("/product"));
		
		String pname2 = multi.getParameter("pname2");
		String pcontent2 = multi.getParameter("pcontent2");
		System.out.println(pname2); System.out.println(pcontent2);
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
