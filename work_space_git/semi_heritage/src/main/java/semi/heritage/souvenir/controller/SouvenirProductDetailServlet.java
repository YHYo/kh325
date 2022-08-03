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
import semi.heritage.souvenir.vo.SouvenirCategoryVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;


@WebServlet("/souvenirProductsDetail.do")
public class SouvenirProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SouvenirService service = new SouvenirService();
	
	@Override
	public String getServletName() {
		return "SouvenirProductDetailServlet";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SouvenirProductVO> pList = null;
		List<SouvenirCategoryVO> cList = new ArrayList<SouvenirCategoryVO>();
		
		
		int productNo = Integer.parseInt(req.getParameter("productNo"));
		System.out.println("productNo : " + productNo);
		String productName = req.getParameter("productName");
		System.out.println("productName : " + productName);
		
		SouvenirProductVO productDetail = service.findProductByNo(productNo);
//			SouvenirProductVO p = new SouvenirProductVO(1, "반가사유상 미니어처 83호", 100000, "생활/데코", "https://www.museumshop.or.kr/center/files/upload/20220405/20220405164836_ishyxcqo.jpg");
		
		cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.5.png","생활/데코","홈데코, 인테리어","아늑한, 따뜻한"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.4.png","패션/잡화","가방, 우산","인기많은, 주문제작"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.2.png","사무/문구","필기도구, 카드","편리한, 선물용"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.1.png","유아/DIY","장난감, 인형, DIY","귀여운, 만들기"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.3.png","뷰티/미용","비누, 향수","예쁜, 향기로운"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.6.png","전자/IT","폰케이스, 그립톡","얼리어답터, 유용한, 편리한"));

		pList = service.getProductList();
		
		try {
			if(pList == null) {
			pList = new ArrayList<SouvenirProductVO>();
		}
		
			
		} catch (Exception e) {
			
		}
		
		
		
		req.setAttribute("productDetail", productDetail);
		req.setAttribute("cList", cList);
		req.setAttribute("pList", pList);
		req.getRequestDispatcher("/views/souvenir/souvenirProductsDetail.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

