package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.member.service.MemberService;
import semi.heritage.souvenir.vo.SouvenirBuyVO;

@WebServlet("/souvenirBuy.do")
public class SouvenirBuyServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService service = new MemberService();
		
		List<SouvenirBuyVO> list = null;
		int uNo = Integer.parseInt(req.getParameter("uNo"));
		SouvenirBuyVO buy = service.getBuyList(uNo);
		
		req.setAttribute("productOrder", buy);
		req.getRequestDispatcher("/views/member/myPageOrder.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	

			
			
}
