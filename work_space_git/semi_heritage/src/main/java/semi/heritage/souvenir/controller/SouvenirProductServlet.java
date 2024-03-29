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


@WebServlet("/souvenirMain.do")
public class SouvenirProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SouvenirService service = new SouvenirService();
	
	@Override
	public String getServletName() {
		return "SouvenirProductServlet";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("doget 호출 ");
		List<SouvenirProductVO> pList = null;
		List<SouvenirCategoryVO> cList = new ArrayList<SouvenirCategoryVO>();
		
		cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.5.png","생활/데코","홈데코,인테리어","아늑한,따뜻한"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.4.png","패션/잡화","가방,우산","인기많은,주문제작"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.2.png","사무/문구","필기도구,카드","편리한,선물용"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.1.png","유아/DIY","장난감,인형, DIY","귀여운,만들기"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.3.png","뷰티/미용","비누,향수","예쁜,향기로운"));
        cList.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.6.png","전자/IT","폰케이스,그립톡","얼리어답터,유용한,편리한"));
		
		
		pList = service.getProductList();
		
//		System.out.println("list");
//		System.out.println(pList);
		if(pList == null) {
			pList = new ArrayList<SouvenirProductVO>();
		}
		
		System.out.println("!!"+pList);
		
//		req.getRequestDispatcher("/views/souvenir/souvenirMain.jsp").forward(req, resp);
		
		req.setAttribute("listCat", cList);
		req.setAttribute("listIngi", pList);
		req.getRequestDispatcher("/views/souvenir/souvenirMain.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

