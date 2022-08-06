
package semi.heritage.souvenir.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semi.heritage.common.util.MyHttpServlet;
import semi.heritage.member.vo.Member;
import semi.heritage.souvenir.service.SouvenirService;
import semi.heritage.souvenir.vo.SouvenirCartVO;
import semi.heritage.souvenir.vo.SouvenirProductVO;

//-------------------------- 장바구니 Servlet -------------------------- //


	@WebServlet("/myPageCart.do")
	public class SouvenirCartServlet extends MyHttpServlet {
		private static final long serialVersionUID = 1L;

		private SouvenirService service = new SouvenirService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int uNo = 0;
			List<SouvenirCartVO> cartList = null;
			
			try {
				Member loginMember = (Member)getSessionMember(req);
				uNo = loginMember.getUno();
				System.out.println(uNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			SouvenirProductVO productDetail = service.findProductByNo(productNo);
			cartList = service.getCartList(uNo);
			System.out.println(cartList);
			
//			req.setAttribute("productDetail", productDetail);
			req.setAttribute("cartList", cartList);
			req.getRequestDispatcher("/views/member/myPageCart.jsp").forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}

		@Override
		public String getServletName() {
			// TODO Auto-generated method stub
			return "SouvenirCartServlet";
		}
	}

