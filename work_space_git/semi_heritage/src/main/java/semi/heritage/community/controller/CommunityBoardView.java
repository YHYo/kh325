package semi.heritage.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import semi.heritage.community.service.CommunityBoardService;
import semi.heritage.community.vo.CommunityBoard;

@WebServlet("/community/view")
public class CommunityBoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommunityBoardService service = new CommunityBoardService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String type = req.getParameter("type");
		
		CommunityBoard board = service.findBoardByNo(boardNo, true, type);
		
		if(board == null) {
			resp.sendRedirect(req.getContextPath() + "/views/community/communityMain.jsp");
			return;
		}
		
		req.setAttribute("board", board);
		req.getRequestDispatcher("/views/community/communityBoardView.jsp").forward(req, resp);
	}
	

}
