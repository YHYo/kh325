package semi.heritage.community.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.PageInfo;
import semi.heritage.community.service.communityBoardService;
import semi.heritage.community.vo.communityBoard;

@WebServlet("/community/list")
public class communityBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private communityBoardService service = new communityBoardService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		int boardCount = 0;
		PageInfo pageInfo = null;
		List<communityBoard> list = null;
		String type = "F";
		Map<String, String> searchMap = new HashMap<>();
		
		try {
			String searchValue = req.getParameter("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = req.getParameter("searchType");
				searchMap.put(searchType, searchValue);
			}
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {
			
		}
		
		boardCount = service.getBoardCount(searchMap, type);
		pageInfo = new PageInfo(page, 10, boardCount, 10);
//		pageInfo = new PageInfo(page, 30, boardCount, 10); // 페이지(하단 페이지 버튼)가 30개로 보인다.
//		pageInfo = new PageInfo(page, 10, boardCount, 20); // 게시글이 20개로 보인다.
		list = service.getBoardList(pageInfo, searchMap, type);
		
		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/views/board/freeBoard.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
