
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

	@WebServlet("/souvenirMain.do")
	public class SouvenirCategoryServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private SouvenirService service = new SouvenirService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			List<SouvenirCategoryVO> list = new ArrayList<SouvenirCategoryVO>();
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.1.png","유아/DIY","장난감, 인형, DIY"));
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.2.png","사무/문구","필기도구, 카드"));
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.3.png","뷰티/미용","비누, 향수"));
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.4.png","패션/잡화","가방, 우산"));
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.5.png","생활/데코","홈데코, 인테리어"));
			list.add(new SouvenirCategoryVO("request.getContextPath()/resources/img/naim/10.souvir.cate.6.png","전자/IT","폰케이스, 그립톡"));
			
			
			req.setAttribute("listCat", list);
			req.getRequestDispatcher("/views/member/myPageCart.jsp").forward(req, resp);
			
			System.out.println(list);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}

