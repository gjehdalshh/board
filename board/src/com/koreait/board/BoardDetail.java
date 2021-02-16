package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strI_board = request.getParameter("i_board");	
		System.out.println("i_board : " + strI_board);
		
		//DB통신
		BoardDAO dao = BoardDAO.getInstance();
		int i_board = Integer.parseInt(strI_board);		
		BoardVO data = dao.selBoard(i_board);
		
		//값 전달 servlet > jsp
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/jsp/boardDetail2.jsp";		
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
