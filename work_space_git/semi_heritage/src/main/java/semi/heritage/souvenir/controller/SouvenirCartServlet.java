
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

	@WebServlet("/myPageCart.do")
	public class SouvenirCartServlet extends MyHttpServlet {
		private static final long serialVersionUID = 1L;

		private SouvenirService service = new SouvenirService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int uNo = 0;
			List<SouvenirCartVO> list = null;
			
			try {
				Member loginMember = (Member)getSessionMember(req);
				uNo = loginMember.getUno();
				System.out.println(uNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			

			list = service.getCartList(uNo);
			
			req.setAttribute("cartList", list);
//			req.setAttribute("pageInfo", pageInfo);
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

