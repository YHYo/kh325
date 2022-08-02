
package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirCartVO;

	@WebServlet("/myPageCart.do")
	public class SouvenirCartServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private SouvenirService service = new SouvenirService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int uNo = 0;
			List<SouvenirCartVO> list = null;
			
			try {
					uNo = Integer.parseInt(req.getParameter("uNo"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			

			list = service.getCartList(uNo);
			
			req.setAttribute("cart", list);
//			req.setAttribute("pageInfo", pageInfo);
			req.getRequestDispatcher("/views/member/myPageCart.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}

