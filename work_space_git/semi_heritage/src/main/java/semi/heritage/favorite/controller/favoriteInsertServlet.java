package semi.heritage.favorite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.favorite.service.favoriteService;
import semi.heritage.favorite.vo.favoriteMyPageVO;
import semi.heritage.heritageInfo.service.HeritageService;
import semi.heritage.member.vo.Member;

@WebServlet("/favoriteInsert.do")
public class favoriteInsertServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public String getServletName() {
		return "favoriteInsert";
	}

	private favoriteService fservice = new favoriteService();
	private HeritageService hservice = new HeritageService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<favoriteMyPageVO>  favoriteMyPageVO = null;
		int no = 0; 
	
		try {
			no = Integer.parseInt(req.getParameter("hertiageNo")); // jsp에서 문화재 고유번호 받아오기
		} catch (Exception e) {
		}
		System.out.println(no + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		
			HttpSession session = req.getSession(); // HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성합니다
			System.out.println(session.getAttribute("loginMember"));
			Member member = (Member) session.getAttribute("loginMember");

			
			if (member == null) {// 로그인된 멤버가 없으면 로그인하는 창으로 보내주기
				sendCommonPage("로그인후 이용해주세요.", "/views/member/signIn.jsp", req, resp);
				return;
			}
			
			int uNo = member.getUno(); // 로그인 되어있는 멤버객체에서 회원번호 uno를 가져옴
			favoriteMyPageVO  = fservice.selectAll(uNo); //jsp에서 문화재 고유번호 받아서 문화재 객체 찾아오기
			
			int result = fservice.insert(uNo, no);
			System.out.println(result + "!!!!!!!!!!!!!!!!!!!!!!");

//			if (result > 0) {
//				sendCommonPage("찜 등록되었습니다.", "/myPageLike.jsp", req, resp);
//			} else {
//				sendCommonPage("찜 실패하였습니다. (code=101)", "/myPageLike.jsp", req, resp); // 문화재 상세 페이지로 보내주기
//			}
		
//			if (result > 0) {
//				sendCommonPage("찜 등록되었습니다.", "/favoriteMyPage.do", req, resp);
//			} else {
//				sendCommonPage("찜 실패하였습니다. (code=101)", "/favoriteMyPage.do", req, resp); // 문화재 상세 페이지로 보내주기
//			}
////			
		req.setAttribute("favoriteMyPageVO", favoriteMyPageVO);
		req.getRequestDispatcher("/favoriteMyPage.do").forward(req, resp);
		
	}
	
	
	
	
}
