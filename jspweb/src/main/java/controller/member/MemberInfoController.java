package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. AJAX 통신받은 data요청한다. [request]
		String mid = request.getParameter("mid"); System.out.println(mid);
		String mpwd = request.getParameter("mpwd");System.out.println(mpwd);
		String memail = request.getParameter("memail");System.out.println(memail);
		String mimg = request.getParameter("mimg");System.out.println(mimg);
		// 2. (선택) 객체화
		MemberDto dto = new MemberDto( mid , mpwd , memail , mimg);
		// 3. Dao에게 전달하고 결과 받는다.
		boolean result = MemberDao.getInstance().signup(dto);
		// 4. AJAX 통신으로 결과 데이터를 응답을 보낸다. [respnse]
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
