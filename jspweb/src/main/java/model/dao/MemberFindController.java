package model.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	}

}
