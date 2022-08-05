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

@WebServlet("/favoriteMyPage.do") // 마이페이지 찜목록 전체 출력해주는 서블릿
public class favoriteMyPageServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public String getServletName() {
		return "favoriteMyPage";
	}

	private favoriteService fservice = new favoriteService();
	private HeritageService hservice = new HeritageService();
	

	@Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      List<favoriteMyPageVO> fmlist = null;
//	      fmlist = (List<favoriteMyPageVO>) req.getAttribute("favoriteMyPageVO");
	      try {
	         HttpSession session = req.getSession();
	         Member member = (Member) session.getAttribute("loginMember");

	         int uNo = member.getUno(); // 로그인 되어있는 멤버객체에서 회원번호 uno를 가져옴

	         fmlist = fservice.selectAll(uNo); // 마이페이지에 출력할 찜한 문화재 정보 포함된 리스트
	         System.out.println(fmlist + "여기야 여기!!!!!!!!!!!!!!!!!");

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      req.setAttribute("fmlist", fmlist);
	      req.getRequestDispatcher("/views/member/myPageLike.jsp").forward(req, resp);
	   }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
