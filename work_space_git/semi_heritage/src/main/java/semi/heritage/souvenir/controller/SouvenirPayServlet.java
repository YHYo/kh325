package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirPayVO;

@WebServlet("/souvenirPay.do")
public class SouvenirPayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private SouvenirService service = new SouvenirService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<SouvenirPayVO> list = null;
		int uNo = Integer.parseInt(req.getParameter("uNo"));
		SouvenirPayVO pay = service.getPayList(uNo);
		
		req.setAttribute("userNumber", pay);
		req.getRequestDispatcher("/views/souvenir/souvenirCheckout.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
