package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.common.util.PageInfo;
import semi.heritage.favorite.service.favoriteService;
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
	private favoriteService fservice = new favoriteService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		int boardCount = 0;
		PageInfo pageInfo = null;
		List<HeritageMainVO> list = null;
		String ccbaMnm = req.getParameter("searchValue");
		int favoriteNum = 0; // 찜개수
		int no = 0; // 문화재 고유번호
		int uNo = 0;

		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {
		}
		boardCount = service.getHeritageMainVOCount(ccbaMnm); // 이름입력해서 게시글 갯수 몇개인지 가져옴
		pageInfo = new PageInfo(page, 8, boardCount, 9); // 하단버튼 8개 , 게시글 9개 보임
		list = service.selectByHeritageName(ccbaMnm, pageInfo);

		List<Integer> favlist = new ArrayList<Integer>();
		for (int j = 0; j < list.size(); j++) {
			favoriteNum = fservice.CountFavoriteByNo(list.get(j).getNo());
			favlist.add(favoriteNum);
		}
		System.out.println(favoriteNum);// 찜갯수 리스트
		
//		 List<Integer> hnolist = new ArrayList<Integer>();
//		 for(int i = 0; i < list.size(); i++){
//			 hnolist.add(list.get(i).getNo());
//			};
//		System.out.println(hnolist);//문화재 고유번호 리스트

//		uNo = fservice.insert(uNo, no);
//		uNo = fservice.delete(uNo, no);

			if (list == null) {
				sendCommonPage("검색 결과가 없습니다", "/index.do", req, resp);
			}

			System.out.println(list);
			req.setAttribute("list", list);
			req.setAttribute("pageInfo", pageInfo);
			req.setAttribute("boardCount", boardCount);
			req.setAttribute("favoriteNum", favoriteNum);
			req.setAttribute("favlist", favlist);
//		req.setAttribute("hnolist", hnolist);
			req.setAttribute("no", no);
//		req.setAttribute("uNo", uNo);
			req.getRequestDispatcher("/views/heritage/heritageSearch.jsp").forward(req, resp); // 문화재 리스트 보여주는 페이지주소
																								// 넣어야함

		}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
