package semi.heritage.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import semi.heritage.common.util.MyFileRenamePolicy;
import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.service.MemberService;
import semi.heritage.member.vo.Member;

@WebServlet("/myPageInfo.do")
public class MemberInfoServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberService();

	@Override
	public String getServletName() {
		return "MemberUpdateServlet";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			String userId = member.getUemail();

			Member memberInfo = service.findMemberById(userId);
			System.out.println(memberInfo);
			if (memberInfo != null) {
				req.setAttribute("member", memberInfo);
				req.getRequestDispatcher("/views/member/myPageInfo.jsp").forward(req, resp);
				return;
			}
		} catch (Exception e) {
		}
		resp.sendRedirect(req.getContextPath() + "/");
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
//	}
}
