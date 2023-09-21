package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dto.MemberDto;
import model.dto.mpointDto;

/**
 * Servlet implementation class PointController
 */
@WebServlet("/PointController")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String type = request.getParameter("type");
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		
		if("getPoint".equals(type)) {		
			response.getWriter().print(MemberDao.getInstance().getPoint(mno));
		}		
		else if("getPointList".equals(type)) {
			response.getWriter().print(
					new ObjectMapper().writeValueAsString( 
							MemberDao.getInstance().getPointList(mno) ));
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpno = UUID.randomUUID().toString(); // 포인트내역 식별번호 구성 [ UUID ]
			// UUID.randomUUID() : (s)
			System.out.println( mpno );
			// 현재 위치는 서블릿이므로 서블릿 세션
		int mno = ( (MemberDto)request.getSession().getAttribute("loginDto")).getMno();
		// 3. 포인트 수령 / 지급내역은 js에서 전달받음		
		long mpamount = Long.parseLong(request.getParameter("mpamount"));
		String mpcomment = request.getParameter("mpcomment");
		
		boolean result = MemberDao.getInstance().setPoint(new mpointDto(mpno, mno,mpamount,mpcomment , null) );
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
