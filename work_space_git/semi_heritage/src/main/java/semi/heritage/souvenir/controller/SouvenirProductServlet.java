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
		List<SouvenirProductVO> Plist = null;
		
		List<SouvenirCategoryVO> clist = new ArrayList<SouvenirCategoryVO>();
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.1.png","유아/DIY","장난감, 인형, DIY"));
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.2.png","사무/문구","필기도구, 카드"));
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.3.png","뷰티/미용","비누, 향수"));
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.4.png","패션/잡화","가방, 우산"));
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.5.png","생활/데코","홈데코, 인테리어"));
		clist.add(new SouvenirCategoryVO("/resources/img/semi-img/10.souvir.cate.6.png","전자/IT","폰케이스, 그립톡"));
		
		
		
		Plist = service.getProductList();
		System.out.println("list");
		System.out.println(Plist);
		if(Plist == null) {
			Plist = new ArrayList<SouvenirProductVO>();
		}
		
		
//		req.getRequestDispatcher("/views/souvenir/souvenirMain.jsp").forward(req, resp);
		
		req.setAttribute("listCat", clist);
		req.setAttribute("listIngi", Plist);
		req.getRequestDispatcher("/views/souvenir/souvenirMain.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

