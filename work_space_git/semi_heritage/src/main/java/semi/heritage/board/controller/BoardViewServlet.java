package semi.heritage.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.vo.Board;
import semi.heritage.souvenir.service.BoardService;




//@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService service = new BoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));

		Board board = service.findBoardByNo(boardNo, true);

		if(board == null) {
			resp.sendRedirect(req.getContextPath() + "/");
			return;
		}
		req.setAttribute("board", board);
		req.getRequestDispatcher("/views/board/view.jsp").forward(req, resp);
	}
}
