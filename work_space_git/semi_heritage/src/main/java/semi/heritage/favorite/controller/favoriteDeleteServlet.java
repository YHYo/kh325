package semi.heritage.favorite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.favorite.service.favoriteService;
import semi.heritage.favorite.vo.favoriteVO;
import semi.heritage.member.vo.Member;

@WebServlet("/favoriteDelete.do")
public class favoriteDeleteServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private favoriteService fservice = new favoriteService();

	@Override
	public String getServletName() {
		return "favoriteDelete";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int no = Integer.parseInt(req.getParameter("no")); // jsp에서 문화재 고유번호 받아오기

		try {
			HttpSession session = req.getSession(); // HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성합니다
			System.out.println(session.getAttribute("loginMember"));
			Member member = (Member) session.getAttribute("loginMember");

//			if (member == null) {// 로그인된 멤버가 없으면 로그인하는 창으로 보내주기
//				sendCommonPage("로그인후 이용해주세요.", "/views/member/signIn.jsp", req, resp);
//				return;
//			}

			int uNo = member.getUno(); // 로그인 되어있는 멤버객체에서 회원번호 uno를 가져옴

			int result = fservice.delete(uNo, no);

			if (result <= 0) {
				sendCommonPage("찜 삭제에 실패하였습니다. (301)", "/member/myPageLike.jsp", req, resp); //마이페이지 찜페이지로 보내주기
			} else {
				sendCommonPage("찜 삭제에 성공하였습니다. (302)", "/member/myPageLike.jsp", req, resp); //마이페이지 찜페이지로 보내주기
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
