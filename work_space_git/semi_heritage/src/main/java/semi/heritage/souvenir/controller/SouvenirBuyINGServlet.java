package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirBuyVO;

@WebServlet("/myPageBuyING.do")
public class SouvenirBuyINGServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private SouvenirService service = new SouvenirService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Member loginMember = getSessionMember(req);
			
			if(loginMember == null) {
				sendCommonPage("잘못된 접근입니다.", "/", req, resp);
				return;
			}
			
			int result = service.updateBuyING(loginMember.getUno());
			
			if(result > 0) {
				sendCommonPage("구매에 성공하였습니다.", "/myPageOrder.do", req, resp);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sendCommonPage("구매에 실패하였습니다. 문의 부탁 드립니다.", "/myPageCart.do", req, resp);
	}
		
//		int uNo = 0;
//		List<SouvenirBuyVO> BuyINGList = null;
//
//		
//		try {
//			Member loginMember = (Member) getSessionMember(req);
//			uNo = loginMember.getUno();
//			System.out.println(uNo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		BuyINGList = service.updateBuy(uNo);
//
//		req.setAttribute("BuyList", BuyINGList);
//		req.getRequestDispatcher("/views/member/myPageOrder.jsp").forward(req, resp);
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return "SouvenirBuyServlet";
	}

}
