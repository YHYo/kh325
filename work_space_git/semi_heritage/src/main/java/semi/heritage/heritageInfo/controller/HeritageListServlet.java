package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageMainVO;


@WebServlet("/heritageSearch.do")
public class HeritageListServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getServletName() {
		return "HeritageListServlet";
	}

	private HeritageService service = new HeritageService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		int boardCount = 0;
		PageInfo pageInfo = null;
		List<HeritageMainVO> list = null;
//		Map<String, String> searchMap = new HashMap<>();

//		try {
//			String searchValue = req.getParameter("searchValue");
//			if (searchValue != null && searchValue.length() > 0) {
//				String searchType = req.getParameter("searchType");
//				searchMap.put(searchType, searchValue);
//			}
//			page = Integer.parseInt(req.getParameter("page"));
//		} catch (Exception e) {
//		}

		String ccbaMnm = req.getParameter("ccbaMnm").trim();
		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {
		}
		System.out.println(list);
		if (list == null) {
			sendCommonPage("검색 결과가 없습니다", "/index.do" , req, resp);
		}	

		boardCount = service.getHeritageMainVOCount("ccbaMnm"); // 이름입력해서 게시글 갯수 몇개인지 가져옴
		pageInfo = new PageInfo(page, 8, boardCount, 9); // 하단버튼 8개 , 게시글 9개 보임
		list = service.selectByHeritageName(ccbaMnm, pageInfo);

		req.setAttribute("list", list);
		req.setAttribute("pageInfo", pageInfo);
		req.getRequestDispatcher("/views/heritage/heritageSearch.jsp").forward(req, resp);// 문화재 리스트 보여주는 페이지주소 넣어야함
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}



}
