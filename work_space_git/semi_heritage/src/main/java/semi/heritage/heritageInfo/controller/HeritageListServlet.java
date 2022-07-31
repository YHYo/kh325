package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageMainVO;

//@WebServlet()
public class HeritageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HeritageService service = new HeritageService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		int boardCount = 0;
		PageInfo pageInfo = null;
		List<HeritageMainVO> list = null;

		String ccbaMnm = req.getParameter("ccbaMnm");
		page = Integer.parseInt(req.getParameter("page"));
//		String hrName = req.getParameter("ccbaMnm1"); // jsp에서 검색창에 검색시 어떤 name으로 할건지 정해야함

		boardCount = service.getheritageMainVOCount("ccbaMnm"); // 이름입력해서 게시글 갯수 몇개인지 가져옴
		pageInfo = new PageInfo(page, 8, boardCount, 9); // 하단버튼 8개 , 게시글 9개 보임
		list = service.selectByHeritageName(ccbaMnm, pageInfo);

		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("").forward(req, resp);
//		req.getRequestDispatcher("/views/board/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
