package hrm;

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

/**
 * Servlet implementation class HrmController
 */
@WebServlet("/HrmController")
public class HrmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( "phoneCheck".equals(request.getParameter("type"))) {			
			boolean result = HrmDao.getInsatance().isPhoneUse(request.getParameter("hphone"));
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
			return;
		}
			
		if("read".equals(request.getParameter("type")) ) {
			ArrayList<HrmDto> result = HrmDao.getInsatance().read();
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonArr = objectMapper.writeValueAsString(result);
			System.out.println(jsonArr);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(jsonArr);
			return;
		}
			
		String uploadPath = request.getSession().getServletContext().getRealPath("/hrm/img");
		MultipartRequest multi = new MultipartRequest(
				request ,
				uploadPath ,
				1024 * 1024 * 10 ,
				"UTF-8" ,
				new DefaultFileRenamePolicy()
		);
		String hname = multi.getParameter("hname");
		String hphone = multi.getParameter("hphone");
		String hrank = multi.getParameter("hrank");
		String himg = multi.getFilesystemName("himg");
		System.out.println(hname+ " " + hphone + " " + hrank + " " + himg);
		HrmDto hrmDto = new HrmDto( hname , hphone , hrank , himg );
		boolean result = HrmDao.getInsatance().regist( hrmDto );	
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
