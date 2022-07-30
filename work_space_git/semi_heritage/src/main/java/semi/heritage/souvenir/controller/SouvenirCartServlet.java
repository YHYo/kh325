package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.PageInfo;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.Souvenir_Cart_VO;

//	@WebServlet("/cart/list")
	public class SouvenirCartServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

//		private BoardService service = new BoardService();
		private SouvenirService service = new SouvenirService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int uNo = 0;
//			int boardCount = 0;
//			PageInfo pageInfo = null;
			List<Souvenir_Cart_VO> list = null;
			
			try {
				
					uNo = Integer.parseInt(req.getParameter("uNo"));
				}
			} catch (Exception e) {}
			
			boardCount = service.getBoardCount(searchMap);
			pageInfo = new PageInfo(page, 10, boardCount, 10);
//			pageInfo = new PageInfo(page, 4, boardCount, 10); // 페이지(하단 페이지 버튼)가 4개로 보인다.
//			pageInfo = new PageInfo(page, 10, boardCount, 20); // 게시글이 20개로 보인다.
			list = service.getCartList(uNo);
			
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
