package semi.heritage.souvenir.controller;




import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.board.model.vo.Board;
import semi.heritage.souvenir.service.Souvenir_Cart_Service;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;



//	@WebServlet("/board/list")
	public class Souvenir_Cart_Servlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

//		private BoardService service = new BoardService();
		private Souvenir_Cart_Service service = new Souvenir_Cart_Service();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int page = 1;
			int boardCount = 0;
			PageInfo pageInfo = null;
			List<Board> list = null;
			Map<String, String> searchMap = new HashMap<>();
			
			try {
				String searchValue = req.getParameter("searchValue");
				if(searchValue != null && searchValue.length() > 0) {
					String searchType = req.getParameter("searchType");
					searchMap.put(searchType, searchValue);
				}
				page = Integer.parseInt(req.getParameter("page"));
			} catch (Exception e) {}
			
			boardCount = service.getBoardCount(searchMap);
			pageInfo = new PageInfo(page, 10, boardCount, 10);
//			pageInfo = new PageInfo(page, 4, boardCount, 10); // 페이지(하단 페이지 버튼)가 4개로 보인다.
//			pageInfo = new PageInfo(page, 10, boardCount, 20); // 게시글이 20개로 보인다.
			list = service.getBoardList(pageInfo, searchMap);
			
			req.setAttribute("list", list);
			req.setAttribute("pageInfo", pageInfo);
			req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}
}
