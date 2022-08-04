package semi.heritage.favorite.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import semi.heritage.common.util.MyFileRenamePolicy;
import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.favorite.service.favoriteService;
import semi.heritage.favorite.vo.favoriteMyPageVO;
import semi.heritage.member.vo.Member;

@WebServlet("/favoriteMyPage.do") // 마이페이지 찜목록 전체 출력해주는 서블릿
public class favoriteMyPageServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public String getServletName() {
		return "favoriteMyPage";
	}

	private favoriteService fservice = new favoriteService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<favoriteMyPageVO> fmlist = null;
		
		try {
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");

			int no = Integer.parseInt(req.getParameter("no")); // jsp에서 문화재 고유번호 받아오기
			int uNo = member.getUno(); // 로그인 되어있는 멤버객체에서 회원번호 uno를 가져옴

			fmlist = fservice.selectAll(uNo); //마이페이지에 출력할 찜한 문화재 정보 포함된 리스트
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("fmlist", fmlist);
		req.getRequestDispatcher("/views/member/myPageLike.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
