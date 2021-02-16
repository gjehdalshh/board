package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardReg")
public class BoardRegSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/boardReg.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String strI_board = request.getParameter("i_board");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int i_board = Integer.parseInt(strI_board);
		
		System.out.println("i_board : " + strI_board);
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insBoard(new BoardVO(i_board, title, ctnt, "11-25", "11-25"));
		
		response.sendRedirect("/BoardList");
	}

}















