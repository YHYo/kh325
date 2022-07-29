package semi.heritage.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.heritage.member.service.MemberService;
import semi.heritage.member.vo.Member;

@WebServlet(name="login", urlPatterns = "/login")
public class MemberSignInServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private MemberService service = new MemberService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 패턴 1. 파라메터 읽어오기
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
//		String saveId = req.getParameter("saveId");
		System.out.println(userId + ", " + userPwd);
		
		// 쿠키 저장 기능
//		saveCookie(resp,saveId,userId);
		
		// 패턴2. 파라메터 처리를 위한 서비스 호출
		Member loginMember = service.login(userId, userPwd);
		
		// 패턴3. 응답할 페이지를 선택하고 파라메터 셋팅하기
		if(loginMember != null) { // 로그인 성공 경우
			// 세션에 로그인 결과를 남기고, 브라우저가 종료 될때까지 로그인 상태를 유지
			HttpSession session = req.getSession();
			session.setAttribute("loginMember", loginMember); // 로그인 정보를 세션에 저장
			resp.sendRedirect(req.getContextPath() + "/"); // 처음 페이지로 리다이렉트 시킴
			// 이래야 기존 로그인폼을 로그인 성공 폼으로 변경 시킴
		}else{ // 로그인 실패한 경우
			// 로그인이 실패하면, 실패 결과를 알려주고 시작페이지로 이동한다.
			req.setAttribute("msg", "사용자 아이디나 비밀번호가 맞지 않습니다!!");
			req.setAttribute("location", "/");
			
			// 공통페이지로 이동하여 실패 결과 알리고 처음페이지로 돌아가는 코드
			// 메세지를 넘겨야함으로 forward로 넘겨야함
			req.getRequestDispatcher("/views/common/msg.jsp").forward(req, resp);
		}
	}
	
//	private void saveCookie(HttpServletResponse resp, String saveId, String userId) {
//		// id를 쿠키로 저장하여 사용자가 다시 브라우저에 온 경우 id가 저장되도록 하는 기능
//		if(saveId != null) {
//			Cookie c = new Cookie("saveId", userId); // 사용자 ID를 쿠키로 구움
//			c.setMaxAge(60*60); // 1시간
//			resp.addCookie(c);
//		} else { // 저장 안함 옵션일때
//			Cookie c = new Cookie("saveId", ""); // 아이디 초기화
//			c.setMaxAge(0); // 시간도 0으로 초기화
//			resp.addCookie(c);
//		}
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+"/");
	}
}
