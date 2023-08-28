package library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Library
 */
@WebServlet("/Library")
public class Library extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Library() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( "checkPhone".equals(request.getParameter("type")) ) {
			int nowNum = Integer.parseInt(request.getParameter("nowNum"));
			String phoneNumber = request.getParameter("phoneNumber");
			boolean result = LibraryDao.getInstance().checkPhone( nowNum , phoneNumber  );
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().print(result);
		}
			
		// Json으로 배열 전송
		ArrayList<LibraryDto> seatArr = LibraryDao.getInstance().showSeat();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArr = objectMapper.writeValueAsString(seatArr);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		    * 입실
		    */
		// 퇴실 함수일 경우
		if( "out".equals(request.getParameter("type"))) {
			int nowNum = Integer.parseInt(request.getParameter("nowNum"));
			boolean result = LibraryDao.getInstance().checkOut(nowNum);
			response.setContentType("application/json;charset=UTF-8");
		    response.getWriter().print(result);
		    return;
		}
		//입실일 경우
		      int seatno = Integer.parseInt(request.getParameter("seatno"));
		      String name = request.getParameter("name");
		      String phonenumber = request.getParameter("phonenumber");

		      System.out.println(" seatno :  "+ seatno );
		      System.out.println(" name :  "+ name );
		      System.out.println(" phonenumber :  "+ phonenumber );

		      LibraryDto libraryDto = new LibraryDto(name, phonenumber, seatno, true);
		      boolean result = LibraryDao.getInstance().checkIn(libraryDto);


		      response.setContentType("application/json;charset=UTF-8");
		      response.getWriter().print(result);
		   
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nowNum = Integer.parseInt(request.getParameter("nowNum"));
		boolean result = LibraryDao.getInstance().checkOut(nowNum);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
