package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirProductVO;


@WebServlet("/product/detail")
public class SouvenirProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SouvenirService service = new SouvenirService();
	
	@Override
	public String getServletName() {
		return "SouvenirProductDetailServlet";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<SouvenirProductVO> list = null;
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		SouvenirProductVO p = service.findProductByNo(productNo);
		

		
		req.setAttribute("product", p);
		req.getRequestDispatcher("/views/souvenir/souvenirProductsDetail.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
