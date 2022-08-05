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

@WebServlet("/myPageOrder.do")
public class SouvenirBuyServlet extends MyHttpServlet {
	private static final long serialVersionUID = 1L;

	private SouvenirService service = new SouvenirService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uNo = 0;
		List<SouvenirBuyVO> BuyList = null;

		try {
			Member loginMember = (Member) getSessionMember(req);
			uNo = loginMember.getUno();
			System.out.println(uNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		BuyList = service.getBuyList(uNo);

		req.setAttribute("BuyList", BuyList);
		req.getRequestDispatcher("/views/member/myPageOrder.jsp").forward(req, resp);
	}

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
