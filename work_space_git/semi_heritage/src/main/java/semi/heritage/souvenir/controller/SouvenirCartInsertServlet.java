
package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirCartVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;


/**
 * 1. get 요청이 올 경우 -> 회원가입 페이지로 이동
 * 2. post 요청이 올 경우 -> 회원가입 기능 동작...?
 */
@WebServlet("/member/myPageCart.do")
public class SouvenirCartInsertServlet extends MyHttpServlet{
	private static final long serialVersionUID = 1L;
	
	private SouvenirService service = new SouvenirService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
//		try {
//			Member loginMember = getSessionMember(req);
//			
//			if(loginMember != null) { //로그인이 되어있을 경우
//				req.getRequestDispatcher("/member/myPageCart.do").forward(req, resp);
//				
//				//req.getRequestDispatcher("/views/board/write.jsp").forward(req, resp);
//				return;
//			}
//		} catch (Exception e) {}
//		sendCommonPage("로그인 이후 사용할수 있습니다.", "/", req, resp);		
//		
//		resp.sendRedirect(req.getContextPath() + "/views/souvenir/enroll.jsp");
//		doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SouvenirCartVO insert = new SouvenirCartVO();
//		List<SouvenirCartVO> list = new ArrayList<SouvenirCartVO>();
		SouvenirProductVO SVO = new SouvenirProductVO();
		
		try {
			
			HttpSession session = req.getSession(); //HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성합니다
			System.out.println(session.getAttribute("loginMember"));
			Member member = (Member) session.getAttribute("loginMember");
			
			if(member == null) {
				sendCommonPage("로그인후 이용해주세요.", "/views/main/index.jsp", req, resp);
				return;
			}
			int productNo = Integer.parseInt(req.getParameter("productNo"));
			
			SVO = service.findProductByNo(productNo);
			int userno = member.getUno();
			
			
			int result = service.insertCart(SVO, userno);
			
			if(result > 0) {
				sendCommonPage("찜 등록되었습니다.", "/souvenirProductsList.do", req, resp);
				
			}else {
				sendCommonPage("찜 실패하였습니다. (code=101)", "/souvenirProductsList.do", req, resp);
			}
			
			
			
			
// 마이페이지 리스트 수정할때 한번 싸봐라			
//			int userno = member.getUno();
//			System.out.println(userno);
//			
//			list = service.getCartList(userno);
//			System.out.println(list.toString());
//			
//			req.setCharacterEncoding("UTF-8");
//			req.setAttribute("list", list);
//			req.getRequestDispatcher("/views/member/myPageCart.jsp").forward(req, resp);
	//----------------------------------------		
			
			
//			insert.setUno(Integer.parseInt(req.getParameter("uno")));
//			insert.setSouv_pro_no(Integer.parseInt(req.getParameter("souv_pro_no")));
//			insert.setSouv_pro_name(req.getParameter("souv_pro_name").trim());
//			insert.setSouv_pro_price(Integer.parseInt(req.getParameter("souv_pro_price").strip()));
//			insert.setSouv_pro_category(req.getParameter("souv_pro_category").strip());
////			insert.setBuy_status(req.getParameter("buy_status"));
////			insert.setDelete_status(req.getParameter("delete_status"));
//			insert.setSouv_pro_url(req.getParameter("souv_pro_url").strip());
//			
//			int result = service.insertCart(insert);
//			
//			if(result > 0) {
//				req.setAttribute("msg", "장바구니에 추가됐습니다");
//				req.setAttribute("location", "/");
//			}else {
//				req.setAttribute("msg", "실패하였습니다 (code:101=DB이슈)");
//				req.setAttribute("location", "/");
//			}
//			req.getRequestDispatcher("/views/common/msg.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public String getServletName() {
		return "SouvenirCartInsertServlet";
	}
	
}
