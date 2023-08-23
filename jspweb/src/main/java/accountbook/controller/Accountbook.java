package accountbook.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import accountbook.model.dao.AccountbookDao;
import accountbook.model.dto.AccountbookDto;

/**
 * Servlet implementation class Accountbook
 */
@WebServlet("/Accountbook")
public class Accountbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accountbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<AccountbookDto> arr = AccountbookDao.getInstance().read();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(arr);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonArray);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acontent = request.getParameter("content");System.out.println(acontent);
		String aprice = request.getParameter("price");System.out.println(aprice);
		String adate = request.getParameter("date");System.out.println(adate);
		AccountbookDto dto = new AccountbookDto( acontent , aprice , adate );
		boolean result = AccountbookDao.getInstance().post(dto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		String acontent = request.getParameter("content");
		String aprice = request.getParameter("price");
		AccountbookDto dto = new AccountbookDto( ano , acontent , aprice );
		boolean result = AccountbookDao.getInstance().update(dto);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ano = Integer.parseInt(request.getParameter("ano"));
		boolean result = AccountbookDao.getInstance().delete(ano);	
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(result);
		
	}

}
