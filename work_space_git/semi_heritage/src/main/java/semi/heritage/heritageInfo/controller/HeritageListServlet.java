package semi.heritage.heritageInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.common.util.PageInfo;
import semi.heritage.favorite.service.favoriteService;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.heritageInfo.vo.HeritageMainVO;
import semi.heritage.heritageInfo.vo.HeritageVO;

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
//		int boardCount = 0;
		int getFindAllCount = 0;
		
		PageInfo pageInfo = null;
//		List<HeritageMainVO> list = null;
		List<HeritageVO> findAllList = null;
		
		String ccbaMnm = req.getParameter("searchValue");
		
		String ccbaCtcdNm[] = req.getParameterValues("region"); // 지역코드
		if (ccbaCtcdNm == null) {
		} else {
			Map<String, String> region = new HashMap<>();
			for (String regions : ccbaCtcdNm) {
				if (regions == null) {
					regions = null;
				}
			}
		}
		
		String gcodeName[] = req.getParameterValues("type"); // 문화재 분류
		if (gcodeName == null) {
		} else {
			Map<String, String> type = new HashMap<>();
			for (String types : gcodeName) {
				if (types == null) {
					types = null;
				}
			}
		}
		
		String ccmaName[] = req.getParameterValues("designated");// 지정종목
		if (ccmaName == null) {
		} else {
			Map<String, String> designated = new HashMap<>();
			for (String designateds : ccmaName) {
				if (designateds == null) {
					designateds = null;
				}
			}
		}
		
		String ccceName[] = req.getParameterValues("age");// 시대
		if (ccceName == null) {
		} else {
			Map<String, String> age = new HashMap<>();
			for (String ages : ccceName) {
				if (ages == null) {
					ages = null;
				}
			}
		}
	
		String startYear = req.getParameter("startYear");
		String endYear = req.getParameter("endYear");
		
		
	

		try {
			page = Integer.parseInt(req.getParameter("page"));
		} catch (Exception e) {
		}
		
//		boardCount = service.getHeritageMainVOCount(ccbaMnm); // 메인에서 이름입력해서 게시글 갯수 몇개인지 가져옴
		getFindAllCount = service.getFindAllCount(ccbaMnm, ccbaCtcdNm, gcodeName, ccmaName, ccceName, startYear, endYear); // 검색 리스트 개수
		pageInfo = new PageInfo(page, 8, getFindAllCount, 9); // 하단버튼 8개 , 게시글 9개 보임
//		list = service.selectByHeritageName(ccbaMnm, pageInfo);
		findAllList = service.findAll(pageInfo, ccbaMnm, ccbaCtcdNm, gcodeName, ccmaName, ccceName, startYear, endYear);

		
		
//		int favoriteNum = 0; // 찜개수
		int allFavoriteNum= 0;
		int no = 0; // 문화재 고유번호
		int uNo = 0;
		
//		List<Integer> favlist = new ArrayList<Integer>();
//		for (int j = 0; j < list.size(); j++) {
//			favoriteNum = fservice.CountFavoriteByNo(list.get(j).getNo());
//			favlist.add(favoriteNum);
//		}
		
		List<Integer> allFavlist = new ArrayList<Integer>();
		for (int j = 0; j < findAllList.size(); j++) {
			allFavoriteNum = fservice.CountFavoriteByNo(findAllList.get(j).getNo());
			allFavlist.add(allFavoriteNum);
		}
//		System.out.println(favoriteNum);// 찜갯수 리스트
		
//		 List<Integer> hnolist = new ArrayList<Integer>();
//		 for(int i = 0; i < list.size(); i++){
//			 hnolist.add(list.get(i).getNo());
//			};
//		System.out.println(hnolist);//문화재 고유번호 리스트

//		uNo = fservice.insert(uNo, no);
//		uNo = fservice.delete(uNo, no);
//
//			if (list == null) {
//				sendCommonPage("검색 결과가 없습니다", "/index.do", req, resp);
//			}

//			System.out.println(list);
//			req.setAttribute("list", list);
			req.setAttribute("findAllList", findAllList);
			req.setAttribute("pageInfo", pageInfo);
//			req.setAttribute("boardCount", boardCount);
			req.setAttribute("getFindAllCount", getFindAllCount);
//			req.setAttribute("favoriteNum", favoriteNum);
			req.setAttribute("allFavoriteNum", allFavoriteNum);
//			req.setAttribute("favlist", favlist);
			req.setAttribute("allFavlist", allFavlist);
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
